
use Sep4;
use DW_STAGING;

go
--- 1. INSERT INTO changed TABLE
Insert into [DW_STAGING].[dbo].[changed_Room]
(
Room_ID, room_name, device_name
)

(
--- today
select  
  a.id, a.room_name ,  b.device_name
	  FROM Sep4.dbo.room a JOIN Sep4.dbo.device b 
	  ON a.device_id = b.id
)

EXCEPT
(
--- yesterday

select Room_ID , room_name, device_name 
from 
[DW].[dbo].[Room_D] 

)

EXCEPT 
(

select  
  a.id, a.room_name ,  b.device_name
	  FROM Sep4.dbo.room a JOIN Sep4.dbo.device b 
	  ON a.device_id = b.id

where a.id NOT In (SELECT  
Room_ID
FROM
[DW].[dbo].[Room_D] )

)


go 



use DW;

--- 2. Update exsisting row in dimension table
 update Room_D 
 SET ValidTo = '05/05/2019'   --- last Updated
WHERE Room_ID IN
(SELECT Room_ID
FROM [DW_STAGING].[dbo].[changed_Room]

)


--- 3. Insert new row in dimension table
 UPDATE [DW_STAGING].[dbo].[changed_Room] SET room_name = 'NO VALUE' WHERE room_name IS NULL;

 insert into [DW].[dbo].[Room_D] 
 (
 Room_ID, room_name, device_name, ValidFrom, Validto
 )
 select 

 Room_Id , room_name, device_name , '05/06/2019', '05/06/2019' ---- last updated + 1

 FROM [DW_STAGING].[dbo].[changed_Room] 

 go;

 SELECT * FROM [DW_STAGING].[dbo].[changed_Room]
 GO


 Delete From [DW_STAGING].[dbo].[changed_Room]


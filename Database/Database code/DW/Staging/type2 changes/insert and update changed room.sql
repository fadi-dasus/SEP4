
use Sep4_GroupX2;
use DW_STAGING;

go
--- 1. INSERT INTO changed TABLE
Insert into [DW_STAGING].[dbo].[changed_Room]
(
Room_ID, room_name, device_name
)

(
--- today
select r.id, r.room_name, d.device_name from 
[Sep4_GroupX2].[dbo].[room] as r, 
[Sep4_GroupX2].[dbo].[device] as d
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

select r.id, r.room_name, d.device_name from 
[Sep4_GroupX2].[dbo].[room] as r, 
[Sep4_GroupX2].[dbo].[device] as d  

where r.id NOT In (SELECT  
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

 Delete From [DW_STAGING].[dbo].[changed_Room]
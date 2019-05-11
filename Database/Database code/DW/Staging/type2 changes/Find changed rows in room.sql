use Sep4;
go 
(

--- today
select  
  a.id, a.room_name ,  b.device_name
	  FROM Sep4.dbo.room a JOIN Sep4.dbo.device b 
	  ON a.device_id = b.id

)

Except 
(
--- yesterday
select Room_ID , room_name, device_name 
from 
[DW].[dbo].[Room_D] 
) 

EXCEPT 

( select  
  a.id, a.room_name ,  b.device_name
	  FROM Sep4.dbo.room a JOIN Sep4.dbo.device b 
	  ON a.device_id = b.id  

where a.id NOT In (SELECT  
Room_ID
FROM
[DW].[dbo].[Room_D] ))



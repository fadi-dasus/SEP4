use Sep4_GroupX2;
go 
(

--- today
select r.id, r.room_name, d.device_name from 
dbo.room as r, 
dbo.device as d

)

Except 
(
--- yesterday
select Room_ID , room_name, device_name 
from 
[DW].[dbo].[Room_D] 
) 

EXCEPT 

( select r.id, r.room_name, d.device_name from 
[Sep4_GroupX2].[dbo].[room] as r, 
[Sep4_GroupX2].[dbo].[device] as d  

where r.id NOT In (SELECT  
Room_ID
FROM
[DW].[dbo].[Room_D] ))



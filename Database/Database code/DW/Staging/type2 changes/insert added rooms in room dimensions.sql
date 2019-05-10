use Sep4_GroupX2;

insert into [DW].[dbo].[Room_D]  
(

Room_ID, room_name, device_name, ValidFrom, Validto ) 

select  r.id, r.room_name, d.name, '05/06/2019', '05/06/2099'  -- last updated + 1
from 
dbo.room as r, 
dbo.device as d  -- today

where r.id in 
((
--- today
select [id]

from [Sep4_GroupX2].[dbo].[Room] 
)

EXCEPT 

--- yesterday

 ( select Room_ID from [DW].[dbo].[Room_D]  
 )
 )

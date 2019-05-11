use Sep4;

insert into [DW].[dbo].[Room_D]  
(

Room_ID, room_name, device_name, ValidFrom, Validto ) 
select  
  a.id, a.room_name ,  b.device_name,'05/02/2019', '01/01/2099' -- LAST UPDATE +1
	  FROM Sep4.dbo.room a JOIN Sep4.dbo.device b 
	  ON a.device_id = b.id


where a.id in 
((
--- today
select [id]

from [Sep4].[dbo].[Room] 
)

EXCEPT 

--- yesterday

 ( select Room_ID from [DW].[dbo].[Room_D]  
 )
 )

use Sep4;
go 
--- find added rows
select  
  a.id, a.room_name ,  b.device_name
	  FROM Sep4.dbo.room a JOIN Sep4.dbo.device b 
	  ON a.device_id = b.id

where a.id in 
((
--- today
select id from [Sep4].[dbo].[room]

) 

EXCEPT 
--- yesterday
( select ROOM_ID from [DW].[dbo].[Room_D]
)
)
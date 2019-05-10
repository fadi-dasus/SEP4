use Sep4_GroupX2;
go 
--- find added rows
select r.id, r.room_name, d.name from 
dbo.room as r, 
dbo.device as d

where r.id in 
((
--- today
select id from [Sep4_GroupX2].[dbo].[room]

) 

EXCEPT 
--- yesterday
( select ROOM_ID from [DW].[dbo].[Room_D]
)
)
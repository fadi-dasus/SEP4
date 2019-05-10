use Sep4_GroupX2;

go 

--- find deleted rows 

select * from [DW].[dbo].[Room_D] where Room_ID in 
(
--- yesterday

( select Room_ID from [DW].[dbo].[Room_D]
)

EXCEPT 
(
--- today
select id  from  [Sep4_GroupX2].[dbo].[Room]
)
)
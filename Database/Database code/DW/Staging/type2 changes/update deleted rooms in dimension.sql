use Sep4;

 go 

 update [DW].[dbo].[Room_D]  
 set Validto = '05/05/2019'  --- last Updated

 where Room_ID in (
 --- yesterday
(select [Room_ID]
from [DW].[dbo].[Room_D]
 ) 

 EXCEPT 
 (
 --- today
select [id]
from [Sep4].[dbo].[Room]

)
)
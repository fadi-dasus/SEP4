

use DW_STAGING;

create table TEM_FACT_CO2 (

D_ID   int null ,
R_ID int null ,
W_ID   int null ,
T_ID    int null , 

Date_ID   int null ,
Room_ID int null ,
Warning_ID   int null ,
Time_ID    int null , 
value varchar(255));

insert into TEM_FACT_CO2 (Date_ID, Room_ID, Warning_ID, Time_ID, value)

select calender.D_ID , room.id, warning.id, time.T_ID , co2.value 
from [DW].[dbo].[Calendar_D] as calender,
[DW].[dbo].[Time_D] as time,
[Sep4_GroupX2].[dbo].[co2] as co2 ,
[Sep4_GroupX2].[dbo].[room] as room, 
[Sep4_GroupX2].[dbo].[warning] as warning 


UPDATE [TEM_FACT_CO2] SET D_ID =(select D_ID from [DW].[dbo].[Calendar_D] where [DW].[dbo].[Calendar_D].D_ID = TEM_FACT_CO2.D_ID)
UPDATE [TEM_FACT_CO2] SET T_ID =(select T_ID from [DW].[dbo].[Time_D] where [DW].[dbo].[Time_D].T_ID = TEM_FACT_CO2.T_ID)
UPDATE [TEM_FACT_CO2] SET W_ID =(select W_ID from [DW].[dbo].[Warning_D] where [DW].[dbo].[Warning_D].Warning_ID = TEM_FACT_CO2.Warning_ID)
UPDATE [TEM_FACT_CO2] SET R_ID =(select R_ID from [DW].[dbo].[Room_D] where [DW].[dbo].[Room_D].Room_ID = TEM_FACT_CO2.Room_ID)


use DW_STAGING;

create table TEM_FACT_CO2 (

D_ID   int null ,
R_ID int null ,
T_ID    int null , 

Date_ID   int null ,
Room_ID int null ,
Time_ID    int null , 
value varchar(255));

insert into TEM_FACT_CO2 (Date_ID, Room_ID,  Time_ID, value)

select calendar.D_ID , room.id, time.T_ID , co2.value 

from [DW].[dbo].[Calendar_D] as calendar,
[DW].[dbo].[Time_D] as time,
[Sep4_GroupX2].[dbo].[co2] as co2 ,
[Sep4_GroupX2].[dbo].[room] as room

go

UPDATE [TEM_FACT_CO2] SET D_ID =(select D_ID from [DW].[dbo].[Calendar_D] where [DW].[dbo].[Calendar_D].D_ID = TEM_FACT_CO2.D_ID)
UPDATE [TEM_FACT_CO2] SET T_ID =(select T_ID from [DW].[dbo].[Time_D] where [DW].[dbo].[Time_D].T_ID = TEM_FACT_CO2.T_ID)
UPDATE [TEM_FACT_CO2] SET R_ID =(select R_ID from [DW].[dbo].[Room_D] where [DW].[dbo].[Room_D].Room_ID = TEM_FACT_CO2.Room_ID)




GO


create table TEM_FACT_temp (

D_ID   int null ,
R_ID int null ,
T_ID    int null , 

Date_ID   int null ,
Room_ID int null ,
Time_ID    int null , 
value varchar(255));

insert into TEM_FACT_tem (Date_ID, Room_ID,  Time_ID, value)

select calendar.D_ID , room.id, time.T_ID , tem.value 

from [DW].[dbo].[Calendar_D] as calendar,
[DW].[dbo].[Time_D] as time,
[Sep4_GroupX2].[dbo].[temperature] as tem ,
[Sep4_GroupX2].[dbo].[room] as room

go

UPDATE [TEM_FACT_Tem] SET D_ID =(select D_ID from [DW].[dbo].[Calendar_D] where [DW].[dbo].[Calendar_D].D_ID = TEM_FACT_Tem.D_ID)
UPDATE [TEM_FACT_Tem] SET T_ID =(select T_ID from [DW].[dbo].[Time_D] where [DW].[dbo].[Time_D].T_ID = TEM_FACT_Temp.T_ID)
UPDATE [TEM_FACT_Tem] SET R_ID =(select R_ID from [DW].[dbo].[Room_D] where [DW].[dbo].[Room_D].Room_ID = TEM_FACT_Temp.Room_ID)




GO


create table TEM_FACT_hum (

D_ID   int null ,
R_ID int null ,
T_ID    int null , 

Date_ID   int null ,
Room_ID int null ,
Time_ID    int null , 
value varchar(255));

insert into TEM_FACT_hum (Date_ID, Room_ID,  Time_ID, value)

select calendar.D_ID , room.id, time.T_ID , hum.value 

from [DW].[dbo].[Calendar_D] as calendar,
[DW].[dbo].[Time_D] as time,
[Sep4_GroupX2].[dbo].[humidity] as hum ,
[Sep4_GroupX2].[dbo].[room] as room

go

UPDATE [TEM_FACT_hum] SET D_ID =(select D_ID from [DW].[dbo].[Calendar_D] where [DW].[dbo].[Calendar_D].D_ID = Tem_FACT_hum.D_ID)
UPDATE [TEM_FACT_hum] SET T_ID =(select T_ID from [DW].[dbo].[Time_D] where [DW].[dbo].[Time_D].T_ID = TEM_FACT_hum.T_ID)
UPDATE [TEM_FACT_hum] SET R_ID =(select R_ID from [DW].[dbo].[Room_D] where [DW].[dbo].[Room_D].Room_ID = TEM_FACT_hum.Room_ID)




GO



create table TEM_FACT_Warning (

D_ID   int null ,
R_ID int null ,
T_ID    int null , 

Date_ID   int null ,
Room_ID int null ,
Time_ID    int null , 
value varchar(255));

insert into TEM_FACT_Warning (Date_ID, Room_ID,  Time_ID, value)

select calendar.D_ID , room.id, time.T_ID , w.value 

from [DW].[dbo].[Calendar_D] as calendar,
[DW].[dbo].[Time_D] as time,
[Sep4_GroupX2].[dbo].[warning] as w ,
[Sep4_GroupX2].[dbo].[room] as room

go

UPDATE [TEM_FACT_Warning] SET D_ID =(select D_ID from [DW].[dbo].[Calendar_D] where [DW].[dbo].[Calendar_D].D_ID = TEM_FACT_Warning.D_ID)
UPDATE [TEM_FACT_Warning] SET T_ID =(select T_ID from [DW].[dbo].[Time_D] where [DW].[dbo].[Time_D].T_ID = TEM_FACT_Warning.T_ID)
UPDATE [TEM_FACT_Warning] SET R_ID =(select R_ID from [DW].[dbo].[Room_D] where [DW].[dbo].[Room_D].Room_ID = TEM_FACT_Warning.Room_ID)




GO


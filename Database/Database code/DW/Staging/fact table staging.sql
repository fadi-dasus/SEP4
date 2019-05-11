

use DW_STAGING;

create table TEM_FACT_CO2 (

D_ID   int null ,
R_ID int null ,
T_ID    int null , 

Room_ID int null ,
value varchar(255),
date date,
timestamp datetime);

insert into TEM_FACT_CO2 ( Room_ID,  value, date, timestamp)

select  room.id, co2.value , co2.date , co2.timestamp

from 
[Sep4_GroupX2].[dbo].[co2] as co2 ,
[Sep4_GroupX2].[dbo].[room] as room

go

UPDATE [TEM_FACT_CO2] SET D_ID =(select D_ID from [DW].[dbo].[Calendar_D] where [DW].[dbo].[Calendar_D].CalendarDate = TEM_FACT_CO2.date)
UPDATE [TEM_FACT_CO2] SET T_ID =(select T_ID from [DW].[dbo].[Time_D] where [DW].[dbo].[Time_D].TimeStamp = TEM_FACT_CO2.timestamp)
UPDATE [TEM_FACT_CO2] SET R_ID =(select R_ID from [DW].[dbo].[Room_D] where [DW].[dbo].[Room_D].Room_ID = TEM_FACT_CO2.Room_ID)

select * from [TEM_FACT_CO2];

insert into [DW].[dbo].[Fact_CO2]
	(D_ID,R_ID,T_ID, value, date, timestamp) 
select 
	D_ID,R_ID,T_ID, value, date, timestamp
from [TEM_FACT_CO2];


GO


create table TEM_FACT_Temperature(

D_ID   int null ,
R_ID int null ,
T_ID    int null , 

Room_ID int null ,
value varchar(255),
date date,
timestamp datetime);

insert into TEM_FACT_Temperature( Room_ID,  value, date, timestamp)

select  room.id, Tem.value , Tem.date , Tem.timestamp

from 
[Sep4_GroupX2].[dbo].[temperature] as Tem ,
[Sep4_GroupX2].[dbo].[room] as room

go

UPDATE [TEM_FACT_Temperature] SET D_ID =(select D_ID from [DW].[dbo].[Calendar_D] where [DW].[dbo].[Calendar_D].CalendarDate = TEM_FACT_Temperature.date)
UPDATE [TEM_FACT_Temperature] SET T_ID =(select T_ID from [DW].[dbo].[Time_D] where [DW].[dbo].[Time_D].TimeStamp = TEM_FACT_Temperature.timestamp)
UPDATE [TEM_FACT_Temperature] SET R_ID =(select R_ID from [DW].[dbo].[Room_D] where [DW].[dbo].[Room_D].Room_ID = TEM_FACT_Temperature.Room_ID)

select * from [TEM_FACT_CO2];

insert into [DW].[dbo].[Fact_Temperature]
	(D_ID,R_ID,T_ID, value, date, timestamp) 
select 
	D_ID,R_ID,T_ID, value, date, timestamp
from [TEM_FACT_CO2];


GO

create table TEM_FACT_hum(

D_ID   int null ,
R_ID int null ,
T_ID    int null , 

Room_ID int null ,
value varchar(255),
date date,
timestamp datetime);

insert into TEM_FACT_Temperature( Room_ID,  value, date, timestamp)

select  room.id, hum.value , hum.date , hum.timestamp

from 
[Sep4_GroupX2].[dbo].[humidity] as hum ,
[Sep4_GroupX2].[dbo].[room] as room

go

UPDATE [TEM_FACT_hum] SET D_ID =(select D_ID from [DW].[dbo].[Calendar_D] where [DW].[dbo].[Calendar_D].CalendarDate = TEM_FACT_hum.date)
UPDATE [TEM_FACT_hum] SET T_ID =(select T_ID from [DW].[dbo].[Time_D] where [DW].[dbo].[Time_D].TimeStamp = TEM_FACT_hum.timestamp)
UPDATE [TEM_FACT_hum] SET R_ID =(select R_ID from [DW].[dbo].[Room_D] where [DW].[dbo].[Room_D].Room_ID = TEM_FACT_hum.Room_ID)

select * from [TEM_FACT_CO2];

insert into [DW].[dbo].[Fact_Humidity]
	(D_ID,R_ID,T_ID, value, date, timestamp) 
select 
	D_ID,R_ID,T_ID, value, date, timestamp
from [TEM_FACT_hum];


GO

create table TEM_FACT_Warning(

D_ID   int null ,
R_ID int null ,
T_ID    int null , 

Room_ID int null ,
value varchar(255),
m_type   varchar(50),
status varchar(50),
date date);

insert into TEM_FACT_Warning( Room_ID,  value, date, m_type, status )

select  room.id, w.value , w.time_stamp , w.measurement_type,  w.status

from 
[Sep4_GroupX2].[dbo].[warning] as w ,
[Sep4_GroupX2].[dbo].[room] as room

go

UPDATE [TEM_FACT_Warning] SET D_ID =(select D_ID from [DW].[dbo].[Calendar_D] where [DW].[dbo].[Calendar_D].CalendarDate = TEM_FACT_Warning.date)
UPDATE [TEM_FACT_Warning] SET R_ID =(select R_ID from [DW].[dbo].[Room_D] where [DW].[dbo].[Room_D].Room_ID = TEM_FACT_Warning.Room_ID)

select * from [TEM_FACT_CO2];

insert into [DW].[dbo].[Fact_Warning]
	(D_ID,R_ID,T_ID, value, date, m_type, status) 
select 
	D_ID,R_ID,T_ID, value, date, m_type, status 
from [TEM_FACT_Warning];


GO


use DW_STAGING;
drop table if EXISTS  TEM_FACT_CO2
drop table if EXISTS  TEM_FACT_Temperature
drop table if EXISTS  TEM_FACT_hum
drop table if EXISTS  TEM_FACT_Warning
-----------------------

-- creating TEM_FACT_CO2 table 

create table TEM_FACT_CO2 (

D_ID   int null , -- surrogate key
R_ID int null ,-- surrogate key
T_ID    int null , -- surrogate key

Room_ID int null , -- business key from Room_D
value varchar(255),
date date,
time time);
 CREATE  INDEX "TEM_FACT_CO2_Date" ON "dbo"."TEM_FACT_CO2"("date")
 CREATE  INDEX "TEM_FACT_CO2_Time" ON "dbo"."TEM_FACT_CO2"("time")
 GO
--------------------------------- insert
insert into TEM_FACT_CO2 ( Room_ID,  value, date,time)

select  co2.room_id, co2.value , cast(timestamp as date) [date], cast([timestamp] as time) [time]
from 
[Sep4_GroupX2].[dbo].[co2] as co2 
----------------------------------

select * from TEM_FACT_CO2


go
--------------update 
UPDATE [TEM_FACT_CO2] SET D_ID =(select D_ID from [DW].[dbo].[Calendar_D] where [DW].[dbo].[Calendar_D].CalendarDate = TEM_FACT_CO2.date)
UPDATE [TEM_FACT_CO2] SET T_ID =(select T_ID from [DW].[dbo].[Time_D] where [DW].[dbo].[Time_D].TimeStamp = TEM_FACT_CO2.time)
UPDATE [TEM_FACT_CO2] SET R_ID =(select R_ID from [DW].[dbo].[Room_D] where [DW].[dbo].[Room_D].Room_ID = TEM_FACT_CO2.Room_ID)




-- clean up 





-- filtering the data and remove NULL values if it exists 
    UPDATE [DW_STAGING].[dbo].[TEM_FACT_CO2] SET value = 'NO VALUE' WHERE value IS NULL;

-------------------populate to the fact table

select * from [TEM_FACT_CO2];


insert into [DW].[dbo].[Fact_CO2]
	(D_ID,R_ID,T_ID, value) 
select 
	D_ID,R_ID,T_ID, value
from [TEM_FACT_CO2];


GO
-- 
use DW
select * from [Fact_CO2]
---


-------------------------------------------------------------------
use DW_STAGING;
 drop table if EXISTS  TEM_FACT_Temperature

 -- creating TEM_FACT_Temperature table 

create table TEM_FACT_Temperature(

D_ID   int null ,-- surrogate key
R_ID int null ,-- surrogate key
T_ID    int null , -- surrogate key

Room_ID int null ,
value varchar(255),
date date,
time time);
select * from TEM_FACT_Temperature

---------------insert

insert into TEM_FACT_Temperature( Room_ID,  value, date,time)

select  t.room_id, t.value ,cast(timestamp as date) [date], cast([timestamp] as time) [time]
from 
[Sep4_GroupX2].[dbo].[temperature] as t 

------------ update
UPDATE [TEM_FACT_Temperature] SET D_ID =(select D_ID from [DW].[dbo].[Calendar_D] where [DW].[dbo].[Calendar_D].CalendarDate = TEM_FACT_Temperature.date)
UPDATE [TEM_FACT_Temperature] SET T_ID =(select T_ID from [DW].[dbo].[Time_D] where [DW].[dbo].[Time_D].TimeStamp = TEM_FACT_Temperature.time)
UPDATE [TEM_FACT_Temperature] SET R_ID =(select R_ID from [DW].[dbo].[Room_D] where [DW].[dbo].[Room_D].Room_ID = TEM_FACT_Temperature.Room_ID)

select * from TEM_FACT_Temperature 
-------------- populate the data

--some checking 

    UPDATE [DW_STAGING].[dbo].[TEM_FACT_Temperature] SET value = 'NO VALUE' WHERE value IS NULL;

----
use DW_STAGING;

---- final insert 
insert into [DW].[dbo].[Fact_Temperature]
	(D_ID,R_ID,T_ID, value) 
select 
	D_ID,R_ID,T_ID, value
from [TEM_FACT_CO2];


GO

select * from [DW].[dbo].[Fact_Temperature];
------------------------

use DW_STAGING;
GO
-- creating TEM_FACT_hum table 
create table TEM_FACT_hum(

D_ID   int null ,
R_ID int null ,
T_ID    int null , 

Room_ID int null ,
value varchar(255),
date date,
time time);

---- insert 

insert into TEM_FACT_hum( Room_ID,  value, date,time)

select  t.room_id, t.value , cast(timestamp as date) [date], cast([timestamp] as time) [time]
from 
[Sep4_GroupX2].[dbo].[humidity] as t 

go
---- update the keys

UPDATE TEM_FACT_hum SET D_ID =(select D_ID from [DW].[dbo].[Calendar_D] where [DW].[dbo].[Calendar_D].CalendarDate = TEM_FACT_hum.date)
UPDATE TEM_FACT_hum SET T_ID =(select T_ID from [DW].[dbo].[Time_D] where [DW].[dbo].[Time_D].TimeStamp = TEM_FACT_hum.time)
UPDATE TEM_FACT_hum SET R_ID =(select R_ID from [DW].[dbo].[Room_D] where [DW].[dbo].[Room_D].Room_ID = TEM_FACT_hum.Room_ID)

select * from TEM_FACT_hum;


-- do some checking

    UPDATE [DW_STAGING].[dbo].[TEM_FACT_Temperature] SET value = 'NO VALUE' WHERE value IS NULL;
----- pupolate to the fact table

insert into [DW].[dbo].[Fact_Humidity]
	(D_ID,R_ID,T_ID, value) 
select 
	D_ID,R_ID,T_ID, value
from [TEM_FACT_hum];


GO

SELECT * FROM [DW].[dbo].[Fact_Humidity]

----------
use DW_STAGING;
GO

drop table if EXISTS  TEM_FACT_Warning
-- craeting the TEM_FACT_Warning table 
create table TEM_FACT_Warning(

D_ID   int null ,-- surrogate key
R_ID int null ,-- surrogate key
T_ID    int null , -- surrogate key

Room_ID int null ,
value varchar(255),
m_type   varchar(50),
status varchar(50),
date date,
time time);

--insert values 
insert into TEM_FACT_Warning( Room_ID,  value, date,time, m_type, status )

select  w.room_id, w.value ,cast(w.timestamp as date) [date] ,cast(w.timestamp as time) [time] , w.measurement_type,  w.status

from 
[Sep4_GroupX2].[dbo].[warning] as w 


go


-- update the keys

UPDATE TEM_FACT_Warning SET D_ID =(select D_ID from [DW].[dbo].[Calendar_D] where [DW].[dbo].[Calendar_D].CalendarDate = TEM_FACT_Warning.date)
UPDATE TEM_FACT_Warning SET T_ID =(select T_ID from [DW].[dbo].[Time_D] where [DW].[dbo].[Time_D].TimeStamp = TEM_FACT_Warning.time)
UPDATE TEM_FACT_Warning SET R_ID =(select R_ID from [DW].[dbo].[Room_D] where [DW].[dbo].[Room_D].Room_ID = TEM_FACT_Warning.Room_ID)

select * from TEM_FACT_Warning;
----
--populate the data 
-- do some checking 

use DW_Staging


insert into [DW].[dbo].[Fact_Warning]
	(D_ID,R_ID,T_ID, value, m_type, status) 
select 
	D_ID,R_ID,T_ID, value, m_type, status 
from [TEM_FACT_Warning];


GO

select * from [DW].[dbo].[Fact_Warning]
GO
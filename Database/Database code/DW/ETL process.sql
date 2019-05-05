


create table "Stage_Warning_D"(
W_ID  INT,
WType  varchar(15),

	);



	insert into [Stage_Warning_D] ( [W_ID],[WType]) select [W_ID], [WType] from [Sep4_GroupX2].[dbo].[Warning]


	-- removing the NULL values if it exist 
  

    UPDATE dbo.Stage_Warning_D SET WType = 'NO VALUE' WHERE WType IS NULL;


	insert into [Warning_D] ( [W_ID],[WType]) select [W_ID], [WType] from [Sep4_GroupX2].[dbo].[Stage_Warning_D]


	CREATE TABLE Fact_Temp_stag
(
C_ID     DATE   ,
W_ID     INT    ,
T_ID     INT    ,
calender_ID   DATE,
Warning_ID   INT,
Time_ID   DATE,
value     INT, )


insert into Fact_Temp_Stag (calender_ID,
Warning_ID,
Time_ID,
value )

select 
Warning.Warning_ID, Calender.Calender_ID, Temperature.value, Time.time_ID

from dbo.Warning as Warning, 
dbo.Calender as Calender , 
dbo.Time as Time,
dbo.Temperature as Temperature

where 
Warning.Warning_ID = Warning.Warning_ID and 
Calender.Calender_ID  = Calender.Calender_ID and 
Temperature.value = Temperature.value and
Time.time_ID = Time.time_ID

update Fact_Temp_Stag set C_ID=(select C_ID from .dbo.Calendar_D where Calendar_D.C_ID=Fact_Temp_Stag.C_ID);
update Fact_Temp_Stag set W_ID=(select W_ID from .dbo.Warning_D where Warning_D.W_ID=Fact_Temp_Stag.W_ID);
update Fact_Temp_Stag set T_ID=(select T_ID from .dbo.Time_D where Time_D.T_ID=Fact_Temp_Stag.T_ID);



insert into Fact_Temp ( C_ID,
W_ID,
T_ID,
value ) select ( C_ID,
W_ID,
T_ID,
value ) from Fact_Temp_Stag;




	CREATE TABLE Fact_CO2_stag
(
C_ID     DATE   ,
W_ID     INT    ,
T_ID     INT    ,
calender_ID   DATE,
Warning_ID   INT,
Time_ID   DATE,
value     INT, );


insert into Fact_CO2_Stag (calender_ID,
Warning_ID,
Time_ID,
value )

select 
Warning.Warning_ID, Calender.Calender_ID, CO2.value, Time.time_ID

from dbo.Warning as Warning, 
dbo.Calender as Calender , 
dbo.Time as Time,
dbo.Co2 as Co2

where 
Warning.Warning_ID = Warning.Warning_ID and 
Calender.Calender_ID  = Calender.Calender_ID and 
CO2.value = CO2.value and
Time.time_ID = Time.time_ID

update Fact_Temp_Stag set C_ID=(select C_ID from .dbo.Calendar_D where Calendar_D.C_ID=Fact_CO2_Stag.C_ID);
update Fact_Temp_Stag set W_ID=(select W_ID from .dbo.Warning_D where Warning_D.W_ID=Fact_CO2_Stag.W_ID);
update Fact_Temp_Stag set T_ID=(select T_ID from .dbo.Time_D where Time_D.T_ID=Fact_CO2_Stag.T_ID);



insert into Fact_CO2 ( C_ID,
W_ID,
T_ID,
value ) select ( C_ID,
W_ID,
T_ID,
value ) from Fact_CO2_Stag;




	CREATE TABLE Fact_Hum_stag
(
C_ID     DATE   ,
W_ID     INT    ,
T_ID     INT    ,
calender_ID   DATE,
Warning_ID   INT,
Time_ID   DATE,
value     INT, )


insert into Fact_Hum_Stag (calender_ID,
Warning_ID,
Time_ID,
value )

select 
Warning.Warning_ID, Calender.Calender_ID, Humidity.value, Time.time_ID

from dbo.Warning as Warning, 
dbo.Calender as Calender , 
dbo.Time as Time,
dbo.Humidity as Humidity

where 
Warning.Warning_ID = Warning.Warning_ID and 
Calender.Calender_ID  = Calender.Calender_ID and 
Hunidity.value = Humidity.value and
Time.time_ID = Time.time_ID

update Fact_Temp_Stag set C_ID=(select C_ID from .dbo.Calendar_D where Calendar_D.C_ID=Fact_Hum_Stag.C_ID);
update Fact_Temp_Stag set W_ID=(select W_ID from .dbo.Warning_D where Warning_D.W_ID=Fact_Hum_Stag.W_ID);
update Fact_Temp_Stag set T_ID=(select T_ID from .dbo.Time_D where Time_D.T_ID=Fact_Hum_Stag.T_ID);



insert into Fact_Humidity ( C_ID,
W_ID,
T_ID,
value ) select ( C_ID,
W_ID,
T_ID,
value ) from Fact_Hum_Stag;
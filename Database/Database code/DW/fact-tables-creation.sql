
use Sep4_GroupX2;
CREATE TABLE Calender_D
(

C_ID   DATE,
Primary Key (C_ID)
);






CREATE TABLE Time_D
(
T_ID     INT,
Seconds  INT,
Minutes    INT,
Hours    INT,
Primary Key (T_ID)
);

CREATE TABLE Room_D
(
R_ID     INT,
Room_ID  INT,
Room_name   varchar(50),
ValidFrom    DATE  not null DEFAULT '01/01/1997',
ValidTo       DATE  not null DEFAULT '31/12/2999',
Primary Key (R_ID),

constraint "FK_Room_ID" foreign key ( "Room_ID"  ) 
references [Sep4_GroupX2].[dbo].[room] ( "id" )

);






CREATE TABLE Warning_D
(
W_ID  INT,
Warning_ID INT,
WType  varchar(15),
ValidFrom    DATE  not null DEFAULT '01/01/1997',
ValidTo       DATE  not null DEFAULT '31/12/2999',
timeSt   date,
level   int,
value   int,
constraint "PK_Warning_D" primary key(
		"W_ID"
	),
	constraint "FK_Warning_D" foreign key(
		"Warning_ID"
	)references [Sep4_GroupX2].[dbo].[warning] (
		"id"
	)

);


CREATE TABLE Fact_Temp
(
C_ID     DATE   ,
W_ID     INT    ,
T_ID     INT    ,
R_ID     int,
value     INT,
constraint "PK_Fact_Temp" primary key(
		"C_ID","W_ID","T_ID","R_ID"
	),
	constraint "FK_Temp_Date" foreign key(
		"C_ID"
	)references "Calender_D"(
		"C_ID"
	),
	constraint "FK_Temp_Warning" foreign key(
		"W_ID"
	)references "Warning_D"(
		"W_ID"
	),
	constraint "FK_Temp_time" foreign key(
		"T_ID"
	)references "Time_D"(
		"T_ID"
	),
	constraint "FK_Temp_room" foreign key(
		"R_ID"
	)references "Room_D"(
		"R_ID"
	)

);

CREATE TABLE Fact_CO2
(
C_ID     DATE   ,
W_ID     INT    ,
T_ID     INT    ,
R_ID     int,
value     INT,

constraint "PK_Fact_CO2" primary key(
		"C_ID","W_ID","T_ID","R_ID"
	),
	constraint "FK_CO2_Date" foreign key(
		"C_ID"
	)references "Calender_D"(
		"C_ID"
	),
	constraint "FK_CO2_Warning" foreign key(
		"W_ID"
	)references "Warning_D"(
		"W_ID"
	),
	constraint "FK_CO2_time" foreign key(
		"T_ID"
	)references "Time_D"(
		"T_ID"
	)
	,
	constraint "FK_CO2_room" foreign key(
		"R_ID"
	)references "Room_D"(
		"R_ID"
	)


);


CREATE TABLE Fact_Humidity
(
C_ID     DATE   ,
W_ID     INT    ,
T_ID     INT    ,
R_ID     INT,
value     INT,
constraint "PK_Fact_Humidity" primary key(
		"C_ID","W_ID","T_ID", "R_ID"
	),
	constraint "FK_Humidity_Date" foreign key(
		"C_ID"
	)references "Calender_D"(
		"C_ID"
	),
	constraint "FK_Humidity_Warning" foreign key(
		"W_ID"
	)references "Warning_D"(
		"W_ID"
	),
	constraint "FK_Humitity_time" foreign key(
		"T_ID"
	)references "Time_D"(
		"T_ID"
	),
	constraint "FK_Humidity_room" foreign key(
		"R_ID"
	)references "Room_D"(
		"R_ID"
	)

);
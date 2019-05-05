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



CREATE TABLE Warning_D
(
W_ID  INT,
WType  varchar(15),
ValidFrom    DATE  not null DEFAULT '01/01/1997',
ValidTo       DATE  not null DEFAULT '31/12/2999',
Primary Key (W_ID)

);


CREATE TABLE Fact_Temp
(
C_ID     DATE   ,
W_ID     INT    ,
T_ID     INT    ,
value     INT,
constraint "PK_Fact_Temp" primary key(
		"C_ID","W_ID","T_ID"
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
	)

);

CREATE TABLE Fact_CO2
(
C_ID     DATE   ,
W_ID     INT    ,
T_ID     INT    ,
value     INT,

constraint "PK_Fact_CO2" primary key(
		"C_ID","W_ID","T_ID"
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


);


CREATE TABLE Fact_Humidity
(
C_ID     DATE   ,
W_ID     INT    ,
T_ID     INT    ,
value     INT,
constraint "PK_Fact_Humidity" primary key(
		"C_ID","W_ID","T_ID"
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
	)

);
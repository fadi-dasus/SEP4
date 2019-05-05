use Sep4
 go
 drop table if exists Stage_Dim_Time;

 go
create table "Stage_Dim_Time"(
TimeStamp  TIME not null
, Minutes tinyint not null
, Seconds tinyint not null
)
go

insert into [Stage_Dim_Time](
TimeStamp
, Minutes
, Seconds
)
select 
TimeStamp
, Minutes
, Seconds
from Time

go

select * from Stage_Dim_Time;

drop table if exists Dim_Date;
go

  create table "Dim_Time"(
  T_ID int identity (1,1) not null,
  TimeStamp  TIME not null
, Minutes tinyint not null
, Seconds tinyint not null
  constraint "PK_T" primary key(
		"T_ID"
)
)

go

Insert Into [Dim_Time]
(
TimeStamp
, Minutes
, Seconds
)
select 
TimeStamp
, Minutes
, Seconds
 from Stage_Dim_Time
 go

 select * from Dim_Time;
 go
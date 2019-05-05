use Sep4
 go
 drop table if exists Stage_Dim_Calendar;

 go
create table "Stage_Dim_Calendar"(
CalendarDate DATETIME not null
, WeekDayName nvarchar(50) not null
, MonthName nvarchar(50) not null
)
go

insert into [Stage_Dim_Calendar](
CalendarDate,
WeekDayName,
MonthName
)
select 
CalendarDate,
WeekDayName,
MonthName
from Calendar

go

select * from Stage_Dim_Calendar;

drop table if exists Dim_Date;
go

  create table "Dim_Date"(
  D_ID int identity (1,1) not null,
  CalendarDate DATETIME not null,
  WeekDayName nvarchar(50) not null,
  MonthName nvarchar(50) not null,
  constraint "PK_D" primary key(
		"D_ID"
)
)

go

Insert Into [Dim_Date]
(
CalendarDate,
WeekDayName,
MonthName
)
select 
CalendarDate,
WeekDayName,
MonthName
 from Stage_Dim_Calendar
 go

 select * from Dim_Date;
 go
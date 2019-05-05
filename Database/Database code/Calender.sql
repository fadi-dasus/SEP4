use Sep4 
 go

 drop table if exists Calendar;
 go

CREATE TABLE "Calendar"
(
DateID int identity (1,1) not null
,CalendarDate DATETIME not null
, WeekDayName nvarchar(50) not null
, MonthName nvarchar(50) not null
,constraint "PK_Date_ID" primary key(
		"DateID"
)
)
go
DECLARE @StartDate DATETIME
DECLARE @EndDate DATETIME
SET @StartDate = '2019-05-04'
SET @EndDate = DATEADD(d, 11,
@StartDate)
WHILE @StartDate <= @EndDate
BEGIN
INSERT INTO [Calendar]
(
CalendarDate
,WeekDayName
,MonthName
)
SELECT
@StartDate
,DATENAME(weekday,@startDate)
,DATENAME(month, @StartDate )
SET @StartDate = DATEADD(dd, 1, @StartDate)
END
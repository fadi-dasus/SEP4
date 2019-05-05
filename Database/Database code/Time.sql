use Sep4 
 go

 drop table if exists Time;
 go

CREATE TABLE "Time"
(
  TimeID int identity (1,1) not null
, TimeStamp  TIME not null
, Minutes tinyint not null
, Seconds tinyint not null
,constraint "PK_Time_ID" primary key(
		"TimeID"
)
)
go
DECLARE @Hour TIME
DECLARE @EndHour TIME
SET @Hour = '08:20:01'
SET @EndHour = DATEADD(second,27900,@Hour)
WHILE (@Hour <= @EndHour)
BEGIN
INSERT INTO [Time]
(
TimeStamp,
Minutes,
Seconds
)
SELECT
@Hour
,DATENAME(minute,@Hour)
,DATENAME(second, @Hour )
SET @Hour = DATEADD(second,1, @Hour)
END
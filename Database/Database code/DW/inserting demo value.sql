USE [Sep4_GroupX2]
GO

INSERT INTO [dbo].[co2]
           ([b_id]
           ,[highe_acceptable_value]
           ,[low_acceptable_value]
           ,[timestamp]
           ,[value])
     VALUES
           (2,6,1,'2019-05-06',3)
		   ,(3,6,1,'2019-05-06',1)
		   ,(4,6,1,'2019-05-06',4)
		   ,(5,6,1,'2019-05-06',4)

GO

select * from co2;

INSERT INTO [dbo].[humidity]
           ([b_id]
           ,[highe_acceptable_value]
           ,[low_acceptable_value]
           ,[timestamp]
           ,[value])
     VALUES
	        (0,30,-30,'2019-05-06',3)
		   ,(1,30,-30,'2019-05-06',1)
           ,(2,30,-30,'2019-05-06',3)
		   ,(3,30,-30,'2019-05-06',10)
		   ,(4,30,-30,'2019-05-06',5)
		   ,(5,30,-30,'2019-05-06',11)
GO
select * from humidity;

GO

INSERT INTO [dbo].[room]
           ([room_name])
     VALUES
           ('B 123')
		   ,('B 123')
		   ,('A 01')
		   ,('A 01')
		   ,('A 01')
GO
select * from room;
GO

INSERT INTO [dbo].[temperature]
           ([b_id]
           ,[highe_acceptable_value]
           ,[low_acceptable_value]
           ,[timestamp]
           ,[value])
     VALUES
           (1,70,-30,'2010-05-06',20)
		   ,(2,70,-30,'2010-05-06',21)
		   ,(3,70,-30,'2010-05-06',22)
		   ,(4,70,-30,'2010-05-06',22)
		   ,(5,70,-30,'2010-05-06',22)
GO



INSERT INTO [dbo].[warning]
           ([measurement_type]
           ,[high]
           ,[low]
           ,[room_name]
           ,[time_stamp]
           ,[value])
     VALUES
           ('c02',6,1,'A-301','2019-05-06',1)
GO

INSERT INTO [dbo].[Calender]
           ([C_ID])
     VALUES
           ('2019-05-06')
GO
select * from Calender;


Go

INSERT INTO [dbo].[measurement]
           ([id]
           ,[co2_id]
           ,[humidity_id]
           ,[room_id]
           ,[temperature_id])
     VALUES
           (1,1,1,1,1)
		   ,(2,2,2,2,2)
		   ,(3,3,3,3,3)
		   ,(4,4,4,4,4)
		   ,(5,5,5,5,5)
		 
GO


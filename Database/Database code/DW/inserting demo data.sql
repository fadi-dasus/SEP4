USE [Sep4_GroupX2]
GO

INSERT INTO [dbo].[device]
           ([name]
           ,[uie])
     VALUES
           ('arduino', '123');
GO
select * from  [dbo].[device];

USE [Sep4_GroupX2]
GO

INSERT INTO [dbo].[co2]
           ([status]
           ,[timestamp]
           ,[value]
           ,[room_id])
     VALUES
           ('high', '2019-5-01', 50, 1),
		   ('low', '2019-5-03', -50, 2);
GO

USE [Sep4_GroupX2]
GO

INSERT INTO [dbo].[room]
           ([room_name]
           ,[device_id])
     VALUES
           ('B02',1);
GO

INSERT INTO [dbo].[temperature]
           ([status]
           ,[timestamp]
           ,[value]
           ,[room_id])
     VALUES
           ('high', '2019-5-01', 40, 1),
		   ('low', '2019-5-03', -40, 2);
GO

INSERT INTO [dbo].[humidity]
           ([status]
           ,[timestamp]
           ,[value]
           ,[room_id])
     VALUES
           ('high', '2019-5-01', 10, 1),
		   ('low', '2019-5-03', -10, 2);
GO

INSERT INTO [dbo].[warning]
           ([measurement_type]
           ,[status]
           ,[time_stamp]
           ,[value]
           ,[room_id])
     VALUES
           ('CO2','high', '2019-05-01',50, 1),
		   ('CO2','low', '2019-05-01',-50, 2),
		   ('Temperature','high', '2019-05-01',40, 1),
		   ('Temperature','low', '2019-05-01',-40, 2),
		   ('humidity','high', '2019-05-01',10, 1),
		   ('humidity','low', '2019-05-01',-10, 2);
GO




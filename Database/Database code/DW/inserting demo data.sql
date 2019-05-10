USE [Sep4_GroupX2]
GO

INSERT INTO [dbo].[device]
           ([device_name]
           ,[uie])
     VALUES
           ('arduino', '123');
GO
select * from  [dbo].[device];

USE [Sep4_GroupX2]
GO

INSERT INTO [dbo].[co2]
           ([status]
           ,[date]
           ,[value]
		   ,[timestamp]
           )
     VALUES
           ('high', '2019-05-01', 50, '2019-05-01T18:10:00' ),
		   ('low', '2019-05-03', -50, '2019-05-01T18:11:00');
GO
select * from  [dbo].[co2];
USE [Sep4_GroupX2]
GO

INSERT INTO [dbo].[room]
           ([room_name]
           ,[device_id])
     VALUES
           ('B02',1);
GO
select * from warning; 

INSERT INTO [dbo].[temperature]
           ([status]
           ,[date]
           ,[value]
		   ,[timestamp])
     VALUES
           ('high', '2019-05-03', -40, '2019-05-01T18:11:00'),
		   ('low', '2019-05-03', -40, '2019-05-01T18:11:00');
GO

INSERT INTO [dbo].[humidity]
           ([status]
           ,[date]
           ,[value]
		   ,[timestamp])
     VALUES
           ('high', '2019-05-01', 10, '2019-05-01T18:11:00'),
		   ('low', '2019-05-03', -10,'2019-05-01T18:11:00');
GO

INSERT INTO [dbo].[warning]
           ([measurement_type]
           ,[status]
           ,[time_stamp]
           ,[value]
           )
     VALUES
           ('CO2','high', '2019-05-01',50 ),
		   ('CO2','low', '2019-05-01',-50 ),
		   ('Temperature','high', '2019-05-01',40 ),
		   ('Temperature','low', '2019-05-01',-40 ),
		   ('humidity','high', '2019-05-01',10 ),
		   ('humidity','low', '2019-05-01',-10 );
GO




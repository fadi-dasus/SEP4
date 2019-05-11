use DW_STAGING;
Drop table if exists ROOM_D_STAGE

go 
 
create table ROOM_D_STAGE (
R_ID   int identity ,
Room_ID  int,
room_name     varchar(50),
device_name   varchar(50)
);


insert into ROOM_D_STAGE( Room_ID, room_name, device_name) select  
  a.id, a.room_name ,  b.device_name
	  FROM Sep4.dbo.room a JOIN Sep4.dbo.device b 
	  ON a.device_id = b.id

 select * from Room_D_STAGE;

   -- filtering the data and remove NULL values if it exists 
    UPDATE [DW_STAGING].[dbo].[ROOM_D_STAGE] SET room_name = 'NO VALUE' WHERE room_name IS NULL;

	-- checking if there is any dyplicating rows 

  SELECT  count(DISTINCT room_name) as total, room_name FROM [DW_STAGING].[dbo].[ROOM_D_STAGE]
  group by room_name
  GO

   -- detecting duplicated rows and delete them 
	   WITH ROOM_D_STAGECTE AS
	(SELECT *,ROW_NUMBER() OVER (PARTITION BY room_name ORDER BY  room_name) AS RowNumber
	FROM ROOM_D_STAGE )
	DELETE  FROM ROOM_D_STAGECTE WHERE RowNumber > 1
 
 GO

 --insert data
 insert into [DW].[dbo].[Room_D] (
     [Room_ID]
     ,[room_name]
     ,[device_name]) select
     Room_ID, room_name, device_name from [DW_STAGING].[dbo].[ROOM_D_STAGE];

      select * from [DW].[dbo].[Room_D];








  

   
	


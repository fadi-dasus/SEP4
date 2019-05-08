use DW_STAGING;

create table ROOM_D_STAGE (
N_ID   int identity ,
Room_ID  int,
room_name     varchar(50),
device_name   varchar(50)
);



insert into ROOM_D_STAGE( Room_ID, room_name, device_name) select  
 room.id, room.room_name, device.name
     
 from [Sep4_GroupX2].[dbo].[room] as room ,[Sep4_GroupX2].[dbo].[device] as device ;

 select * from Room_D_STAGE;

   -- filtering the data and remove NULL values if it exists 

  SELECT DISTINCT room_name FROM [DW_STAGING].[dbo].[ROOM_D_STAGE]
  

    UPDATE [DW_STAGING].[dbo].[ROOM_D_STAGE] SET room_name = 'NO VALUE' WHERE room_name IS NULL;
	

go

insert into [DW].[dbo].[Room_D] (
      [Room_ID]
      ,[room_name]
      ,[device_name]) select 
	 Room_ID, room_name, device_name from [DW_STAGING].[dbo].[ROOM_D_STAGE];

	  select * from [DW].[dbo].[Room_D];
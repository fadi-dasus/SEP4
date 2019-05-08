

use DW_STAGING;

create table WARNING_D_STAGE (
N_ID   int identity ,
Warning_ID  int,
m_Type     varchar(50),
status    varchar(50),
t_Stamp     datetime2(7),
value       varchar(255),
);



insert into WARNING_D_STAGE( Warning_ID, m_Type, status,t_Stamp,value) select  
[id]
      ,[measurement_type]
      ,[status]
      ,[time_stamp]
      ,[value]
 from [Sep4_GroupX2].[dbo].[warning];

 select * from WARNING_D_STAGE;

   -- filtering the data and remove NULL values if it exists 

  SELECT DISTINCT status FROM [DW_STAGING].[dbo].[WARNING_D_STAGE]
  

    UPDATE [DW_STAGING].[dbo].[WARNING_D_STAGE] SET status = 'NO VALUE' WHERE status IS NULL;

	SELECT DISTINCT status FROM [DW_STAGING].[dbo].[WARNING_D_STAGE]
  

    UPDATE [DW_STAGING].[dbo].[WARNING_D_STAGE] SET status = 'NO VALUE' WHERE status IS NULL;
	

go

insert into [DW].[dbo].[Warning_D] ( [Warning_ID]
      ,[m_Type]
      ,[status]
      ,[t_Stamp]
      ,[value]) select 
	  
	  [Warning_ID]
      ,[m_Type]
      ,[status]
      ,[t_Stamp]
      ,[value] from [DW_STAGING].[dbo].[WARNING_D_STAGE];

	  select * from [DW].[dbo].[Warning_D];
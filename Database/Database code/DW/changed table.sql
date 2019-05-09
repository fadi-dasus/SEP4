
use DW_STAGING;


create table "changed_Room" 
(

Room_ID int not null , 
room_name varchar(50),
device_name varchar(50),
"ValidFrom" nvarchar(20)  null DEFAULT '05/01/2019',
"Validto" nvarchar(20)  null DEFAULT '01/01/2099'

)
go 
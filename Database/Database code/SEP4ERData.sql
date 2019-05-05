create database SEP4Datbase

drop table if exists Admin

create table Admin (
    AdminID int identity (1,1) not null,
    UserName nvarchar(50) not null,
    Password nvarchar(50) not null,
)
go

alter table Admin add constraint PK_Admin primary key(AdminID);

go

drop table if exists "User"

go

create table "User" (
    UserID int identity (1,1) not null,
    UserName nvarchar(50) not null,
    Password nvarchar(50) not null,
    Email nvarchar(50) not null,
    PhoneNo nvarchar(50) not null,
    Address nvarchar(50) not null
)

go

alter table "User" add constraint PK_User primary key(UserID);

go

drop table if exists CO2

go

create table CO2 (
    CO2ID int identity (1,1) not null,
    CO2 nvarchar(50) not null
    )
go

alter table "CO2" add constraint PK_CO2 primary key(CO2ID);

go

drop table if exists Temperature

go

create table Temperature (
    TemperatureID int identity (1,1) not null,
    Temperature nvarchar(50) not null
    )
go

alter table "Temperature" add constraint PK_Temperature primary key(TemperatureID);

go

drop table if exists Humidity

go

create table Humidity (
    HumidityID int identity (1,1) not null,
    Humidity nvarchar(50) not null
    )
go

alter table "Humidity" add constraint PK_Humidity primary key(HumidityID);

go

drop table if exists Warning

go

create table Warning (
    WarningID int identity (1,1) not null,
    MType nvarchar(50) not null,
    WType nvarchar(50) not null    
    )
go

alter table "Warning" add constraint PK_Warning primary key(WarningID);

go

drop table if exists Device

go

create table Device(
    DeviceID int identity (1,1) not null,
    DeviceName nvarchar
    )
go

alter table Device add constraint PK_Device primary key(DeviceID)

go

drop table if exists Room

go

create table Room (
    RoomID int identity (1,1) not null,
    CO2ID int,
    TemperatureID int,
    HumidityID int,
    WarningID int,
    DeviceID int,
    Area nvarchar(50),
    NoOfWindows nvarchar(50)
    )
go

alter table Room add constraint PK_Room primary key(RoomID)

go

alter table Room add constraint FK_CO2 foreign key(CO2ID) references CO2(CO2ID)

go

alter table Room add constraint FK_Temperature foreign key(TemperatureID) references Temperature(TemperatureID)

go

alter table Room add constraint FK_Humidity foreign key(HumidityID) references Humidity(HumidityID)

go

alter table Room add constraint FK_Warning foreign key(WarningID) references Warning(WarningID)

go
alter table Room add constraint FK_Device foreign key(DeviceID) references Device(DeviceID)

select * from admin
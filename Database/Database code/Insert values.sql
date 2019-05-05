use Sep4

go
insert into admin(username,password) values ('fadi','1234')
insert into admin(username,password) values ('Nadi','12345')
insert into admin(username,password) values ('Yasin','12346')

go
insert into customer(username,password,phone,email) values ('fadi','1234','21345689','fadi@via')
insert into customer(username,password,phone,email) values ('Nadi','12345','12345678','nadi@via')
insert into customer(username,password,phone,email) values ('Yasin','12346','98765432','yasin@via')

insert into co2(b_id,value,timestamp) values ('1','354','03-05-2019 12:50')
insert into co2(b_id,value,timestamp) values ('2','345','03-05-2019 13:00')
insert into co2(b_id,value,timestamp) values ('3','532','03-05-2019 13:10')

go
insert into temperature(b_id,value,timestamp) values ('1','25','03-05-2019 12:50')
insert into temperature(b_id,value,timestamp) values ('2','26','03-05-2019 13:00')
insert into temperature(b_id,value,timestamp) values ('3','25.5','03-05-2019 13:10')

go
insert into humidity(b_id,value,timestamp) values ('1','48','03-05-2019 12:50')
insert into humidity(b_id,value,timestamp) values ('2','45','03-05-2019 13:00')
insert into humidity(b_id,value,timestamp) values ('3','46','03-05-2019 13:10')

go
insert into room values('F307')
insert into room values('E303')
insert into room values('E205')

go

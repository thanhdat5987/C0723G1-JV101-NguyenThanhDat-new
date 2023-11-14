drop database  pet_management;
create database pet_management;

use pet_management;
create table pet_owner(
cityzen_id int,
owner_name varchar(50),
phone_number int,
owner_user_name varchar(20) primary key
);
create table pet(
pet_code varchar(20) primary key,
pet_type varchar(10),
pet_description varchar(250),
owner_user_name varchar(20),
foreign key (owner_user_name) references pet_owner(owner_user_name)
);

create table information(
infor_code varchar(20) primary key,
owner_user_name varchar(20),
pet_code varchar(20),
detail varchar(250),
date_infor datetime,
payment int,
remark varchar(250),
foreign key (owner_user_name) references pet_owner(owner_user_name),
foreign key (pet_code) references pet(pet_code)
); 
insert into pet_owner(cityzen_id,owner_name,phone_number, owner_user_name )value(123456789,'Dat',0901111111,'DatNT');
insert into pet_owner(cityzen_id,owner_name,phone_number, owner_user_name )value(123456780,'Huu',0901111111,'HuuPT');
INSERT INTO `pet_management`.`pet` (`pet_code`, `pet_type`, `pet_description`, `owner_user_name`) VALUES ('TN1', 'Chó', 'đen', 'DatNT');
INSERT INTO `pet_management`.`pet` (`pet_code`, `pet_type`, `pet_description`) VALUES ('TN2', 'Mèo', 'xám');

INSERT INTO `pet_management`.`information` (`infor_code`, `owner_user_name`, `pet_code`, `detail`, `date_infor`, `payment`) VALUES ('MVP1', 'DatNT', 'TN1', 'đi bậy', '2023-11-10 08:08:01', '50000');
INSERT INTO `pet_management`.`information` (`infor_code`, `owner_user_name`, `pet_code`, `detail`, `date_infor`, `payment`) VALUES ('MVP2', 'HuuPT', 'TN2', 'đi bậy', '2023-11-10 08:08:08', '50000');

select information.infor_code, pet_owner.owner_name, pet.pet_code, information.detail, information.date_infor, information.payment from
information join pet_owner 
on information.owner_user_name = pet_owner.owner_user_name
join pet on information.pet_code = pet.pet_code;
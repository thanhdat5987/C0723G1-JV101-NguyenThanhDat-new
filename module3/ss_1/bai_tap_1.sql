create database student_management;
use student_management;
create table student(id int primary key auto_increment, `name` varchar(200), age int, country varchar(50));
create table class(id int primary key auto_increment, `name` varchar(50));
create table teacher(id int primary key auto_increment, `name` varchar(200), age int, country varchar(50));
insert into student(name,age, country) value ("Dat", 18, "Viet Nam");
insert into student(name,age, country) value ("Toai", 20, "Viet Nam");
insert into class(name) value ("C0723G1");
insert into class(name) value ("C0823G1");
insert into teacher(name, age, country)value("Phuong",25,"USA");
insert into teacher(name, age, country)value("Chanh",35,"USA");
select * from student;
select * from class;
select * from teacher;
delete from student where id =1;
select  * from teacher where name ="Phuong" ;
update teacher set country ="Viet Nam" where id="1";
select * from teacher;


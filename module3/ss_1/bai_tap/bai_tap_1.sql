create database student_management;
use student_management;
CREATE TABLE student (
    id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(200),
    age INT,
    country VARCHAR(50)
);
CREATE TABLE class (
    id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50)
);
CREATE TABLE teacher (
    id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(200),
    age INT,
    country VARCHAR(50)
);
insert into student(name,age, country) value ("Dat", 18, "Viet Nam");
insert into student(name,age, country) value ("Toai", 20, "Viet Nam");
insert into class(name) value ("C0723G1");
insert into class(name) value ("C0823G1");
insert into teacher(name, age, country)value("Phuong",25,"USA");
insert into teacher(name, age, country)value("Chanh",35,"USA");
SELECT 
    *
FROM
    student;
SELECT 
    *
FROM
    class;
SELECT 
    *
FROM
    teacher;
DELETE FROM student 
WHERE
    id = 1;
SELECT 
    *
FROM
    teacher
WHERE
    name = 'Phuong';
UPDATE teacher 
SET 
    country = 'Viet Nam'
WHERE
    id = '1';
SELECT 
    *
FROM
    teacher;


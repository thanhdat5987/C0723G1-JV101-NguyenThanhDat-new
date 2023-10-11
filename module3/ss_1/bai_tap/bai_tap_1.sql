create database student_management;
use student_management;
CREATE TABLE student (
    student_id INT PRIMARY KEY AUTO_INCREMENT,
    student_name VARCHAR(200),
    student_age INT,
    student_country VARCHAR(50)
);
CREATE TABLE class (
    class_id INT PRIMARY KEY AUTO_INCREMENT,
    class_name VARCHAR(50)
);
CREATE TABLE teacher (
    teacher_id INT PRIMARY KEY AUTO_INCREMENT,
    teacher_name VARCHAR(200),
    teacher_age INT,
    teacher_country VARCHAR(50)
);
insert into student(student_name,student_age, student_country) value("Dat", 18, "Viet Nam");
insert into student(student_name,student_age, student_country) value("Toai", 20, "Viet Nam");
insert into class(class_name) value("C0723G1");
insert into class(class_name) value("C0823G1");
insert into teacher(teacher_name, teacher_age, teacher_country) value("Phuong",25,"USA");
insert into teacher(teacher_name, teacher_age, teacher_country) value("Chanh",35,"USA");
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
    student_id = 1;
SELECT 
    *
FROM
    teacher
WHERE
    teacher_name = 'Phuong';
UPDATE teacher 
SET 
    teacher_country = 'Viet Nam'
WHERE
    teacher_id = '1';
SELECT 
    *
FROM
    teacher;


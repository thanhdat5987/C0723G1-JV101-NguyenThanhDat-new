CREATE DATABASE if not exists student_management;
USE student_management;
CREATE TABLE class (
    class_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    class_name VARCHAR(60) NOT NULL,
    start_date DATETIME NOT NULL,
    `status` BIT
);
CREATE TABLE student (
    student_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    student_name VARCHAR(30) NOT NULL,
    address VARCHAR(50),
    phone VARCHAR(20),
    `status` BIT,
    class_id INT NOT NULL,
    FOREIGN KEY (class_id)
        REFERENCES class (class_id)
);
CREATE TABLE `subject` (
    sub_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    sub_name VARCHAR(30) NOT NULL,
    credit TINYINT NOT NULL DEFAULT 1 CHECK (credit >= 1),
    `status` BIT DEFAULT 1
);
CREATE TABLE mark (
    mark_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    sub_id INT NOT NULL,
    student_id INT NOT NULL,
    mark FLOAT DEFAULT 0 CHECK (mark BETWEEN 0 AND 100),
    exam_times TINYINT DEFAULT 1,
    UNIQUE (sub_id , student_id),
    FOREIGN KEY (sub_id)
        REFERENCES Subject (sub_id),
    FOREIGN KEY (student_id)
        REFERENCES student (student_id)
);
 INSERT INTO class
VALUES (1, 'A1', '2008-12-20', 1);
INSERT INTO class
VALUES (2, 'A2', '2008-12-22', 1);
INSERT INTO class
VALUES (3, 'B3', current_date, 0);
INSERT INTO student (student_name, address, phone, `status`, class_id)
VALUES ('Hung', 'Ha Noi', '0912113113', 1, 1);
INSERT INTO student (student_name, address, `status`, class_id)
VALUES ('Hoa', 'Hai phong', 1, 1);
INSERT INTO student (student_name, address, phone, `status`, class_id)
VALUES ('Manh', 'HCM', '0123123123', 0, 2);
INSERT INTO `subject`
VALUES (1, 'CF', 5, 1),
 (2, 'C', 6, 1),
 (3, 'HDJ', 5, 1),
 (4, 'RDBMS', 10, 1);
 INSERT INTO mark (sub_id, student_id, mark, exam_times)
VALUES (1, 1, 8, 1),
 (1, 2, 10, 2),
 (2, 1, 12, 1);
/*Bài tập - Truy vấn dữ liệu với CSDL Quản lý sinh viên*/
/*Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘H’*/
SELECT 
    *
FROM
    student
WHERE
    student_name LIKE 'H%';

/*Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12*/
SELECT 
    *
FROM
    class
WHERE
    MONTH(start_date) = 12;

/*Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5*/
SELECT 
    *
FROM
    subject
WHERE
    credit BETWEEN 3 AND 5;

/*Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2 */
set sql_safe_updates =0;
UPDATE student 
SET 
    class_id = 2
WHERE
    student_name = 'Hung';

/*Hiển thị các thông tin: StudentName, SubName, Mark. Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần.*/
SELECT 
    student.student_name, mark.mark, `subject`.sub_name
FROM
    student
        INNER JOIN
    mark ON student.student_id = mark.student_id
        INNER JOIN
    `subject` ON `subject`.sub_id = mark.sub_id
ORDER BY mark.mark DESC , student.student_name ASC;

-- Thực hành Sử dụng các hàm thông dụng trong SQL
-- 1. Hiển thị số lượng sinh viên ở từng nơi
use student_management;
select address, count(student_id) from student
group by address;

-- 2. Tính điểm trung bình các môn học của mỗi học viên
select student.student_id, student.student_name, avg(mark.mark) as avg_mark
from student join mark
on student.student_id = mark.student_id
group by student.student_id, student.student_name;

-- 3. Hiển thị những bạn học viên co điểm trung bình các môn học lớn hơn 15

select student.student_id, student.student_name, avg(mark.mark) as avg_mark
from student join mark
on student.student_id = mark.student_id
group by student.student_id, student.student_name
having avg(mark.mark) > 15;

-- 4. Hiển thị thông tin các học viên có điểm trung bình lớn nhất.
select student.student_id, student.student_name, avg(mark.mark) as avg_mark
from student join mark
on student.student_id = mark.student_id
group by student.student_id, student.student_name
having avg(mark.mark)>= all(select avg(mark) from mark group by mark.student_id);


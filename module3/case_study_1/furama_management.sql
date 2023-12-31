create database if not exists quan_ly_furama;
use quan_ly_furama;
/*drop database quan_ly_furama;*/
CREATE TABLE vi_tri (
    ma_vi_tri INT PRIMARY KEY AUTO_INCREMENT,
    ten_vi_tri VARCHAR(45) NOT NULL UNIQUE
);
CREATE TABLE trinh_do (
    ma_trinh_do INT PRIMARY KEY AUTO_INCREMENT,
    ten_trinh_do VARCHAR(45)
);
CREATE TABLE bo_phan (
    ma_bo_phan INT PRIMARY KEY AUTO_INCREMENT,
    ten_bo_phan VARCHAR(45) NOT NULL UNIQUE
);
CREATE TABLE nhan_vien (
    ma_nhan_vien INT PRIMARY KEY AUTO_INCREMENT,
    ho_ten VARCHAR(45) NOT NULL,
    ngay_sinh DATE NOT NULL,
    so_cmnd VARCHAR(45) NOT NULL,
    luong DOUBLE NOT NULL,
    so_dien_thoai VARCHAR(45) NOT NULL,
    email VARCHAR(45) NOT NULL,
    dia_chi VARCHAR(45) NOT NULL,
    ma_vi_tri INT NOT NULL,
    ma_trinh_do INT NOT NULL,
    ma_bo_phan INT NOT NULL,
    FOREIGN KEY (ma_vi_tri)
        REFERENCES vi_tri (ma_vi_tri)on delete cascade on update cascade,
    FOREIGN KEY (ma_trinh_do)
        REFERENCES trinh_do (ma_trinh_do)on delete cascade on update cascade,
    FOREIGN KEY (ma_bo_phan)
        REFERENCES bo_phan (ma_bo_phan)on delete cascade on update cascade
);
CREATE TABLE loai_khach (
    ma_loai_khach INT PRIMARY KEY AUTO_INCREMENT,
    ten_loai_khach VARCHAR(45) NOT NULL
);
CREATE TABLE khach_hang (
    ma_khach_hang INT PRIMARY KEY AUTO_INCREMENT,
    ma_loai_khach INT NOT NULL,
    FOREIGN KEY (ma_loai_khach)
        REFERENCES loai_khach (ma_loai_khach)on delete cascade on update cascade,
    ho_ten VARCHAR(45) NOT NULL,
    ngay_sinh DATE NOT NULL,
    gioi_tinh BIT(1) NOT NULL,
    so_cmnd VARCHAR(45) NOT NULL UNIQUE,
    so_dien_thoai VARCHAR(45) NOT NULL UNIQUE,
    email VARCHAR(45) NOT NULL UNIQUE,
    dia_chi VARCHAR(45)
);
CREATE TABLE loai_dich_vu (
    ma_loai_dich_vu INT PRIMARY KEY AUTO_INCREMENT,
    ten_loai_dich_vu VARCHAR(45) NOT NULL UNIQUE
);
CREATE TABLE kieu_thue (
    ma_kieu_thue INT PRIMARY KEY AUTO_INCREMENT,
    ten_kieu_thue VARCHAR(45) NOT NULL UNIQUE
);
CREATE TABLE dich_vu (
    ma_dich_vu INT PRIMARY KEY AUTO_INCREMENT,
    ten_dich_vu VARCHAR(45) NOT NULL UNIQUE,
    dien_tich INT NOT NULL,
    chi_phi_thue DOUBLE NOT NULL,
    so_nguoi_toi_da INT NOT NULL,
    ma_kieu_thue INT NOT NULL,
    ma_loai_dich_vu INT NOT NULL,
    FOREIGN KEY (ma_kieu_thue)
        REFERENCES kieu_thue (ma_kieu_thue)on delete cascade on update cascade,
    FOREIGN KEY (ma_loai_dich_vu)
        REFERENCES loai_dich_vu (ma_loai_dich_vu)on delete cascade on update cascade,
    tieu_chuan_phong VARCHAR(45) NOT NULL,
    mo_ta_tien_nghi_khac VARCHAR(45),
    dien_tich_ho_boi DOUBLE,
    so_tang INT,
    dich_vu_mien_phi_di_kem TEXT
);
CREATE TABLE hop_dong (
    ma_hop_dong INT PRIMARY KEY AUTO_INCREMENT,
    ngay_lam_hop_dong DATETIME NOT NULL,
    ngay_ket_thuc DATETIME NOT NULL,
    tien_dat_coc DOUBLE NOT NULL,
    ma_nhan_vien INT NOT NULL,
    ma_khach_hang INT NOT NULL,
    ma_dich_vu INT NOT NULL,
    FOREIGN KEY (ma_nhan_vien)
        REFERENCES nhan_vien (ma_nhan_vien)on delete cascade on update cascade,
    FOREIGN KEY (ma_khach_hang)
        REFERENCES khach_hang (ma_khach_hang)on delete cascade on update cascade,
    FOREIGN KEY (ma_dich_vu)
        REFERENCES dich_vu (ma_dich_vu)on delete cascade on update cascade
);
CREATE TABLE dich_vu_di_kem (
    ma_dich_vu_di_kem INT AUTO_INCREMENT PRIMARY KEY,
    ten_dich_vu_di_kem VARCHAR(45) NOT NULL UNIQUE,
    gia DOUBLE NOT NULL,
    don_vi VARCHAR(10) NOT NULL,
    trang_thai VARCHAR(45)
);
CREATE TABLE hop_dong_chi_tiet (
    ma_hop_dong_chi_tiet INT PRIMARY KEY AUTO_INCREMENT,
    ma_hop_dong INT NOT NULL,
    ma_dich_vu_di_kem INT NOT NULL,
    FOREIGN KEY (ma_hop_dong)
        REFERENCES hop_dong (ma_hop_dong)on delete cascade on update cascade,
    FOREIGN KEY (ma_dich_vu_di_kem)
        REFERENCES dich_vu_di_kem (ma_dich_vu_di_kem)on delete cascade on update cascade,
    so_luong INT NOT NULL
);

/*Task 1*/
INSERT INTO vi_tri (ten_vi_tri)
VALUES
('Quản Lý'),
('Nhân Viên');
INSERT INTO trinh_do (ten_trinh_do)
VALUES
('Trung Cấp'),
('Cao Đẳng'),
('Đại Học'),
('Sau Đại Học');
INSERT INTO bo_phan (ten_bo_phan)
VALUES
('Sale-Marketing'),
('Hành chính'),
('Phục vụ'),
('Quản lý');
INSERT INTO loai_khach (ten_loai_khach)
VALUES
('Diamond'),
('Platinium'),
('Gold'),
('Silver'),
('Member');
INSERT INTO nhan_vien (ho_ten, ngay_sinh, so_cmnd, luong, so_dien_thoai, email, dia_chi, ma_vi_tri, ma_trinh_do, ma_bo_phan)
VALUES
( 'Nguyễn Văn An', '1970-11-07', '456231786', 10000000, '0901234121', 'annguyen@gmail.com', '295 Nguyễn Tất Thành, Đà Nẵng', 1, 3, 1),
( 'Lê Văn Bình', '1997-04-09', '654231234', 7000000, '0934212314', 'binhlv@gmail.com', '22 Yên Bái, Đà Nẵng', 1, 2, 2),
( 'Hồ Thị Yến', '1995-12-12', '999231723', 14000000, '0412352315', 'thiyen@gmail.com', 'K234/11 Điện Biên Phủ, Gia Lai', 1, 3, 2),
( 'Võ Công Toản', '1980-04-04', '123231365', 17000000, '0374443232', 'toan0404@gmail.com', '77 Hoàng Diệu, Quảng Trị', 1, 4, 4),
( 'Nguyễn Bỉnh Phát', '1999-12-09', '454363232', 6000000, '0902341231', 'phatphat@gmail.com', '43 Yên Bái, Đà Nẵng', 2, 1, 1),
( 'Khúc Nguyễn An Nghi', '2000-11-08', '964542311', 7000000, '0978653213', 'annghi20@gmail.com', '294 Nguyễn Tất Thành, Đà Nẵng', 2, 2, 3),
( 'Nguyễn Hữu Hà', '1993-01-01', '534323231', 8000000, '0941234553', 'nhh0101@gmail.com', '4 Nguyễn Chí Thanh, Huế', 2, 3, 2),
( 'Nguyễn Hà Đông', '1989-09-03', '234414123', 9000000, '0642123111', 'donghanguyen@gmail.com', '111 Hùng Vương, Hà Nội', 2, 4, 4),
( 'Tòng Hoang', '1982-09-03', '256781231', 6000000, '0245144444', 'hoangtong@gmail.com', '213 Hàm Nghi, Đà Nẵng', 2, 4, 4),
( 'Nguyễn Công Đạo', '1994-01-08', '755434343', 8000000, '0988767111', 'nguyencongdao12@gmail.com', '6 Hoà Khánh, Đồng Nai', 2, 3, 2);
INSERT INTO khach_hang (ho_ten, ngay_sinh, gioi_tinh, so_cmnd, so_dien_thoai, email, dia_chi,ma_loai_khach)
VALUES
( 'Nguyễn Thị Hào', '1970-11-07', 0, '643431213', '0945423362', 'thihao07@gmail.com', '23 Nguyễn Hoàng, Đà Nẵng',5),
( 'Phạm Xuân Diệu', '1992-08-08', 1, '865342123', '0954333333', 'xuandieu92@gmail.com', 'K77/22 Thái Phiên, Quảng Trị',3),
( 'Trương Đình Nghệ', '1990-02-27', 1, '488645199', '0373213122', 'nghenhan2702@gmail.com', 'K323/12 Ông Ích Khiêm, Vinh',1),
( 'Dương Văn Quan', '1981-07-08', 1, '543432111', '0490039241', 'duongquan@gmail.com', 'K453/12 Lê Lợi, Đà Nẵng',1),
( 'Hoàng Trần Nhi Nhi', '1995-12-09', 0, '795453345', '0312345678', 'nhinhi123@gmail.com', '224 Lý Thái Tổ, Gia Lai',4),
( 'Tôn Nữ Mộc Châu', '2005-12-06', 0, '732434215', '0988888844', 'tonnuchau@gmail.com', '37 Yên Thế, Đà Nẵng',4),
( 'Nguyễn Mỹ Kim', '1984-04-08', 0, '856453123', '0912345698', 'kimcuong84@gmail.com', 'K123/45 Lê Lợi, Hồ Chí Minh',1),
( 'Nguyễn Thị Hào', '1999-04-08', 0, '965656433', '0763212345', 'haohao99@gmail.com', '55 Nguyễn Văn Linh, Kon Tum',3),
( 'Trần Đại Danh', '1994-07-01', 1, '432341235', '0643343433', 'danhhai99@gmail.com', '24 Lý Thường Kiệt, Quảng Ngãi',1),
( 'Nguyễn Tâm Đắc', '1989-07-01', 1, '344343432', '0987654321', 'dactam@gmail.com', '22 Ngô Quyền, Đà Nẵng',2);
insert into kieu_thue(ten_kieu_thue) value ('year'),('month'),('day'),('hour');
insert into loai_dich_vu(ten_loai_dich_vu) value('villa'),('room'),('house');
INSERT INTO dich_vu(ten_dich_vu, dien_tich, chi_phi_thue, so_nguoi_toi_da, ma_kieu_thue, ma_loai_dich_vu, tieu_chuan_phong, mo_ta_tien_nghi_khac, dien_tich_ho_boi, so_tang, dich_vu_mien_phi_di_kem)
VALUES
('Villa Beach Front', 25000, 1000000, 10, 3, 1, 'vip', 'Có hồ bơi', 500, 4, null),
('House Princess 01', 14000, 5000000, 7, 2, 2, 'vip', 'Có thêm bếp nướng', null, 3, null),
('Room Twin 01', 5000, 1000000, 2, 4, 3, 'normal', 'Có tivi', null, null, '1 Xe máy, 1 Xe đạp'),
('Villa No Beach Front', 22000, 9000000, 8, 3, 1, 'normal', 'Có hồ bơi', 300, 3, null),
('House Princess 02', 10000, 4000000, 5, 3, 2, 'normal', 'Có thêm bếp nướng', null, 2, null),
('Room Twin 02', 3000, 900000, 2, 4, 3, 'normal', 'Có tivi', null, null, '1 Xe máy');
INSERT INTO dich_vu_di_kem (ten_dich_vu_di_kem, gia, don_vi, trang_thai)
VALUES
('Karaoke', 10000, 'giờ', 'tiện nghi, hiện tại'),
('Thuê xe máy', 10000, 'chiếc', 'hỏng 1 xe'),
('Thuê xe đạp', 20000, 'chiếc', 'tốt'),
('Buffet buổi sáng', 15000, 'suất', 'đầy đủ đồ ăn, tráng miệng'),
('Buffet buổi trưa', 90000, 'suất', 'đầy đủ đồ ăn, tráng miệng'),
('Buffet buổi tối', 16000, 'suất', 'đầy đủ đồ ăn, tráng miệng');

insert into hop_dong (ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, ma_nhan_vien, ma_khach_hang, ma_dich_vu)
values
('2020-12-08', '2020-12-08', 0, 3, 1, 3),
('2020-07-14', '2020-07-21', 200000, 7, 3, 1),
('2021-03-15', '2021-03-17', 50000, 3, 4, 2),
('2021-01-14', '2021-01-18', 100000, 7, 5, 5),
('2021-07-14', '2021-07-15', 0, 7, 2, 6),
('2021-06-01', '2021-06-03', 0, 7, 7, 6),
('2021-09-02', '2021-09-05', 100000, 7, 4, 4),
('2021-06-17', '2021-06-18', 150000, 3, 4, 1),
('2020-11-19', '2020-11-19', 0, 3, 4, 3),
('2021-04-12', '2021-04-14', 0, 10, 3, 5),
('2021-04-25', '2021-04-25', 0, 2, 2, 1),
('2021-05-25', '2021-05-27', 0, 7, 10, 1);

insert into hop_dong_chi_tiet (so_luong, ma_hop_dong, ma_dich_vu_di_kem)
values
(5, 2, 4),
(8, 2, 5),
(15, 2, 6),
(1, 3, 1),
(11, 3, 2),
(1, 1, 3),
(2, 1, 2),
(2, 12, 2);

/* 2.Hiển thị thông tin của tất cả nhân viên có trong hệ thống có TÊN (không phải là họ) bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.*/
SELECT 
    *
FROM
    nhan_vien
WHERE
    (ho_ten REGEXP '\\sH\\w*$'
        OR ho_ten REGEXP '\\sT\\w*$'
        OR ho_ten REGEXP '\\sK\\w*$')
        AND LENGTH(ho_ten) <= 15;

/* 3.Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi 
và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.*/
SELECT 
    *
FROM
    khach_hang
WHERE
    ((YEAR(CURDATE()) - YEAR(ngay_sinh)) - (RIGHT(CURDATE(), 5) < RIGHT(ngay_sinh, 5)) BETWEEN 18 AND 50)
        AND (dia_chi LIKE '% Đà Nẵng'
        OR dia_chi LIKE '% Quảng Trị');

/* 4.Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. 
Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng.
 Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.*/
SELECT 
    khach_hang.ho_ten, COUNT(ma_hop_dong) AS so_lan_dat_phong
FROM
    khach_hang
        JOIN
    hop_dong ON khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
        JOIN
    loai_khach ON loai_khach.ma_loai_khach = khach_hang.ma_loai_khach
WHERE
    loai_khach.ten_loai_khach = 'Diamond'
GROUP BY khach_hang.ma_khach_hang
ORDER BY so_lan_dat_phong ASC;

/*5.Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tong_tien 
(Với tổng tiền được tính theo công thức như sau: Chi Phí Thuê + Số Lượng * Giá, với Số Lượng và Giá là từ bảng dich_vu_di_kem, 
hop_dong_chi_tiet) cho tất cả các khách hàng đã từng đặt phòng. (những khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra). */

SELECT 
    khach_hang.ma_khach_hang,
    khach_hang.ho_ten,
    loai_khach.ten_loai_khach,
    hop_dong.ngay_lam_hop_dong,
    hop_dong.ngay_ket_thuc,
    (dich_vu.chi_phi_thue + ifnull(temp.tong_tien_dich_vu,0)) AS tong_tien
FROM
khach_hang
        JOIN
    loai_khach ON khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
        LEFT JOIN
    hop_dong ON hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
        LEFT JOIN
    dich_vu ON hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
		LEFT JOIN
     (SELECT 
    hop_dong_chi_tiet.ma_hop_dong AS ma_hop_dong,
    SUM(dich_vu_di_kem.gia * hop_dong_chi_tiet.so_luong) AS tong_tien_dich_vu
FROM
    hop_dong_chi_tiet
        LEFT JOIN
    dich_vu_di_kem ON dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
GROUP BY hop_dong_chi_tiet.ma_hop_dong
    ) AS temp ON hop_dong.ma_hop_dong = temp.ma_hop_dong;
    
  /*6.Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu 
  của tất cả các loại dịch vụ chưa từng được khách hàng thực hiện đặt từ quý 1 của năm 2021 
  (Quý 1 là tháng 1, 2, 3).
  */
  SELECT 
    dich_vu.ma_dich_vu,
    dich_vu.ten_dich_vu,
    dich_vu.dien_tich,
    dich_vu.chi_phi_thue,
    loai_dich_vu.ten_loai_dich_vu
FROM
    dich_vu
  left join loai_dich_vu on dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu
  left join hop_dong on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
  where (dich_vu.ma_dich_vu not in(select dich_vu.ma_dich_vu 
									from dich_vu 
									join hop_dong on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu 
									where(year(ngay_lam_hop_dong)=2021 and month(ngay_lam_hop_dong)in (1,2,3))) 
		)
  group by dich_vu.ma_dich_vu;

/*7. Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu của tất cả các loại dịch vụ 
đã từng được khách hàng đặt phòng trong năm 2020 nhưng chưa từng được khách hàng đặt phòng trong năm 2021.*/
SELECT 
    dich_vu.ma_dich_vu,
    dich_vu.ten_dich_vu,
    dich_vu.dien_tich,
    dich_vu.so_nguoi_toi_da,
    dich_vu.chi_phi_thue,
    loai_dich_vu.ten_loai_dich_vu
FROM
    dich_vu
        LEFT JOIN
    loai_dich_vu ON dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu
        LEFT JOIN
    hop_dong ON dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
WHERE
    (dich_vu.ma_dich_vu IN (SELECT 
            dich_vu.ma_dich_vu
        FROM
            dich_vu
                JOIN
            hop_dong ON dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
        WHERE
            (YEAR(ngay_lam_hop_dong) = 2020))
        AND dich_vu.ma_dich_vu NOT IN (SELECT 
            dich_vu.ma_dich_vu
        FROM
            dich_vu
                JOIN
            hop_dong ON dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
        WHERE
            (YEAR(ngay_lam_hop_dong) = 2021)))
GROUP BY dich_vu.ma_dich_vu;

/*8.Hiển thị thông tin ho_ten khách hàng có trong hệ thống, với yêu cầu ho_ten không trùng nhau.
Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên.*/
/*Cách 1*/
SELECT 
    khach_hang.ho_ten
FROM
    khach_hang
GROUP BY ho_ten;

/*Cách 2*/
SELECT DISTINCT
    khach_hang.ho_ten
FROM
    khach_hang;
    
/*9.Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2021 
thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.*/

SELECT 
    MONTH(hop_dong.ngay_lam_hop_dong) AS thang,
    COUNT(hop_dong.ma_hop_dong) AS so_luong_khach_hang
FROM
    hop_dong
WHERE
    (YEAR(ngay_lam_hop_dong) = 2021)
GROUP BY thang;

/*10.Hiển thị thông tin tương ứng với từng hợp đồng thì đã sử dụng bao nhiêu dịch vụ đi kèm. 
Kết quả hiển thị bao gồm ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, so_luong_dich_vu_di_kem 
(được tính dựa trên việc sum so_luong ở dich_vu_di_kem).*/

SELECT 
    hop_dong.ma_hop_dong,
    hop_dong.ngay_lam_hop_dong,
    hop_dong.ngay_ket_thuc,
    hop_dong.tien_dat_coc,
    SUM(hop_dong_chi_tiet.so_luong) AS so_luong_dich_vu_di_kem
FROM
    hop_dong
        LEFT JOIN
    hop_dong_chi_tiet ON hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
GROUP BY hop_dong.ma_hop_dong;

/* 11.	Hiển thị thông tin các dịch vụ đi kèm đã được sử dụng bởi những khách hàng có ten_loai_khach là “Diamond” 
và có dia_chi ở “Vinh” hoặc “Quảng Ngãi”.*/
SELECT 
    dich_vu_di_kem.*
FROM
    dich_vu_di_kem
        JOIN
    hop_dong_chi_tiet ON dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
        JOIN
    hop_dong ON hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
        JOIN
    khach_hang ON hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
        JOIN
    loai_khach ON khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
WHERE
    loai_khach.ten_loai_khach = 'Diamond'
        AND (khach_hang.dia_chi LIKE '% Quảng Ngãi'
        OR khach_hang.dia_chi LIKE '% Vinh')
;
/*12.	Hiển thị thông tin ma_hop_dong, ho_ten (nhân viên), ho_ten (khách hàng), so_dien_thoai (khách hàng), ten_dich_vu, 
so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem), tien_dat_coc của tất cả các dịch vụ 
đã từng được khách hàng đặt vào 3 tháng cuối năm 2020 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2021.*/

SELECT 
    hop_dong.ma_hop_dong,
    nhan_vien.ho_ten,
    khach_hang.ho_ten,
    khach_hang.so_dien_thoai,
    loai_dich_vu.ten_loai_dich_vu,
    SUM(dich_vu_di_kem.ma_dich_vu_di_kem) AS so_luong_dich_vu_di_kem,
    hop_dong.tien_dat_coc
FROM
    hop_dong
        LEFT JOIN
    nhan_vien ON hop_dong.ma_nhan_vien = nhan_vien.ma_nhan_vien
        LEFT JOIN
    khach_hang ON hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
        LEFT JOIN
    dich_vu ON hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
        LEFT JOIN
    loai_dich_vu ON dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu
        LEFT JOIN
    hop_dong_chi_tiet ON hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
        LEFT JOIN
    dich_vu_di_kem ON hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
WHERE
    dich_vu.ma_dich_vu IN (SELECT 
            dich_vu.ma_dich_vu
        FROM
            dich_vu
                JOIN
            hop_dong ON dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
        WHERE
            (QUARTER(hop_dong.ngay_lam_hop_dong) = 4
                AND YEAR(hop_dong.ngay_lam_hop_dong) = 2020))
        AND dich_vu.ma_dich_vu NOT IN (SELECT 
            dich_vu.ma_dich_vu
        FROM
            dich_vu
                JOIN
            hop_dong ON dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
        WHERE
            (QUARTER(hop_dong.ngay_lam_hop_dong) IN (1 , 2)
                AND YEAR(hop_dong.ngay_lam_hop_dong) = 2021))
GROUP BY hop_dong.ma_hop_dong;

/*13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. 
(Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).*/
SELECT 
    dich_vu_di_kem.*,
    SUM(hop_dong_chi_tiet.so_luong) AS tong_so_luong_dvdk
FROM
    dich_vu_di_kem
        JOIN
    hop_dong_chi_tiet ON dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
GROUP BY ma_dich_vu_di_kem
HAVING tong_so_luong_dvdk >= ALL (SELECT 
        SUM(hop_dong_chi_tiet.so_luong)
    FROM
        hop_dong_chi_tiet
    GROUP BY ma_dich_vu_di_kem);

    /* 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. 
    Thông tin hiển thị bao gồm ma_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem, so_lan_su_dung 
    (được tính dựa trên việc count các ma_dich_vu_di_kem).*/
    SET sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY',''));
SELECT 
    hop_dong_chi_tiet.ma_hop_dong,
    loai_dich_vu.ten_loai_dich_vu,
    dich_vu_di_kem.ten_dich_vu_di_kem,
    COUNT(hop_dong_chi_tiet.ma_dich_vu_di_kem) AS so_lan_su_dung
FROM
    hop_dong
        JOIN
    dich_vu ON hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
        JOIN
    hop_dong_chi_tiet ON hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
        JOIN
    loai_dich_vu ON dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu
        JOIN
    dich_vu_di_kem ON hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
GROUP BY hop_dong_chi_tiet.ma_dich_vu_di_kem
HAVING so_lan_su_dung = 1
    ;
    
    /*15.	Hiển thi thông tin của tất cả nhân viên bao gồm ma_nhan_vien, ho_ten, ten_trinh_do, ten_bo_phan, 
    so_dien_thoai, dia_chi mới chỉ lập được tối đa 3 hợp đồng từ năm 2020 đến 2021.*/
SELECT 
    nhan_vien.ma_nhan_vien,
    nhan_vien.ho_ten,
    trinh_do.ten_trinh_do,
    bo_phan.ten_bo_phan,
    nhan_vien.so_dien_thoai,
    nhan_vien.dia_chi
FROM
    nhan_vien
        JOIN
    trinh_do ON nhan_vien.ma_trinh_do = trinh_do.ma_trinh_do
        JOIN
    bo_phan ON nhan_vien.ma_bo_phan = bo_phan.ma_bo_phan
WHERE
    nhan_vien.ma_nhan_vien IN (SELECT 
            ma_nhan_vien
        FROM
            hop_dong
        WHERE
            (YEAR(ngay_lam_hop_dong) IN (2020 , 2021)))
        AND nhan_vien.ma_nhan_vien IN (SELECT 
            ma_nhan_vien
        FROM
            hop_dong
        GROUP BY ma_nhan_vien
        HAVING COUNT(ma_hop_dong) <= 3)
    ;
    
    /*16.Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021.*/
    -- set sql_safe_updates =0;
CREATE VIEW w_nhan_vien_co_duoc_hop_dong AS
    SELECT DISTINCT
        nhan_vien.ma_nhan_vien AS ma_nhan_vien
    FROM
        nhan_vien
            JOIN
        hop_dong ON hop_dong.ma_nhan_vien = nhan_vien.ma_nhan_vien
    WHERE
        YEAR(hop_dong.ngay_lam_hop_dong) IN (2019 , 2020, 2021);
DELETE FROM nhan_vien 
WHERE
    ma_nhan_vien NOT IN (SELECT 
        ma_nhan_vien
    FROM
        w_nhan_vien_co_duoc_hop_dong);
/* 17.	Cập nhật thông tin những khách hàng có ten_loai_khach từ Platinum lên Diamond,
 chỉ cập nhật những khách hàng đã từng đặt phòng với Tổng Tiền thanh toán trong năm 2021 là lớn hơn 10.000.000 VNĐ. */
CREATE VIEW w_khach_hang_01 AS
    SELECT 
        khach_hang.ma_khach_hang,
        khach_hang.ho_ten,
        khach_hang.ma_Loai_khach,
        loai_khach.ten_loai_khach,
        SUM((dich_vu.chi_phi_thue + IFNULL(temp.tong_tien_dich_vu, 0))) AS tong_tien
    FROM
        khach_hang
            JOIN
        loai_khach ON khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
            LEFT JOIN
        hop_dong ON hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
            LEFT JOIN
        dich_vu ON hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
            LEFT JOIN
        (SELECT 
            hop_dong_chi_tiet.ma_hop_dong AS ma_hop_dong,
                SUM(dich_vu_di_kem.gia * hop_dong_chi_tiet.so_luong) AS tong_tien_dich_vu
        FROM
            hop_dong_chi_tiet
        LEFT JOIN dich_vu_di_kem ON dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
        GROUP BY hop_dong_chi_tiet.ma_hop_dong) AS temp ON hop_dong.ma_hop_dong = temp.ma_hop_dong
    WHERE
        YEAR(ngay_lam_hop_dong) = 2021
            AND loai_khach.ten_loai_khach = 'Platinium'
    GROUP BY (khach_hang.ma_khach_hang)
    HAVING tong_tien > 1000000
    ;
UPDATE khach_hang 
SET 
    ma_loai_khach = 1
WHERE
    ma_khach_hang IN (SELECT 
            ma_khach_hang
        FROM
            w_khach_hang_01);
            
/*18.Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc giữa các bảng).*/
CREATE VIEW khach_hang_02 AS
    SELECT DISTINCT
        khach_hang.ma_khach_hang
    FROM
        khach_hang
            JOIN
        hop_dong ON khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
    WHERE
        YEAR(hop_dong.ngay_lam_hop_dong) < 2021;
DELETE FROM khach_hang 
WHERE
    ma_khach_hang IN (SELECT 
        ma_khach_hang
    FROM
        khach_hang_02);
/* 19.	Cập nhật giá cho các dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2020 lên gấp đôi.*/
CREATE VIEW w_dvdk_su_dung_tren_10_lan AS
    SELECT 
        dich_vu_di_kem.ma_dich_vu_di_kem
    FROM
        dich_vu_di_kem
            JOIN
        hop_dong_chi_tiet ON dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
    GROUP BY (dich_vu_di_kem.ma_dich_vu_di_kem)
    HAVING SUM(hop_dong_chi_tiet.so_luong) > 10
;
UPDATE dich_vu_di_kem 
SET 
    gia = gia * 2
WHERE
    ma_dich_vu_di_kem IN (SELECT 
            ma_dich_vu_di_kem
        FROM
            w_dvdk_su_dung_tren_10_lan);

/*20.	Hiển thị thông tin của tất cả các nhân viên và khách hàng có trong hệ thống,
 thông tin hiển thị bao gồm id (ma_nhan_vien, ma_khach_hang), ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi.*/
SELECT 
    ma_nhan_vien AS id,
    ho_ten,
    email,
    so_dien_thoai,
    ngay_sinh,
    dia_chi
FROM
    nhan_vien 
UNION SELECT 
    ma_khach_hang,
    ho_ten,
    email,
    so_dien_thoai,
    ngay_sinh,
    dia_chi
FROM
    khach_hang;
    
/*21.	Tạo khung nhìn có tên là v_nhan_vien để lấy được thông tin của tất cả các nhân viên có địa chỉ là “Gia Lai” 
và đã từng lập hợp đồng cho một hoặc nhiều khách hàng bất kì với ngày lập hợp đồng là “2020-12-08”.*/    

CREATE VIEW v_nhan_vien AS
    SELECT 
        nhan_vien.*
    FROM
        nhan_vien
            JOIN
        hop_dong ON nhan_vien.ma_nhan_vien = hop_dong.ma_nhan_vien
    WHERE
        dia_chi LIKE '% Gia Lai'
            AND DATE(hop_dong.ngay_lam_hop_dong) = '2020-12-08';
            
/*
22.	Thông qua khung nhìn v_nhan_vien thực hiện cập nhật địa chỉ thành “Liên Chiểu” 
đối với tất cả các nhân viên được nhìn thấy bởi khung nhìn này.
*/
UPDATE v_nhan_vien 
SET 
    dia_chi = 'Liên Chiểu'
/*23.Tạo Stored Procedure sp_xoa_khach_hang dùng để xóa thông tin của một khách hàng nào đó với ma_khach_hang 
được truyền vào như là 1 tham số của sp_xoa_khach_hang.*/
delimiter //
create procedure sp_xoa_khach_hang (id int)
begin
delete from khach_hang where ma_khach_hang = id;
end //
delimiter ;
call sp_xoa_khach_hang(1);
/*
24.	Tạo Stored Procedure sp_them_moi_hop_dong dùng để thêm mới vào bảng hop_dong với yêu cầu sp_them_moi_hop_dong 
phải thực hiện kiểm tra tính hợp lệ của dữ liệu bổ sung, với nguyên tắc không được trùng khóa chính 
và đảm bảo toàn vẹn tham chiếu đến các bảng liên quan.
*/

-- c1
delimiter //
create procedure sp_them_moi_hop_dong(nlhd DATETIME,nkt DATETIME,tdc DOUBLE ,mnv INT ,mkh INT ,mdv INT )
    begin
    if (exists (select ma_nhan_vien from nhan_vien where ma_nhan_vien = mnv) and exists (select ma_khach_hang from khach_hang where ma_khach_hang = mkh) and exists  (select ma_dich_vu from dich_vu where ma_dich_vu = mdv))
    then insert into hop_dong (ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, ma_nhan_vien, ma_khach_hang, ma_dich_vu) 
	values(nlhd, nkt, tdc, mnv, mkh, mdv);
    end if ;
    end //
delimiter ;
call sp_them_moi_hop_dong('2023-10-10','2023-10-19',100,1,2,1);
-- c2
delimiter //
create procedure sp_them_moi_hop_dong_2(nlhd DATETIME,nkt DATETIME,tdc DOUBLE ,mnv INT ,mkh INT ,mdv INT )
    begin
    if (mnv in (select ma_nhan_vien from nhan_vien) and mkh in (select ma_khach_hang from khach_hang) and mdv in (select ma_dich_vu from dich_vu))
    then insert into hop_dong (ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, ma_nhan_vien, ma_khach_hang, ma_dich_vu) 
	values(nlhd, nkt, tdc, mnv, mkh, mdv);
	else 
	select 'du lieu khong hop le';
    end if ;
    end //
delimiter ;
call sp_them_moi_hop_dong_2('2023-10-16','2023-10-19',100,1,2,3);

/* 25.	Tạo Trigger có tên tr_xoa_hop_dong khi xóa bản ghi trong bảng hop_dong thì hiển thị tổng số lượng bản ghi còn lại có trong bảng hop_dong ra giao diện console của database.
Lưu ý: Đối với MySQL thì sử dụng SIGNAL hoặc ghi log thay cho việc ghi ở console.*/

CREATE TABLE lich_su_xoa_hop_dong (
    id INT AUTO_INCREMENT PRIMARY KEY,
    remain_records INT,
    update_day DATETIME
);

delimiter //
create trigger tr_xoa_hop_dong
after delete on hop_dong
for each row
begin
declare total_records int;
select count(ma_hop_dong) into total_records from hop_dong;
insert into lich_su_xoa_hop_dong(remain_records, update_day) value (total_records,now() );
end //
delimiter ;


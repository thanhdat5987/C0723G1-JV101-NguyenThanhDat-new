create database if not exists quan_ly_furama;
use quan_ly_furama;
create table vi_tri(
ma_vi_tri int primary key auto_increment,
ten_vi_tri varchar(45) not null unique
);
create table trinh_do(
ma_trinh_do int primary key auto_increment,
ten_trinh_do varchar(45)
);
create table bo_phan(
ma_bo_phan int primary key auto_increment,
ten_bo_phan varchar(45) not null unique
);
create table nhan_vien(
ma_nhan_vien int primary key auto_increment,
ho_ten varchar(45) not null,
ngay_sinh date not null,
so_cmnd varchar(45) not null,
luong double not null,
so_dien_thoai varchar(45) not null,
email varchar(45)not null,
dia_chi varchar(45)not null,
ma_vi_tri int not null,
ma_trinh_do int not null,
ma_bo_phan int not null,
foreign key (ma_vi_tri) references vi_tri (ma_vi_tri),
foreign key(ma_trinh_do) references trinh_do(ma_trinh_do),
foreign key(ma_bo_phan) references bo_phan(ma_bo_phan)
);
create table loai_khach(
ma_loai_khach int primary key auto_increment,
ten_loai_khach varchar(45) not null
);
create table khach_hang(
ma_khach_hang int primary key auto_increment,
ma_loai_khach int not null,
foreign key (ma_loai_khach) references loai_khach (ma_loai_khach),
ho_ten varchar(45) not null,
ngay_sinh date not null,
gioi_tinh BIT(1) not null,
so_cmnd varchar(45) not null unique,
so_dien_thoai varchar(45) not null unique,
email varchar(45) not null unique,
dia_chi varchar(45)
);
create table loai_dich_vu(
ma_loai_dich_vu int primary key auto_increment,
ten_loai_dich_vu varchar(45) not null unique
);
create table kieu_thue(
ma_kieu_thue int primary key auto_increment,
ten_kieu_thue varchar(45) not null unique
);
create table dich_vu(
ma_dich_vu int primary key auto_increment,
ten_dich_vu varchar(45) not null unique,
dien_tich int not null,
chi_phi_thue double not null,
so_nguoi_toi_da int not null,
ma_kieu_thue int not null,
ma_loai_dich_vu int not null,
foreign key (ma_kieu_thue)references kieu_thue(ma_kieu_thue),
foreign key (ma_loai_dich_vu)references loai_dich_vu(ma_loai_dich_vu),
tieu_chuan_phong varchar(45) not null,
mo_ta_tien_nghi_khac varchar(45),
dien_tich_ho_boi double ,
so_tang int,
dich_vu_mien_phi_di_kem text
);
create table hop_dong(
ma_hop_dong int primary key auto_increment,
ngay_lam_hop_dong datetime not null,
ngay_ket_thuc datetime not null,
tien_dat_coc double not null,
ma_nhan_vien int not null,
ma_khach_hang int not null,
ma_dich_vu int not null,
foreign key (ma_nhan_vien) references nhan_vien(ma_nhan_vien),
foreign key (ma_khach_hang) references khach_hang(ma_khach_hang),
foreign key (ma_dich_vu) references dich_vu(ma_dich_vu)
);
create table dich_vu_di_kem(
ma_dich_vu_di_kem int auto_increment primary key,
ten_dich_vu_di_kem varchar(45) not null unique,
gia double not null,
don_vi varchar(10) not null,
trang_thai varchar(45)
);
create table hop_dong_chi_tiet(
ma_hop_dong_chi_tiet int primary key auto_increment,
ma_hop_dong int not null,
ma_dich_vu_di_kem int not null,
foreign key(ma_hop_dong) references hop_dong(ma_hop_dong),
foreign key(ma_dich_vu_di_kem) references dich_vu_di_kem(ma_dich_vu_di_kem),
so_luong int not null
);
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

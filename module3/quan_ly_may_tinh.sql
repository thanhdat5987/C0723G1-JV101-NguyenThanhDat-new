create database if not exists quan_ly_dich_vu_may_tinh;
/* drop database quan_ly_dich_vu_may_tinh */
use quan_ly_dich_vu_may_tinh;
CREATE TABLE may_tinh (
    ma_may INT primary key auto_increment,
    hang_sx VARCHAR(20),
    vi_tri_may INT
);

create table loai_khach_hang(
ma_loai_khach_hang int primary key auto_increment,
ten_loai_khach_hang varchar(20)
);

create table bang_gia(
ma_gia int primary key auto_increment,
ma_loai_khach_hang int,
gia int,
foreign key (ma_loai_khach_hang) references loai_khach_hang(ma_loai_khach_hang)
);

create table dich_vu_di_kem(
ma_dich_vu int primary key auto_increment,
ten_dich_vu varchar(50),
gia int
);

create table khach_hang(
ma_khach_hang int primary key auto_increment,
ten_khach_hang varchar(20),
so_dien_thoai varchar(20),
mail varchar(50),
ma_loai_khach_hang int,
foreign key(ma_loai_khach_hang) references loai_khach_hang(ma_loai_khach_hang)
);

create table thong_tin_su_dung (
ma_su_dung int primary key auto_increment,
ma_may int,
ma_khach_hang int,
thoi_gian_bat_dau datetime,
thoi_gian_ket_thuc datetime,
foreign key(ma_may) references may_tinh(ma_may),
foreign key(ma_khach_hang) references khach_hang(ma_khach_hang)
);

create table chi_tiet_su_dung(
ma_chi_tiet_su_dung int primary key auto_increment,
ma_su_dung int,
ma_dich_vu_di_kem int,
so_luong_dich_vu_di_kem int,
foreign key(ma_su_dung) references thong_tin_su_dung(ma_su_dung),
foreign key(ma_dich_vu_di_kem) references dich_vu_di_kem(ma_dich_vu)
);


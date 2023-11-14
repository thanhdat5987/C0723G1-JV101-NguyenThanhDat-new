drop database vegetables_management;
create database if not exists vegetables_management;
use vegetables_management;

-- + Mã hàng hoá
-- +Tên hàng hoá
-- +Đơn vị tính (kg, túi, bó,...)
-- + Giá (VNĐ/kg)
-- + Loại hàng hoá: bao gồm một số lại (Rau, Củ ,Quả, Hoa)
-- + Ngày thu hoạch

-- Thông tin giao hàng :  Tên nhân viên, Mã hoá đơn,Tên KH, địa chỉ KH, SĐT KH, danh sách hàng hoá, hình thức vận chuyển
-- Hình thức vận chuyển( xem máy, xe oto, dịch vụ grap…)
create table product_type(
product_type_id int auto_increment primary key,
product_type_name varchar(20)
);
create table product(
product_id int primary key auto_increment,
product_code varchar(10),
product_name varchar(50),
unit varchar(20),
price int ,
product_type_id int,
harvest_date date,
foreign key(product_type_id)references product_type(product_type_id)
);
create table transport_type(
transport_type_id int auto_increment primary key,
transoprt_type_name varchar(20)
);

create table employee(
employee_id int auto_increment primary key,
employee_name varchar(50)
);
create table customer(
customer_id int auto_increment primary key,
customer_name varchar(50)
);

create table bill(
bill_id int auto_increment primary key,
customer_id int,
employee_id int,
product_id int,
quantity int,
foreign key(customer_id)references customer(customer_id),
foreign key(employee_id)references employee(employee_id),
foreign key(product_id)references product(product_id)
);
create table type_transfortation(
transport_type_id int auto_increment primary key,
transport_type_name varchar(20)
);
insert into product_type(product_type_name) value('Rau');
insert into product_type(product_type_name) value('Củ');
insert into product_type(product_type_name) value('Quả');
insert into product_type(product_type_name) value('Hoa');
insert into product(product_code, product_name, unit, price, product_type_id,harvest_date ) value('MHH-0001','Cà rốt', 'kg', 50000, 2,'2023-11-01');
insert into product(product_code, product_name, unit, price, product_type_id,harvest_date ) value('MHH-0002','Xà lách', 'bó', 40000, 1,'2023-11-02');
insert into product(product_code,product_name, unit, price, product_type_id,harvest_date ) value('MHH-0003','Táo', 'kg', 70000, 3,'2023-11-03');
insert into product(product_code,product_name, unit, price, product_type_id,harvest_date ) value('MHH-0004','Hoa cúc', 'bó', 30000, 4,'2023-11-04');

select product.product_code, product.product_name, product.unit, product.price, product_type.product_type_name, product.harvest_date 
from product
join product_type on product.product_type_id = product_type.product_type_id;

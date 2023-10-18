-- Bước 1:
create database if not exists demo;
use demo;
 -- Bước 2:
create table products (
id int primary key auto_increment,
product_code varchar(20) unique not null,
product_name varchar(50) not null,
product_price int not null,
product_amount int not null,
product_description varchar(200) not null,
product_status bit(1)
);
insert into products (product_code,product_name,product_price,product_amount,product_description,product_status) 
value('B001','Banh chocopipe',20,3,'xuat xu VN',1),
	('B002','Banh dau xanh',25,10,'xuat xu VN',1),
    ('B003','Banh snack',15,5,'xuat xu VN',1),
    ('K001','Keo mut',1,100,'xuat xu TQ',1),
    ('K002','Keo bon mua',1,100,'xuat xu TL',1),
    ('k003','Keo bon mua',2,30,'xuat xu VN',1);

-- Bước 3:
Alter table products add unique index i_product_code (product_code);
Alter table products add index i_name_price (product_name, product_price);
explain select * from products where product_code ='B003';
explain select * from products where product_name ='Keo bon mua' and product_price =2;
drop index i_product_code on products;
drop index i_name_price on products;

-- Bước 4:
-- Tạo view

create view w_product as
select products.product_code, products.product_name, products.product_price, products.product_status from products;

-- Sửa view

update w_product set product_price = 17 where product_code ='B001';
select * from w_product;

-- Xoá view

drop view w_product;

-- Bước 5:
-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product

delimiter //
create procedure get_all_product()
begin
select * from products;
end //
delimiter ;
call get_all_product;

-- Tạo store procedure thêm một sản phẩm mới
delimiter //
create procedure insert_product(product_code varchar(20),product_name varchar(50),product_price int,product_amount int,product_description varchar(50),product_status bit(1))
begin
insert into products(product_code,product_name,product_price,product_amount,product_description,product_status)value(product_code,product_name,product_price,product_amount,product_description,product_status);
end //
delimiter ;
call insert_product('K005','Keo bon mua lon',2,100,'xuat xu TL',1);

-- Tạo store procedure sửa thông tin sản phẩm theo id

delimiter //
create procedure update_product(id_editing int,new_product_name varchar(50),new_product_price int,new_product_amount int,new_product_description varchar(50),new_product_status bit(1))
begin
update products set product_name=new_product_name, product_price=new_product_price,product_amount=new_product_amount,product_description=new_product_description where id = id_editing;
end //
delimiter ;
call update_product(1,'Banh chocopipe vng',28,5,'xuat xu TQ',1);
call get_all_product;

-- Tạo store procedure xoá sản phẩm theo id

delimiter //
create procedure delete_product(id_deleting int)
begin
delete from products where id = id_deleting ;
end //
delimiter ;
call delete_product(1);
call get_all_product;




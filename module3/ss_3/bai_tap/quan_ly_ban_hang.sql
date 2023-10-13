create database if not exists sales_management;
use sales_management;
CREATE TABLE customer (
    customer_id INT PRIMARY KEY,
    customer_name VARCHAR(25),
    customer_age tinyint
);
CREATE TABLE `order` (
    order_id INT PRIMARY KEY,
    customer_id INT,
    order_date DATE,
    order_total_price INT,
    FOREIGN KEY (customer_id)
        REFERENCES customer (customer_id)
);
CREATE TABLE product (
    product_id INT PRIMARY KEY,
    product_name VARCHAR(25),
    product_price INT
);
CREATE TABLE order_detail (
    order_id INT,
    product_id INT,
    order_quantity INT,
    PRIMARY KEY (order_id , product_id),
    FOREIGN KEY (order_id)
        REFERENCES `order` (order_id),
    FOREIGN KEY (product_id)
        REFERENCES product (product_id)
);
/* Thêm dữ liệu vào trong 4 bảng */
insert into customer value(1,'Minh Quan',10),(2,'Ngoc Oanh',20),(3,'Hong Ha',50);
insert into `order` (order_id, customer_id, order_date)VALUES (1, 1, '2006/3/21'),(2, 2, '2006/3/23'),(3, 1, '2006/3/16');
insert into product value (1,'May Giat',3),(2,'Tu Lanh',5),(3,'Dieu Hoa',7),(4,'Quat',1),(5,'Bep Dien',2);
insert into order_detail value(1,1,3),(1,3,7),(1,4,2),(2,1,1),(3,1,8),(1,5,4),(2,3,3);

/* Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order */
SELECT 
    order_id, order_date, order_total_price
FROM
    `order`;
/*Hiển thị danh sách các khách hàng đã mua hàng */
select distinct customer.* 
from customer 
join `order` on customer.customer_id = `order`.customer_id;

/* và danh sách sản phẩm được mua bởi các khách */
select distinct product.* 
from product
join order_detail on product.product_id = order_detail.product_id;

/*Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào*/
select customer_name from customer
customer 
where customer_id not in(select customer_id from `order`);

/*Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. 
Giá bán của từng loại được tính = odQTY*pPrice)
*/

select order_detail.order_id, `order`.order_date, order_detail.order_quantity*product.product_price as amount
from order_detail
join product on order_detail.product_id = product.product_id
join `order` on `order`.order_id = order_detail.order_id;
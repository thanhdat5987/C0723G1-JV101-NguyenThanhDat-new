create database if not exists sales_management;
use sales_management;
CREATE TABLE customer (
    customer_id INT PRIMARY KEY,
    customer_name VARCHAR(50),
    customer_age INT
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
    product_name VARCHAR(50),
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
)


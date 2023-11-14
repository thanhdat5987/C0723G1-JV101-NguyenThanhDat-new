package com.example.demo.model;

//create table product_type(
//        product_type_id int auto_increment primary key,
//        product_type_name varchar(20)
//        );
public class ProductType {
    private int ProductTypeId;
    private String ProductName;

    public int getProductTypeId() {
        return ProductTypeId;
    }

    public void setProductTypeId(int productTypeId) {
        ProductTypeId = productTypeId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public ProductType(int productTypeId, String productName) {
        ProductTypeId = productTypeId;
        ProductName = productName;
    }
}

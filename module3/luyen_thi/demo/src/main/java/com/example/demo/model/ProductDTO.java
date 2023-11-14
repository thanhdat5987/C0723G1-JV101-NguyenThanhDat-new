package com.example.demo.model;

//create table product(
//        product_id int primary key auto_increment,
//        product_code varchar(10),
//        product_name varchar(50),
//        unit varchar(20),
//        price int ,
//        product_type_id int,
//        harvest_date date,
//        foreign key(product_type_id)references product_type(product_type_id)
//        );
public class ProductDTO {
private String productCode;
private String productName;
private String unit;
private int price;
private String productTypeName;
private String harvestDate;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    public String getHarvestDate() {
        return harvestDate;
    }

    public void setHarvestDate(String harvestDate) {
        this.harvestDate = harvestDate;
    }

    public ProductDTO(String productCode, String productName, String unit, int price, String productTypeName, String harvestDate) {
        this.productCode = productCode;
        this.productName = productName;
        this.unit = unit;
        this.price = price;
        this.productTypeName = productTypeName;
        this.harvestDate = harvestDate;
    }
}

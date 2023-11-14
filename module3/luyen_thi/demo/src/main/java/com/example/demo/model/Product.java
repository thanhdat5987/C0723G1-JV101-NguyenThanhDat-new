package com.example.demo.model;


public class Product {
private int productId;
private String productCode;
private String productName;
private String unit;
private int price;
private int productTypeId;
private String harvestDate;

    public Product(int productId, String productCode, String productName, String unit, int price, int productTypeId, String harvestDate) {
        this.productId = productId;
        this.productCode = productCode;
        this.productName = productName;
        this.unit = unit;
        this.price = price;
        this.productTypeId = productTypeId;
        this.harvestDate = harvestDate;
    }

    public Product(String productCode, String productName, String unit, int price, int productTypeId, String harvestDate) {
        this.productCode = productCode;
        this.productName = productName;
        this.unit = unit;
        this.price = price;
        this.productTypeId = productTypeId;
        this.harvestDate = harvestDate;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

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

    public int getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(int productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getHarvestDate() {
        return harvestDate;
    }

    public void setHarvestDate(String harvestDate) {
        this.harvestDate = harvestDate;
    }
}

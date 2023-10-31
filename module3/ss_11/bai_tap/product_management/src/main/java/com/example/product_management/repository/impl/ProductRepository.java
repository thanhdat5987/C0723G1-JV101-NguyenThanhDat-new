package com.example.product_management.repository.impl;

import com.example.product_management.model.Product;
import com.example.product_management.repository.IProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "Bánh", 10000, "SX Việt Nam"));
        productList.add(new Product(2, "Kẹo", 20000, "SX Trung Quốc"));
        productList.add(new Product(3, "Gạo", 200000, "SX Việt Nam"));
        productList.add(new Product(4, "Mỳ gói", 50000, "SX Việt Nam"));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }
}

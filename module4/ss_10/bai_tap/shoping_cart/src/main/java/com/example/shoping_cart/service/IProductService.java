package com.example.shoping_cart.service;

import com.example.shoping_cart.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(int id);


}

package com.example.demo.repository;

import com.example.demo.model.Product;
import com.example.demo.model.ProductDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface IProductRepository {
    List<ProductDTO> selectAllProduct() throws SQLException;
    Product selectProduct(int id);
    void insertProduct(Product product);
    boolean deleteProduct(int id);
}

package com.example.demo.service.impl;

import com.example.demo.model.Product;
import com.example.demo.model.ProductDTO;
import com.example.demo.repository.IProductRepository;
import com.example.demo.repository.impl.ProductRepository;
import com.example.demo.service.IProductService;

import java.sql.SQLException;
import java.util.List;

public class ProductService implements IProductService {
    private static IProductRepository productRepository = new ProductRepository();

    @Override
    public List<ProductDTO> selectAllProduct() throws SQLException {
        return productRepository.selectAllProduct();
    }

    @Override
    public Product selectProduct(int id) {
        return productRepository.selectProduct(id);
    }

    @Override
    public void insertProduct(Product product) {
        productRepository.insertProduct(product);
    }

    @Override
    public boolean deleteProduct(int id) {
        return productRepository.deleteProduct(id);
    }
}

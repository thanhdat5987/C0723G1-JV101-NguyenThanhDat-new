package com.example.shoping_cart.repository;

import com.example.shoping_cart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product,Integer> {
}

package com.example.product_management.repository;

import com.example.product_management.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {
    private static final Map<Integer, Product> productList = new HashMap<>();

    static {
        productList.put(1, new Product(1, "Bánh gạo", 25000, "xuất xứ Việt Nam"));
        productList.put(2, new Product(2, "Kẹo mút", 1000, "xuất xứ Trung Quốc"));
        productList.put(3, new Product(3, "Cocacola", 10000, "không đường"));
        productList.put(4, new Product(4, "Pepsi", 10000, "có đường"));
        productList.put(5, new Product(5, "Sting", 125000, "dâu"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productList.values());
    }

    @Override
    public void save(Product product) {
        productList.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return productList.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productList.put(id, product);
    }

    @Override
    public void remove(int id) {
        productList.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> findingProductList = new ArrayList<>();
        List<Product> productList = findAll();
        for (Product product : productList) {
            if ((product.getName().toLowerCase()).contains(name.toLowerCase().trim())) {
                findingProductList.add(product);
            }
        }
        return findingProductList;
    }
}

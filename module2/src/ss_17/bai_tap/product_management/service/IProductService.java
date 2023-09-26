package ss_17.bai_tap.product_management.service;

import ss_17.bai_tap.product_management.model.Product;

import java.util.List;

public interface IProductService {
    void addProduct(Product product);
    List<Product> displayProducts();
    Product getProduct(int productIndex);
}

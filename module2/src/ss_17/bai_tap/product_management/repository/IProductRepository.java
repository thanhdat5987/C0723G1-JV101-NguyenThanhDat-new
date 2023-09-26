package ss_17.bai_tap.product_management.repository;

import ss_17.bai_tap.product_management.model.Product;

import java.util.List;

public interface IProductRepository {
    void addProduct(Product product);
    List<Product> displayProducts();
    Product getProduct(int productIndex);
}

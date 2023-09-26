package ss_17.bai_tap.product_management.controller;

import ss_17.bai_tap.product_management.model.Product;
import ss_17.bai_tap.product_management.service.IProductService;
import ss_17.bai_tap.product_management.service.impl.ProductServiceImpl;

import java.util.List;

public class ProductController {
    private IProductService productService = new ProductServiceImpl();
    public void addProduct(Product product) {
        productService.addProduct(product);
    }


    public List<Product> displayProducts() {
        return productService.displayProducts();
    }


    public Product getProduct(int productIndex) {
        return productService.getProduct(productIndex);
    }
}

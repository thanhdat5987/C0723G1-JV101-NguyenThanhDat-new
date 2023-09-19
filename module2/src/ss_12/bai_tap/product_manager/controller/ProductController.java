package ss_12.bai_tap.product_manager.controller;

import ss_12.bai_tap.product_manager.service.IProductService;
import ss_12.bai_tap.product_manager.service.impl.ProductServiceImpl;

import java.util.ArrayList;

public class ProductController<E> {
    private final IProductService<E> productService = new ProductServiceImpl<>();

    public void addProduct(E product) {
        productService.addProduct(product);
    }

    public void editProduct(int productIndex, E product) {
        productService.editProduct(productIndex, product);
    }

    public void deleteProduct(int productIndex) {
        productService.deleteProduct(productIndex);
    }

    public ArrayList<E> displayProducts() {
        return productService.displayProducts();
    }

    public E getProduct(int productIndex) {
        return productService.getProduct(productIndex);
    }

    public ArrayList<E> sortProducts() {
        return productService.sortProducts();
    }

}

package ss_12.bai_tap.product_manager.service.impl;

import ss_12.bai_tap.product_manager.repository.IProductRepository;
import ss_12.bai_tap.product_manager.repository.impl.ProductRepositoryImpl;
import ss_12.bai_tap.product_manager.service.IProductService;

import java.util.ArrayList;

public class ProductServiceImpl<E> implements IProductService<E> {
    private final IProductRepository<E> productRepository = new  ProductRepositoryImpl<>();
    @Override
    public void addProduct(E product) {
        productRepository.addProduct(product);
    }

    @Override
    public void editProduct(int productIndex, E product) {
        productRepository.editProduct(productIndex, product);
    }

    @Override
    public void deleteProduct(int productIndex) {
productRepository.deleteProduct(productIndex);
    }

    @Override
    public ArrayList<E> displayProducts() {
        return productRepository.displayProducts();
    }

    @Override
    public E getProduct(int productIndex) {
        return productRepository.getProduct(productIndex);
    }

    @Override
    public ArrayList<E> sortProducts() {
        return productRepository.sortProducts();
    }
}

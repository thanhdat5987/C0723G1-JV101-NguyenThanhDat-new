package ss_12.bai_tap.product_manager.repository.impl;

import ss_12.bai_tap.product_manager.repository.IProductRepository;

import java.util.ArrayList;

public class ProductRepositoryImpl<E> implements IProductRepository<E> {
    private final ArrayList<E> productList = new ArrayList<>();

    @Override
    public void addProduct(E product) {
        productList.add(product);
    }

    @Override
    public void editProduct(int productIndex, E product) {
        productList.add(productIndex, product);
    }

    @Override
    public void deleteProduct(int productIndex) {
        productList.remove(productIndex);
    }

    @Override
    public ArrayList<E> displayProducts() {
        return productList;
    }

    @Override
    public E getProduct(int productIndex) {
        return productList.get(productIndex);
    }

    @Override
    public ArrayList<E> sortProducts() {
        return productList;
    }
}

package ss_12.bai_tap.product_manager.service;

import java.util.ArrayList;

public interface IProductService <E>{
    void addProduct(E product);
    void editProduct(int productIndex, E product);
    void deleteProduct(int productIndex);
    ArrayList<E> displayProducts();
    E getProduct(int productIndex);
    ArrayList<E> sortProducts();
}

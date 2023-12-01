package com.example.shoping_cart.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Cart {
    private Map<Product, Integer> products = new HashMap<>();

    public Cart() {
    }

    public Cart(Map<Product, Integer> products) {
        this.products = products;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

//    private boolean checkItemInCart(Product product) {
//        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
//            if (entry.getKey().getId() == product.getId()) {
//                return true;
//            }
//        }
//        return false;
//    }

    private Map.Entry<Product, Integer> selectItemInCart(Product product) {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getKey().getId() == product.getId()) {
                return entry;
            }
        }
        return null;
    }

    public void addProduct(Product product) {
        if (products.containsKey(product)) {
            Integer newQuantity = products.get(product);
            products.replace(product, newQuantity + 1);
        } else {
            products.put(product,1);
        }
    }

    public void removeProduct(Product product) {
        Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
        if (itemEntry.getValue() > 0) {
            Integer newQuantity = itemEntry.getValue() - 1;
            products.replace(itemEntry.getKey(), newQuantity);
        } else {
            products.remove(product);
        }


    }

    public Integer countProductQuantity() {
        Integer productQuantity = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }

    public Integer countItemQuantity() {
        return products.size();
    }

    public Integer countTotalPayment() {
        int payment = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            payment += entry.getKey().getPrice() * entry.getValue();
        }
        return payment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return Objects.equals(products, cart.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(products);
    }
}

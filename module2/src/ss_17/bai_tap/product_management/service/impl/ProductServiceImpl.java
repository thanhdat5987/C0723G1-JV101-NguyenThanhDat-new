package ss_17.bai_tap.product_management.service.impl;

import ss_17.bai_tap.product_management.model.Product;
import ss_17.bai_tap.product_management.repository.IProductRepository;
import ss_17.bai_tap.product_management.repository.impl.ProductRepositoryImpl;
import ss_17.bai_tap.product_management.service.IProductService;

import java.util.List;

public class ProductServiceImpl implements IProductService {
    private final IProductRepository productRepository = new ProductRepositoryImpl();
    @Override
    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }

    @Override
    public List<Product> displayProducts() {
        return productRepository.displayProducts();
    }

    @Override
    public Product getProduct(int productIndex) {
        return productRepository.getProduct(productIndex);
    }
}

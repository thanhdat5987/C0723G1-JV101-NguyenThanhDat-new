package ss_17.bai_tap.product_management.repository.impl;

import ss_17.bai_tap.product_management.model.Product;
import ss_17.bai_tap.product_management.repository.IProductRepository;
import ss_17.bai_tap.product_management.util.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl extends FileUtil implements IProductRepository{
    private List<Product> products = new ArrayList<>();
    final String PRODUCT_LIST_PATH = "/Users/thaodao/Thanh Dat/GitHub/Codegym/C0723G1-JV101-NguyenThanhDat-new/module2/src/ss_17/bai_tap/product_management/model/productList.txt";
    @Override
    public void addProduct(Product product) {
        products.add(product);
        FileUtil.readDataFromFile(PRODUCT_LIST_PATH);
        writeDataToFile(PRODUCT_LIST_PATH,products);
    }

    @Override
    public List<Product> displayProducts() {
        return FileUtil.readDataFromFile(PRODUCT_LIST_PATH);
    }

    @Override
    public Product getProduct(int productIndex) {
        return products.get(productIndex);
    }
}

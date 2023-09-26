package ss_17.bai_tap.product_management.repository.impl;

import ss_17.bai_tap.product_management.model.Product;
import ss_17.bai_tap.product_management.repository.IProductRepository;
import ss_17.bai_tap.product_management.util.FileUtil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class ProductRepositoryImpl extends FileUtil implements IProductRepository {
    final String PRODUCT_LIST_PATH = "/Users/thaodao/Thanh Dat/GitHub/Codegym/C0723G1-JV101-NguyenThanhDat-new/module2/src/ss_17/bai_tap/product_management/model/product_list.txt";

    @Override
    public void addProduct(Product product) {
        List<Product> dataProductFromFile = readDataFromFile(PRODUCT_LIST_PATH);
        dataProductFromFile.add(product);
        writeDataToFile(PRODUCT_LIST_PATH, dataProductFromFile);
    }

    @Override
    public List<Product> displayProducts() {
        return readDataFromFile(PRODUCT_LIST_PATH);
    }

    @Override
    public Product getProduct(int productIndex) {
        return readDataFromFile(PRODUCT_LIST_PATH).get(productIndex);
    }
}

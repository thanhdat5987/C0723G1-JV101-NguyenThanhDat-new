package com.example.demo.repository.impl;

import com.example.demo.model.Product;
import com.example.demo.model.ProductDTO;
import com.example.demo.repository.BaseRepository;
import com.example.demo.repository.IProductRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static final String SELECT_ALL_PRODUCT ="select product.product_code, product.product_name, product.unit, product.price, product_type.product_type_name, product.harvest_date \n" +
            "from product\n" +
            "join product_type on product.product_type_id = product_type.product_type_id";
    @Override
    public List<ProductDTO> selectAllProduct() throws SQLException {
        List<ProductDTO> productDTOList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            String productCode = resultSet.getString("product_code");
            String productName = resultSet.getString("product_name");
            String unit = resultSet.getString("unit");
            int price = resultSet.getInt("price");
            String productTypeName = resultSet.getString("product_type_name");
            String harvestDate = resultSet.getString("harvest_date");
            productDTOList.add(new ProductDTO(productCode,productName,unit,price,productTypeName,harvestDate));
        }
        return productDTOList;
    }

    @Override
    public Product selectProduct(int id) {
        Connection connection = BaseRepository.getConnectDB();

        return null;
    }

    @Override
    public void insertProduct(Product product) {

    }

    @Override
    public boolean deleteProduct(int id) {
        return false;
    }
}

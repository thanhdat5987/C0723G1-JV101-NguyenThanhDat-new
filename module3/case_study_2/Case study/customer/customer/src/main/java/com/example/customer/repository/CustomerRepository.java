package com.example.customer.repository;

import com.example.customer.model.Customer;

import java.sql.*;
import java.util.List;

public class CustomerRepository implements ICustomerRepository{
    private static final String SELECT ="select * from customer where id_customer=1";
    private static final String SELECT_CUSTOMER ="select * from customer where id_customer=?";
    private static final String UPDATE_CUSTOMER ="update customer\n" +
            "set name_customer=?,birthday=?,phone_number=?,email=?,address=?,gender=?\n" +
            "where id_customer=?;";
    @Override
    public Customer display() {
        Connection connection = BaseRepository.getConnection();
        Customer customer=null;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet =statement.executeQuery(SELECT);
            while (resultSet.next()){
                int id = resultSet.getInt("id_customer");
                String name = resultSet.getString("name_customer");
                Date birthday = resultSet.getDate("birthday");
                String telephone = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                int gender = resultSet.getInt("gender");
                customer = new Customer(id,name,birthday,telephone,email,address,gender);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customer;
    }

    @Override
    public Customer findById(int idCheck) {
        Connection connection = BaseRepository.getConnection();
        Customer customer=null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER);
            preparedStatement.setInt(1,idCheck);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id_customer");
                String name = resultSet.getString("name_customer");
                Date birthday = resultSet.getDate("birthday");
                String telephone = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                int gender = resultSet.getInt("gender");
                customer = new Customer(id,name,birthday,telephone,email,address,gender);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customer;
    }

    @Override
    public void updateCustomer(Customer customer) {
        Connection connection =BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER);
            preparedStatement.setString(1,customer.getName());
            preparedStatement.setDate(2,customer.getBirthday());
            preparedStatement.setString(3,customer.getTelephone());
            preparedStatement.setString(4,customer.getEmail());
            preparedStatement.setString(5,customer.getAddress());
            preparedStatement.setInt(6,customer.getGender());
            preparedStatement.setInt(7,customer.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeCustomer(int id) {

    }
}

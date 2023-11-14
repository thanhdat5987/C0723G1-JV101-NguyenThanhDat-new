package com.example.casestudy.repository.impl;


import com.example.casestudy.model.Account;
import com.example.casestudy.model.Customer;
import com.example.casestudy.repository.BaseRepository;
import com.example.casestudy.repository.ICustomerAdminRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CustomerAdminRepository implements ICustomerAdminRepository {
    private static final String SELECT = "select*from customer c join accounts a on c.id_account=a.id_account where delete_customer=0 and rolesdelete_account=0;  ";
    private static final String SELECT_CUSTOMER = "select * from customer where id_customer=?";
    private static final String UPDATE_CUSTOMER = "update customer\n" +
            "set name_customer=?,birthday=?,phone_number=?,email=?,address=?,gender=?\n" +
            "where id_customer=?;";
    private static final String INSERT_ACCOUNT = "insert into accounts (username,`password`) values(?,?);";
    private static final String SELECT_ACCOUNT = "select*from accounts where username=?; ";
    private static final String INSERT_CUSTOMER = "INSERT INTO customer (name_customer,birthday, phone_number, email, address, gender, id_account) \n" +
            "VALUES (?,?,?,?,?,?,?); ";
    private static final String REMOVE_CUSTOMER = "update customer\n" +
            "set delete_customer=1\n" +
            "where id_customer=?;";


    @Override
    public List<Customer> display() {
        Connection connection = BaseRepository.getConnectDB();
        List<Customer> customerList = new ArrayList<>();
        Customer customer ;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_customer");
                String name = resultSet.getString("name_customer");
                Date birthday = resultSet.getDate("birthday");
                String telephone = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                int gender = resultSet.getInt("gender");
                int idAccount = resultSet.getInt("id_account");
                Account account = new Account(idAccount);
                customer = new Customer(id, name, birthday, telephone, email, address, gender, account);
                customerList.add(customer);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customerList;
    }

    @Override
    public void saveAccount(Account account) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ACCOUNT);
            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2, account.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean saveCustomer(Customer customer) {
        Connection connection = BaseRepository.getConnectDB();
        int count;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER);
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setDate(2, customer.getBirthday());
            preparedStatement.setString(3, customer.getTelephone());
            preparedStatement.setString(4, customer.getEmail());
            preparedStatement.setString(5, customer.getAddress());
            preparedStatement.setInt(6, customer.getGender());
            preparedStatement.setInt(7, customer.getAccount().getAccountId());
            count = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return (count==1);
    }

    @Override
    public int searchIdAccount(String username) {
        Connection connection = BaseRepository.getConnectDB();
        int idAccount = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ACCOUNT);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                idAccount = resultSet.getInt("id_account");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return idAccount;
    }

    @Override
    public Customer findById(int updateId) {
        Connection connection = BaseRepository.getConnectDB();
        Customer customer = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER);
            preparedStatement.setInt(1, updateId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_customer");
                String name = resultSet.getString("name_customer");
                Date birthday = resultSet.getDate("birthday");
                String telephone = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                int gender = resultSet.getInt("gender");
                customer = new Customer(id, name, birthday, telephone, email, address, gender);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customer;

    }

    @Override
    public boolean updateCustomer(Customer customer) {
        Connection connection = BaseRepository.getConnectDB();
        int count;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER);
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setDate(2, customer.getBirthday());
            preparedStatement.setString(3, customer.getTelephone());
            preparedStatement.setString(4, customer.getEmail());
            preparedStatement.setString(5, customer.getAddress());
            preparedStatement.setInt(6, customer.getGender());
            preparedStatement.setInt(7, customer.getId());
            count = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return (count == 1);
    }

    @Override
    public boolean delete(int deleteId) {
        Connection connection = BaseRepository.getConnectDB();
        int count;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(REMOVE_CUSTOMER);
            preparedStatement.setInt(1, deleteId);
            count = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return (count==1);
    }
}

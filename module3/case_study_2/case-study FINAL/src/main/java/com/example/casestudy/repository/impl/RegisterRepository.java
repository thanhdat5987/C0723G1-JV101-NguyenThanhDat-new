package com.example.casestudy.repository.impl;

import com.example.casestudy.model.Account;
import com.example.casestudy.model.Customer;
import com.example.casestudy.repository.BaseRepository;
import com.example.casestudy.repository.IRegisterRepository;

import java.sql.*;

public class RegisterRepository implements IRegisterRepository {


    private static final String CHECK_USERNAME = "SELECT * FROM accounts where username =  ";
    private final String ADD_NEW_ACCOUNT = "call add_new_account(?,?)";
    private final String ADD_NEW_CUSTOMER = "call add_new_customer(?,?,?,?,?,?,?);";
    private final String GET_ID_ACCOUNT = "call get_id_account(?)";

    public boolean checkUsername(String username) {
        Connection connection = BaseRepository.getConnectDB();
        String sql = CHECK_USERNAME + "'" + username + "'";
        try {
            CallableStatement callableStatement = connection.prepareCall(sql);
            ResultSet resultSet = callableStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int getIdAccount(String username) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(GET_ID_ACCOUNT);
            callableStatement.setString(1, username);
            ResultSet resultSet = callableStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    public void addNewAccount(Account account) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(ADD_NEW_ACCOUNT);
            callableStatement.setString(1, account.getUsername());
            callableStatement.setString(2, account.getPassword());
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addNewCustomer(Customer customer) {

    }


    @Override
    public void addCustomer(String name, Date birthday, String phone, String email, String address, int gender, int idAccount) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(ADD_NEW_CUSTOMER);
            callableStatement.setString(1, name);
            callableStatement.setDate(2, birthday);
            callableStatement.setString(3, phone);
            callableStatement.setString(4, email);
            callableStatement.setString(5, address);
            callableStatement.setInt(6, gender);
            callableStatement.setInt(7, idAccount);
            callableStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }
}
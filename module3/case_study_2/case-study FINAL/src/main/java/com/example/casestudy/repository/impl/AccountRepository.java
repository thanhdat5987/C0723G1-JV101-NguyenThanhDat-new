package com.example.casestudy.repository.impl;

import com.example.casestudy.dto.AccountDto;
import com.example.casestudy.model.Account;
import com.example.casestudy.model.Role;
import com.example.casestudy.repository.BaseRepository;
import com.example.casestudy.repository.IAccountRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository implements IAccountRepository {
    private static final String SELECT_ALL_ACCOUNTS = "select a.id_account, a.username, a.password, r.id_role, r.roles from accounts a join roles r on a.id_role = r.id_role where rolesdelete_account = 0 ;";
    private static final String INSERT_ACCOUNT = "insert into accounts(username,`password`,id_role) values (?,?,?);";
    private static final String SELECT_ROLE = "SELECT * FROM roles;";
    private static final String SELECT_ID_ACCOUNT = "SELECT id_account FROM accounts where username = ?;";
    private static final String SELECT_BY_ID = "select a.id_account, a.username, a.password, r.id_role, r.roles from accounts a join roles r on a.id_role = r.id_role where rolesdelete_account = 0 and a.id_account  = ?;";
    private static final String UPDATE_ACCOUNT = "update accounts set id_role = ? where id_account = ?;";
    private static final String CHECK_ACCOUNT = "select * from accounts where username =? and password =?";
    private static final String DELETE_ACCOUNT = "update accounts set rolesdelete_account = 1 where id_account =? ;";
    private static final String DELETE_ACCOUNT_BY_USERNAME = "update accounts set rolesdelete_account = 1 where username =? and id_role != 2 ;";

    @Override
    public Account check(String username, String password) {
        Account account = null;
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CHECK_ACCOUNT);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int idAccount = resultSet.getInt("id_account");
                int idRole = resultSet.getInt("id_role");
                account = new Account(idAccount,username, password, idRole);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return account;
    }

    @Override
    public void insertAccount(Account account) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ACCOUNT);
            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2, account.getPassword());
            preparedStatement.setInt(3, account.getRoleId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public Account selectAccount(int id) {
        Account account = null;
        Connection connection = BaseRepository.getConnectDB();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                int idRole = resultSet.getInt("id_role");
                account = new Account(id, username, password, idRole);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if(connection!=null){
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return account;
    }

    @Override
    public List<AccountDto> selectAllAccount() {
        List<AccountDto> accountList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ACCOUNTS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_account");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                int idRole = resultSet.getInt("id_role");
                String roles = resultSet.getString("roles");
                AccountDto accountDto = new AccountDto(id, username, password, idRole, roles);
                accountList.add(accountDto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return accountList;
    }

    @Override
    public boolean deleteAccount(int id) {
        boolean rowDeleted;
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ACCOUNT);
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowDeleted;
    }

    @Override
    public boolean updateAccount(Account account) {
        boolean rowUpdated;
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ACCOUNT);
            preparedStatement.setInt(1, account.getRoleId());
            preparedStatement.setInt(2, account.getAccountId());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if(connection!=null){
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return rowUpdated;


    }

    public List<Role> selectRole() {
        List<Role> roleList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ROLE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idRole = resultSet.getInt("id_role");
                String roles = resultSet.getString("roles");
                Role role = new Role(idRole, roles);
                roleList.add(role);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return roleList;
    }

    @Override
    public int selectIdAccount(String username) {
        int id = 0;
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ID_ACCOUNT);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt("id_account");

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return id;
    }
    @Override
    public boolean deleteAccountByUsername(String username) {
        boolean rowDeleted;
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ACCOUNT_BY_USERNAME);
            preparedStatement.setString(1, username);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowDeleted;
    }
}
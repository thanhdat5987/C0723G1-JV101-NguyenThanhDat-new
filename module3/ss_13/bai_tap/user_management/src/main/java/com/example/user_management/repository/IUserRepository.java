package com.example.user_management.repository;

import com.example.user_management.model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserRepository {
    public void insertUser(User user) throws SQLException;

    public User selectUser(int id);

    public List<User> selectAllUsers();

    public boolean deleteUser(int id) throws SQLException;

    public boolean updateUser(User user) throws SQLException;
    List<User> findByCountry(String country);
    public List<User> sortUsersByName();
    User getUserById(int id);

    void insertUserStore(User user) throws SQLException;
    void addUserTransaction(User user, List<Integer> permission);
    public void insertUpdateWithoutTransaction();

    public void insertUpdateUseTransaction();
    public List<User> selectAllUserStore();
    public boolean deleteUserStore(int id) throws SQLException;

    public boolean updateUserStore(User user) throws SQLException;
}

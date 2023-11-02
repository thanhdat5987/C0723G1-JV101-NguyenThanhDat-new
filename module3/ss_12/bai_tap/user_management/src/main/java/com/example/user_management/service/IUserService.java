package com.example.user_management.service;

import com.example.user_management.model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserService {
    public void insertUser(User user) throws SQLException;

    public User selectUser(int id);

    public List<User> selectAllUsers();

    public boolean deleteUser(int id) throws SQLException;

    public boolean updateUser(User user) throws SQLException;
    List<User> findByCountry(String country);
    public List<User> sortUsersByName();

    User getUserById(int id);

    void insertUserStore(User user) throws SQLException;
}

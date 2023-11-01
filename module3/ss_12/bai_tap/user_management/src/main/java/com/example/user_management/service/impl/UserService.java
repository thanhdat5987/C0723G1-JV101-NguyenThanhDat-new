package com.example.user_management.service.impl;

import com.example.user_management.model.User;
import com.example.user_management.repository.IUserRepository;
import com.example.user_management.repository.impl.UserRepository;
import com.example.user_management.service.IUserService;

import java.sql.SQLException;
import java.util.List;

public class UserService implements IUserService {
private final IUserRepository userRepository = new UserRepository();
    @Override
    public void insertUser(User user) throws SQLException {
        userRepository.insertUser(user);
    }

    @Override
    public User selectUser(int id) {
        return userRepository.selectUser(id);
    }

    @Override
    public List<User> selectAllUsers() {
        return userRepository.selectAllUsers();
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        return userRepository.deleteUser(id);
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        return userRepository.updateUser(user);
    }

    @Override
    public List<User> findByCountry(String country) {
        return userRepository.findByCountry(country);
    }

    @Override
    public List<User> sortUsersByName() {
        return userRepository.sortUsersByName();
    }
}

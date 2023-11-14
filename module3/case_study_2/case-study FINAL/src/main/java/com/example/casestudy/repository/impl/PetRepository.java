package com.example.casestudy.repository.impl;


import com.example.casestudy.model.Pet;
import com.example.casestudy.repository.BaseRepository;
import com.example.casestudy.repository.IPetRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PetRepository implements IPetRepository {
    private static final String INSERT_PET_SQL = "INSERT INTO pet (name_pet, weight, descriptions,id_type_pet,id_customer ) VALUES (?, ?,?,?,?)";
    private static final String SELECT_ALL_PET = "select * from pet where delete_pet=0";
    private static final String SELECT_PET_BY_ID = "select id_pet,name_pet,weight,descriptions,id_type_pet,id_customer from pet where id_pet =?;";
    private static final String DELETE_PET_SQL= "update pet set delete_pet = 1 where id_pet = ?;";
    private static final String UPDATE_PET_SQL = "update pet set name_pet = ?,weight= ?, descriptions =?,id_type_pet=?,id_customer=? where id_pet = ?;";
    private static final String SEARCH_BY_NAME = "select * from pet where name_pet like ?; ";
    @Override
    public void insertPet(Pet pet) throws SQLException {
        try (Connection connection = BaseRepository.getConnectDB()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PET_SQL);
            preparedStatement.setString(1, pet.getName());
            preparedStatement.setInt(2, pet.getWeight());
            preparedStatement.setString(3, pet.getDescriptions());
            preparedStatement.setInt(4,pet.getId_type_pet());
            preparedStatement.setInt(5,pet.getId_customer());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Pet selectPet(int id) throws SQLException {
        Pet pet = null;
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PET_BY_ID)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name_pet");
                int weight = Integer.parseInt(rs.getString("weight"));
                String descriptions  = rs.getString("descriptions");
                int id_type_pet= rs.getInt("id_type_pet");
                int id_customer= rs.getInt("id_customer");
                pet = new Pet(id, name, weight, descriptions,id_type_pet,id_customer);
            }
        }
        return pet;
    }

    @Override
    public List<Pet> selectAllPet() {
        List<Pet> petList = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PET);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id_pet");
                String name = resultSet.getString("name_pet");
                int weight = resultSet.getInt("weight");
                String descriptions  = resultSet.getString("descriptions");
                int id_type_pet= resultSet.getInt("id_type_pet");
                int id_customer= resultSet.getInt("id_customer");
                petList.add(new Pet(id, name,weight, descriptions,id_type_pet,id_customer));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return petList;
    }

    @Override
    public boolean deletePet(int id) throws SQLException {
        boolean rowDeleted;
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PET_SQL);
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowDeleted;
    }

    @Override
    public boolean updatePet(Pet pet) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = BaseRepository.getConnectDB(); PreparedStatement statement = connection.prepareStatement(UPDATE_PET_SQL)) {
            statement.setString(1, pet.getName());
            statement.setInt(2, pet.getWeight());
            statement.setString(3, pet.getDescriptions());
            statement.setInt(4, pet.getId_type_pet());
            statement.setInt(5, pet.getId_customer());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public List<Pet> searchByName(String name) {
        List<Pet> services = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_NAME);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_pet");
                name = resultSet.getString("name_pet");
                int weight = Integer.parseInt(resultSet.getString("weight"));
                String descriptions= resultSet.getString("descriptions");
                int id_type_pet= Integer.parseInt(resultSet.getString("id_type_pet"));
                int id_customer= Integer.parseInt(resultSet.getString("id_customer"));
                services.add(new Pet(id,name,weight,descriptions,id_type_pet,id_customer));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return services;
    }
}

package com.example.casestudy.repository.impl;

import com.example.casestudy.model.Service;
import com.example.casestudy.repository.BaseRepository;
import com.example.casestudy.repository.IServiceRepository;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepository implements IServiceRepository {
    private static final String INSERT_SERVICE_SQL = "INSERT INTO service (service_name, service_price, unit ) VALUES (?, ?,?)";
    private static final String SELECT_ALL_SERVICE = "select * from service where delete_service=0";
    private static final String UPDATE_USERS_SQL = "update service set service_name = ?,service_price= ?, unit =? where id_service = ?;";
    private static final String SELECT_SERVICE_BY_ID = "select id_service,service_name,service_price,unit from service where id_service =?;";
    private static final String DELETE_SERVICE_SQL= "update service set delete_service = 1 where id_service = ?;";
    private static final String SEARCH_BY_NAME = "select * from service where service_name like ?; ";
    public ServiceRepository() {
    }


    @Override
    public void insertService(Service service) throws SQLException {
        try (Connection connection = BaseRepository.getConnectDB()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SERVICE_SQL);
            preparedStatement.setString(1, service.getName());
            preparedStatement.setInt(2, service.getPrice());
            preparedStatement.setString(3, service.getUnit());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Service selectService(int id) {
        Service service = null;
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SERVICE_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("service_name");
                int price = Integer.parseInt(rs.getString("service_price"));
                String unit = rs.getString("unit");
                service = new Service(id, name, price, unit);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return service;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    @Override
    public List<Service> selectAllService() {
        List<Service> serviceList = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SERVICE);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id_service");
                String name = resultSet.getString("service_name");
                int price = resultSet.getInt("service_price");
                String unit = resultSet.getString("unit");
                serviceList.add(new Service(id, name, price, unit));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return serviceList;
    }

    @Override
    public boolean deleteService(int id) throws SQLException {
        boolean rowDeleted;
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SERVICE_SQL);
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowDeleted;
    }

    @Override
    public boolean updateService(Service service) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = BaseRepository.getConnectDB(); PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setString(1, service.getName());
            statement.setInt(2, service.getPrice());
            statement.setString(3, service.getUnit());
            statement.setInt(4, service.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public List<Service> searchByName(String name) {
        List<Service> services = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_NAME);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_service");
                name = resultSet.getString("service_name");
                int price = Integer.parseInt(resultSet.getString("service_price"));
                String unit= resultSet.getString("unit");
                services.add(new Service(id,name,price,unit));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return services;
    }


}
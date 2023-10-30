package com.example.customer.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepository {
    private static final String JDBC_URL="jdbc:mysql://localhost:3306/pet_store";
    private static final String USERNAME = "root";
    private static final String PASSWORK = "nam721998";

    public BaseRepository() {
    }
    public static Connection getConnection (){
        Connection connection=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL,USERNAME,PASSWORK);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}

package com.example.casestudy.repository.impl;

import com.example.casestudy.dto.EmployeeDTO;
import com.example.casestudy.model.Employee;
import com.example.casestudy.repository.BaseRepository;
import com.example.casestudy.repository.IEmployeeRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    private static final String INSERT_EMPLOYEE = "INSERT INTO employees (employee_name, birthday, phone_number,email, address, identification_card, salary,image, id_account) value (?,?,?,?,?,?,?,?,?);";
    private static final String SELECT_ALL_EMPLOYEE = "SELECT e.*, a.username FROM employees e join accounts a on e.id_account = a.id_account where delete_employee = 0 ";
    private static final String UPDATE_EMPLOYEE = "update employees set employee_name = ?,birthday= ?, phone_number =?,email =?, address =?, identification_card =?, salary =? where id_employee = ?;";
    private static final String DELETE_EMPLOYEE = "update employees set delete_employee = 1 where id_employee = ?";
    private static final String SELECT_EMPLOYEE_BY_ID = "SELECT e.*, a.username FROM employees e join accounts a on e.id_account = a.id_account where id_employee = ?;";
    private static final String SELECT_EMPLOYEE_BY_USERNAME= "SELECT e.*, a.username FROM employees e join accounts a on e.id_account = a.id_account where username = ?;";

    @Override
    public void insertEmployee(Employee employee) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setDate(2, employee.getBirthday());
            preparedStatement.setString(3, employee.getPhoneNumber());
            preparedStatement.setString(4, employee.getEmail());
            preparedStatement.setString(5, employee.getAddress());
            preparedStatement.setString(6, employee.getIdentificationCard());
            preparedStatement.setInt(7, employee.getSalary());
            preparedStatement.setString(8, employee.getImage());
            preparedStatement.setInt(9, employee.getIdAccount());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeDTO> list = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_employee");
                String name = resultSet.getString("employee_name");
                Date birthday = Date.valueOf(resultSet.getString("birthday"));
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String identificationCard = resultSet.getString("identification_card");
                int salary = resultSet.getInt("salary");
                String username = resultSet.getString("username");
                String image = resultSet.getString("image");
                list.add(new EmployeeDTO(id, name, birthday, phoneNumber, email, address, identificationCard, salary, username,image));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public Employee selectEmployee(int id) {
        Employee employee = null;
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("employee_name");
                Date birthday = resultSet.getDate("birthday");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String identificationCard = resultSet.getString("identification_card");
                int salary = resultSet.getInt("salary");
                String image = resultSet.getString("image");
                int idAccount = resultSet.getInt("id_account");
                employee = new Employee(name, birthday, phoneNumber, email, address, identificationCard, salary,image,idAccount);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return employee;
    }


    @Override
    public boolean deleteEmployee(int id) {
        boolean rowUpdated;
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE);
            preparedStatement.setInt(1, id);
            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowUpdated;
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        boolean rowUpdated;
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setDate(2, employee.getBirthday());
            preparedStatement.setString(3, employee.getPhoneNumber());
            preparedStatement.setString(4, employee.getEmail());
            preparedStatement.setString(5, employee.getAddress());
            preparedStatement.setString(6, employee.getIdentificationCard());
            preparedStatement.setInt(7, employee.getSalary());
            preparedStatement.setInt(8, employee.getId());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowUpdated;
    }

    @Override
    public Employee selectEmployeeByUsername(String username) {
        Employee employee = null;
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_USERNAME);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_employee");
                String name = resultSet.getString("employee_name");
                Date birthday = resultSet.getDate("birthday");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String identificationCard = resultSet.getString("identification_card");
                int salary = resultSet.getInt("salary");
                String image = resultSet.getString("image");
                employee = new Employee(id,name, birthday, phoneNumber, email, address, identificationCard, salary,image);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return employee;
    }


    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}

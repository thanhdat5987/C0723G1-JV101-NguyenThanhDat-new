package com.example.casestudy.repository;

import com.example.casestudy.dto.EmployeeDTO;
import com.example.casestudy.model.Employee;

import java.util.List;

public interface IEmployeeRepository {
    void insertEmployee(Employee employee);
    List<EmployeeDTO> getAllEmployees();
    Employee selectEmployee(int id);
    boolean deleteEmployee(int id);
    boolean updateEmployee(Employee employee);
    Employee selectEmployeeByUsername(String username);
}

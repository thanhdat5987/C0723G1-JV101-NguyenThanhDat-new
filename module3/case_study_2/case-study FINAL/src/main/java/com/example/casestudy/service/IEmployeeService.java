package com.example.casestudy.service;

import com.example.casestudy.dto.EmployeeDTO;
import com.example.casestudy.model.Employee;

import java.util.List;

public interface IEmployeeService {
    void insertEmployee(Employee employee);
    List<EmployeeDTO> getAllEmployees();
    Employee selectEmployee(int id);
    boolean deleteEmployee(int id);
    boolean updateEmployee(Employee employee);
//    Employee selectEmployeeByIdAcc( int idAcc);
    Employee selectEmployeeByUsername(String username);
}

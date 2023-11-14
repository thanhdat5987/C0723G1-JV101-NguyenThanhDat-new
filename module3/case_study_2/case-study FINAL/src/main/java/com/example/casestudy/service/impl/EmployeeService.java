package com.example.casestudy.service.impl;

import com.example.casestudy.dto.EmployeeDTO;
import com.example.casestudy.model.Employee;
import com.example.casestudy.repository.IEmployeeRepository;
import com.example.casestudy.repository.impl.EmployeeRepository;
import com.example.casestudy.service.IEmployeeService;

import java.util.List;

public class EmployeeService implements IEmployeeService {
    private final IEmployeeRepository employeeRepository = new EmployeeRepository();
    @Override
    public void insertEmployee(Employee employee) {
        employeeRepository.insertEmployee(employee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    @Override
    public Employee selectEmployee(int id) {
        return employeeRepository.selectEmployee(id);
    }

    @Override
    public boolean deleteEmployee(int id) {
        return employeeRepository.deleteEmployee(id);
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        return employeeRepository.updateEmployee(employee);
    }

//    @Override
//    public Employee selectEmployeeByIdAcc(int idAcc) {
//        return employeeRepository.s(idAcc);
//    }

    @Override
    public Employee selectEmployeeByUsername(String username) {
        return employeeRepository.selectEmployeeByUsername(username);
    }
}

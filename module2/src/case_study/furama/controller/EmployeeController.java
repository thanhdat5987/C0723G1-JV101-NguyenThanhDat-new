package case_study.furama.controller;

import case_study.furama.model.Employee;
import case_study.furama.service.IPersonService;
import case_study.furama.service.Impl.EmployeeServiceImpl;

import java.util.List;

public class EmployeeController {
    private final IPersonService<Employee> employeeService = new EmployeeServiceImpl();
    public void editPerson(int index) {
        employeeService.editPerson(index);
    }


    public void deletePerson(int index) {
        employeeService.deletePerson(index);
    }

    public Employee getPerson(int id) {
        return employeeService.getPerson(id);
    }

    public void add(Employee employee) {
        employeeService.add(employee);
    }

    public List<Employee> display() {
        return employeeService.display();
    }
}

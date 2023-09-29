package case_study.furama.service.Impl;

import case_study.furama.model.Employee;
import case_study.furama.repository.IPersonRepository;
import case_study.furama.repository.impl.EmployeeRepositoryImpl;
import case_study.furama.service.IPersonService;

import java.util.List;

public class EmployeeServiceImpl implements IPersonService<Employee> {
    private final IPersonRepository<Employee> personRepository = new EmployeeRepositoryImpl();
    @Override
    public void editPerson(String employeeId) {

    }

    @Override
    public void deletePeron(String employeeId) {

    }

    @Override
    public Employee getPerson(int id) {
        return null;
    }

    @Override
    public void add(Employee employee) {

    }

    @Override
    public List<Employee> display() {
        return null;
    }
}

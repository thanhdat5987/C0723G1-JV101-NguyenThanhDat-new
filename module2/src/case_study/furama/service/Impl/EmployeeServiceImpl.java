package case_study.furama.service.Impl;

import case_study.furama.model.Employee;
import case_study.furama.repository.IPersonRepository;
import case_study.furama.repository.impl.EmployeeRepositoryImpl;
import case_study.furama.service.IPersonService;

import java.util.List;

public class EmployeeServiceImpl implements IPersonService<Employee> {
    private final IPersonRepository<Employee> employeeRepository = new EmployeeRepositoryImpl();

    @Override
    public void editPerson(int index) {
        employeeRepository.editPerson(index);
    }

    @Override
    public void deletePerson(int index) {
        employeeRepository.deletePerson(index);
    }

    @Override
    public Employee getPerson(int id) {
        return employeeRepository.getPerson(id);
    }

    @Override
    public void add(Employee employee) {
        employeeRepository.add(employee);
    }

    @Override
    public List<Employee> display() {
        return employeeRepository.display();
    }
}

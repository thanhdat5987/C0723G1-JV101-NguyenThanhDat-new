package case_study.furama.service.Impl;

import case_study.furama.model.Customer;
import case_study.furama.model.Person;
import case_study.furama.repository.IPersonRepository;
import case_study.furama.repository.impl.CustomerRepositoryImpl;
import case_study.furama.service.IPersonService;

import java.util.List;

public class CustomerServiceImpl implements IPersonService<Customer> {
    private final IPersonRepository<Customer> customerRepository = new CustomerRepositoryImpl();

    @Override
    public void editPerson(int index, Customer customer) {
        customerRepository.editPerson(index, customer);
    }

    @Override
    public void deletePerson(int index) {
        customerRepository.deletePerson(index);
    }

    @Override
    public Customer getPerson(int id) {
        return customerRepository.getPerson(id);
    }

    @Override
    public void add(Customer customer) {
        customerRepository.add(customer);
    }

    @Override
    public List<Customer> display() {
        return customerRepository.display();
    }
}

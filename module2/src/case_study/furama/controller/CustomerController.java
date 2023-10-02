package case_study.furama.controller;

import case_study.furama.model.Customer;
import case_study.furama.service.IPersonService;
import case_study.furama.service.Impl.CustomerServiceImpl;

import java.util.List;

public class CustomerController {
    private final IPersonService<Customer> customerService= new CustomerServiceImpl();
    public void editPerson(int index, Customer customer) {
        customerService.editPerson(index,customer);
    }


    public void deletePerson(int index) {
        customerService.deletePerson(index);
    }


    public Customer getPerson(int id) {
        return customerService.getPerson(id);
    }

    public void add(Customer customer) {
        customerService.add(customer);
    }

    public List<Customer> display() {
        return customerService.display();
    }
}

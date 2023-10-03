package case_study.furama.repository.impl;

import case_study.furama.model.Customer;
import case_study.furama.model.Customer;
import case_study.furama.model.Employee;
import case_study.furama.repository.IPersonRepository;
import case_study.furama.util.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements IPersonRepository<Customer> {
    public static final String CUSTOMER_PATH = "/Users/thaodao/Thanh Dat/GitHub/Codegym/C0723G1-JV101-NguyenThanhDat-new/module2/src/case_study/furama/data/customer.csv";
    public static final String COMMA = ",";
    @Override
    public void editPerson(int index, Customer customer) {
        List<Customer> customers = readCustomerFromFile();
        customers.set(index, customer);
        writeCustomersToFile(customers);
    }

    @Override
    public void deletePerson(int index) {
        List<Customer> customers = readCustomerFromFile();
        customers.remove(index);
        writeCustomersToFile(customers);
    }

    @Override
    public Customer getPerson(int index) {
        return readCustomerFromFile().get(index);
    }

    @Override
    public void add(Customer customer) {
        List<Customer> customers = readCustomerFromFile();
        customers.add(customer);
        writeCustomersToFile(customers);
    }
    private List<Customer> readCustomerFromFile() {
        List<String> data = FileUtil.readFile(CUSTOMER_PATH);
        return convertStringToCustomer(data);
    }

    private static List<Customer> convertStringToCustomer(List<String> data) {
        List<Customer> customers = new ArrayList<>();
        for (String str : data) {
            String[] splittedStrs = str.split(COMMA);
            customers.add(new Customer(
                    splittedStrs[0],
                    splittedStrs[1],
                    splittedStrs[2],
                    splittedStrs[3],
                    splittedStrs[4],
                    splittedStrs[5],
                    splittedStrs[6],
                    splittedStrs[7],
                    splittedStrs[8]));
        }
        return customers;
    }

    private void writeCustomersToFile(List<Customer> customers) {
        List<String> data = convertCustomersToString(customers);
        FileUtil.writeFile(CUSTOMER_PATH, data);
    }

    private static List<String> convertCustomersToString(List<Customer> customers) {
        List<String> data = new ArrayList<>();
        for (Customer customer : customers) {
            data.add(
                    customer.getCustomerId()
                            + COMMA + customer.getName()
                            + COMMA + customer.getDateOfBirth()
                            + COMMA + customer.getGender()
                            + COMMA + customer.getCitizenId()
                            + COMMA + customer.getPhoneNumber()
                            + COMMA + customer.getEmail()
                            + COMMA + customer.getCustomerType()
                            + COMMA + customer.getAddress()
            );
        }
        return data;
    }

    @Override
    public List<Customer> display() {
        return readCustomerFromFile();
    }
}

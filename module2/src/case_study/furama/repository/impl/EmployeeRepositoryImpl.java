package case_study.furama.repository.impl;

import case_study.furama.model.Employee;
import case_study.furama.repository.IPersonRepository;
import case_study.furama.util.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements IPersonRepository<Employee> {

    public static final String EMPLOYEE_PATH = "/Users/thaodao/Thanh Dat/GitHub/Codegym/C0723G1-JV101-NguyenThanhDat-new/module2/src/case_study/furama/data/employee2.csv";
    public static final String COMMA = ",";

    @Override
    public void editPerson(int index, Employee employee) {
        List<Employee> employees = readEmployeesFromFile();
        employees.set(index, employee);
        writeEmployeesToFile(employees);
    }

    @Override
    public void deletePerson(int index) {
        List<Employee> employees = readEmployeesFromFile();
        employees.remove(index);
        writeEmployeesToFile(employees);
    }

    @Override
    public Employee getPerson(int index) {
        return readEmployeesFromFile().get(index);
    }

    @Override
    public void add(Employee employee) {
        List<Employee> employees = readEmployeesFromFile();
        employees.add(employee);
        writeEmployeesToFile(employees);
    }

    private List<Employee> readEmployeesFromFile() {
        List<String> data = FileUtil.readFile(EMPLOYEE_PATH);
        return convertStringToEmployee(data);
    }

    private static List<Employee> convertStringToEmployee(List<String> data) {
        List<Employee> employees = new ArrayList<>();
        for (String str : data) {
            String[] splittedStrs = str.split(COMMA);
            employees.add(new Employee(
                    splittedStrs[0],
                    splittedStrs[1],
                    splittedStrs[2],
                    splittedStrs[3],
                    splittedStrs[4],
                    splittedStrs[5],
                    splittedStrs[6],
                    splittedStrs[7],
                    splittedStrs[8],
                    Integer.parseInt(splittedStrs[9])));
        }
        return employees;
    }

    private void writeEmployeesToFile(List<Employee> employees) {
        List<String> data = convertEmployeesToString(employees);
        FileUtil.writeFile(EMPLOYEE_PATH, data);
    }

    private static List<String> convertEmployeesToString(List<Employee> employees) {
        List<String> data = new ArrayList<>();
        for (Employee employee : employees) {
            data.add(
                    employee.getEmployeeId()
                            + COMMA + employee.getName()
                            + COMMA + employee.getDateOfBirth()
                            + COMMA + employee.getGender()
                            + COMMA + employee.getCitizenId()
                            + COMMA + employee.getPhoneNumber()
                            + COMMA + employee.getEmail()
                            + COMMA + employee.getAcademicLevel()
                            + COMMA + employee.getPosition()
                            + COMMA + employee.getSalary()
            );
        }
        return data;
    }

    @Override
    public List<Employee> display() {
        return readEmployeesFromFile();
    }
}

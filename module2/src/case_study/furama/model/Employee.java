package case_study.furama.model;

public class Employee extends Person {
    private String employeeId;
    private String academicLevel;
    private String position;
    private int salary;

    public Employee() {
    }

    public Employee(String name, String dateOfBirth, String gender, String citizenId, String phoneNumber, String email, String employeeId, String academicLevel, String position, int salary) {
        super(name, dateOfBirth, gender, citizenId, phoneNumber, email);
        this.employeeId = employeeId;
        this.academicLevel = academicLevel;
        this.position = position;
        this.salary = salary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getAcademicLevel() {
        return academicLevel;
    }

    public void setAcademicLevel(String academicLevel) {
        this.academicLevel = academicLevel;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", academicLevel='" + academicLevel + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                "} " + super.toString();
    }
}

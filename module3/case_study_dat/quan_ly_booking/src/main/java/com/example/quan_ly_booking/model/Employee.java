package com.example.quan_ly_booking.model;

public class Employee {
    private int employeeId;
    private String employeeName;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Employee(int employeeId, String emloyeeName) {
        this.employeeId = employeeId;
        this.employeeName = emloyeeName;
    }
}

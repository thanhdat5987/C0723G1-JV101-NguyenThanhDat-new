package com.example.casestudy.model;

public class EmployeeBooking {
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

    public EmployeeBooking(int employeeId, String emloyeeName) {
        this.employeeId = employeeId;
        this.employeeName = emloyeeName;
    }
}

package com.sujal.employee.dto;

public class EmployeeSalaryDTO {

    private String firstName;
    private Double salary;

    public EmployeeSalaryDTO(String firstName, Double salary) {
        this.firstName = firstName;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public Double getSalary() {
        return salary;
    }
}
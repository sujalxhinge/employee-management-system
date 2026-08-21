package com.sujal.employee;

import com.sujal.employee.entity.Employee;
import com.sujal.employee.service.EmployeeService;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("Starting Employee Management System...");

        EmployeeService employeeService = new EmployeeService();

        // ==========================================
        // HIBERNATE EXPERIMENTS
        // Run ONE experiment at a time
        // ==========================================

        // 1. Find employee by ID
        // Employee foundEmployee = employeeService.findEmployeeById(1L);

        // if (foundEmployee != null) {
        //     System.out.println("Employee found:");
        //     System.out.println("ID: " + foundEmployee.getId());
        //     System.out.println("First Name: " + foundEmployee.getFirstName());
        //     System.out.println("Last Name: " + foundEmployee.getLastName());
        //     System.out.println("Email: " + foundEmployee.getEmail());
        //     System.out.println("Salary: " + foundEmployee.getSalary());
        // } else {
        //     System.out.println("Employee not found.");
        // }


        // 2. Find all employees
        // List<Employee> employees = employeeService.findAllEmployees();

        // for (Employee employee : employees) {
        //     System.out.println(
        //             employee.getId() + " | " +
        //             employee.getFirstName() + " | " +
        //             employee.getLastName() + " | " +
        //             employee.getEmail() + " | " +
        //             employee.getSalary()
        //     );
        // }


        // 3. Create employee
        // Employee employee = new Employee();
        // employee.setFirstName("Santosh");
        // employee.setLastName("Developer");
        // employee.setEmail("santosh98@example.com");
        // employee.setSalary(50000.0);
        //
        // employeeService.createEmployee(employee);


        // 4. Update employee
        // Employee employee = employeeService.findEmployeeById(1L);
        //
        // if (employee != null) {
        //     employee.setSalary(75000.0);
        //     employee.setEmail("updated@example.com");
        //     employeeService.updateEmployee(employee);
        // }


        // 5. Delete employee
        // employeeService.deleteEmployee(9L);


        // 6. Dirty checking
        // employeeService.updateSalaryUsingDirtyChecking(1L, 90000.0);


        // 7. First-level cache
        // employeeService.testFirstLevelCache(1L);


        // 8. Session boundary
        // employeeService.testSessionBoundary(1L);


        // 9. Entity lifecycle
        // employeeService.testEntityLifecycle();


        // 10. Detach
        // employeeService.testDetach(1L);


        // 11. Remove lifecycle
        // employeeService.testRemoveLifecycle(2L);


        // 12. Clear
        // employeeService.testClear(1L);


        // 13. Refresh
        // employeeService.testRefresh(1L);


        // 14. Validation
       // employeeService.testValidation();
        Employee employee = new Employee();

        employee.setFirstName("Sujal");
        employee.setLastName("Developer");
        employee.setEmail("sujal@example.com");
        employee.setSalary(50000.0);

        //employeeService.createEmployee(employee);
        employee = employeeService.findEmployeeById(1L);

        if (employee != null) {
            employee.setFirstName("Sujal");
            employee.setEmail("sujal@example.com");
            employee.setSalary(80000.0);

            employeeService.updateEmployee(employee);
        }
    }
}
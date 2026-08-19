package com.sujal.employee;
import com.sujal.employee.dao.EmployeeDAO;
import com.sujal.employee.config.HibernateUtil;
import com.sujal.employee.entity.Employee;
import com.sujal.employee.service.EmployeeService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("Starting Employee Management System...");
        EmployeeService employeeService = new EmployeeService();

        Employee employee = new Employee();
        employee.setFirstName("Santosh");
        employee.setLastName("Developer");
        employee.setEmail("santosh98@example.com");
        employee.setSalary(50000.0);
       // employeeService.createEmployee(employee);

        Employee foundEmployee = employeeService.findEmployeeById(2L);

        System.out.println("Employee found:");
        System.out.println("ID: " + foundEmployee.getId());
        System.out.println("First Name: " + foundEmployee.getFirstName());
        System.out.println("Last Name: " + foundEmployee.getLastName());
        System.out.println("Email: " + foundEmployee.getEmail());
        System.out.println("Salary: " + foundEmployee.getSalary());

        List<Employee> employees = employeeService.findAllEmployees();

        for (Employee employe : employees) {
            System.out.println(
                    employe.getId() + " | " +
                            employe.getFirstName() + " | " +
                            employe.getLastName() + " | " +
                            employe.getEmail() + " | " +
                            employe.getSalary()
            );
        }

        Employee emp = employeeService.findEmployeeById(1L);
        emp.setSalary(75000.0);
        emp.setEmail("updated@example.com");
        employeeService.updateEmployee(emp);

        employeeService.deleteEmployee(9L);
        employeeService.updateSalaryUsingDirtyChecking(1L, 80000.0);

        employeeService.testFirstLevelCache(1L);

        employeeService.testSessionBoundary(1L);

        employeeService.testEntityLifecycle();


    }
}
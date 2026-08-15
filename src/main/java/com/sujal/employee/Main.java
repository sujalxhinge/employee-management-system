package com.sujal.employee;
import com.sujal.employee.dao.EmployeeDAO;
import com.sujal.employee.config.HibernateUtil;
import com.sujal.employee.entity.Employee;
import com.sujal.employee.service.EmployeeService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main {

    public static void main(String[] args) {

        System.out.println("Starting Employee Management System...");
        EmployeeService employeeService = new EmployeeService();

        Employee employee = new Employee();
        employee.setFirstName("Santosh");
        employee.setLastName("Developer");
        employee.setEmail("santosh98@example.com");
        employee.setSalary(50000.0);
        employeeService.createEmployee(employee);

    }
}
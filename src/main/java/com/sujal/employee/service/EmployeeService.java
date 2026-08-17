package com.sujal.employee.service;

import com.sujal.employee.dao.EmployeeDAO;
import com.sujal.employee.entity.Employee;

import java.util.List;

public class EmployeeService {

    private EmployeeDAO employeeDAO;

    public EmployeeService() {
        this.employeeDAO = new EmployeeDAO();
    }

    public void createEmployee(Employee employee) {
        employeeDAO.save(employee);
    }

    public Employee findEmployeeById(Long id) {
        return employeeDAO.findById(id);
    }

    public List<Employee> findAllEmployees() {
        return employeeDAO.findAll();
    }

    public void updateEmployee(Employee employee) {
        employeeDAO.update(employee);
    }
    public void deleteEmployee(Long id){
        employeeDAO.delete(id);
    }
}
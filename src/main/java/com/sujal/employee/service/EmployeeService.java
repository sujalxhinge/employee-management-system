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
    public void updateSalaryUsingDirtyChecking(Long id, Double newSalary) {
        employeeDAO.updateUsingDirtyChecking(id, newSalary);
    }
    public void testFirstLevelCache(Long id) {
        employeeDAO.testFirstLevelCache(id);
    }
    public void testSessionBoundary(Long id) {
        employeeDAO.testSessionBoundary(id);
    }
    public void testEntityLifecycle() {
        employeeDAO.testEntityLifecycle();
    }
    public void testRemoveLifecycle(Long id) {
        employeeDAO.testRemoveLifecycle(id);
    }
    public void testDetach(Long id) {
        employeeDAO.testDetach(id);
    }
    public void testClear(Long id) {
        employeeDAO.testClear(id);
    }
    public void testRefresh(Long id) {
        employeeDAO.testRefresh(id);
    }
}
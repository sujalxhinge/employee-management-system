package com.sujal.employee.service;

import com.sujal.employee.dao.EmployeeDAO;
import com.sujal.employee.entity.Employee;
import jakarta.validation.ConstraintViolation;

import java.util.List;
import java.util.Set;

public class EmployeeService {

    private EmployeeDAO employeeDAO;

    public EmployeeService() {
        this.employeeDAO = new EmployeeDAO();
    }

    // ==========================================
    // CREATE + VALIDATION
    // ==========================================

    public void createEmployee(Employee employee) {

        Set<ConstraintViolation<Employee>> violations =
                employeeDAO.validateEmployee(employee);

        if (!violations.isEmpty()) {

            System.out.println("Employee validation failed:");

            for (ConstraintViolation<Employee> violation : violations) {

                System.out.println(
                        violation.getPropertyPath()
                                + " : "
                                + violation.getMessage()
                );
            }

            return;
        }

        employeeDAO.save(employee);

        System.out.println("Employee created successfully.");
    }


    // ==========================================
    // READ
    // ==========================================

    public Employee findEmployeeById(Long id) {
        return employeeDAO.findById(id);
    }

    public List<Employee> findAllEmployees() {
        return employeeDAO.findAll();
    }


    // ==========================================
    // UPDATE
    // ==========================================

    public void updateEmployee(Employee employee) {

        Set<ConstraintViolation<Employee>> violations =
                employeeDAO.validateEmployee(employee);

        if (!violations.isEmpty()) {

            System.out.println("Employee validation failed:");

            for (ConstraintViolation<Employee> violation : violations) {
                System.out.println(
                        violation.getPropertyPath()
                                + " : "
                                + violation.getMessage()
                );
            }

            return;
        }

        employeeDAO.update(employee);

        System.out.println("Employee updated successfully.");
    }


    // ==========================================
    // DELETE
    // ==========================================

    public void deleteEmployee(Long id) {
        employeeDAO.delete(id);
    }


    // ==========================================
    // DIRTY CHECKING
    // ==========================================

    public void updateSalaryUsingDirtyChecking(
            Long id,
            Double newSalary
    ) {
        employeeDAO.updateUsingDirtyChecking(id, newSalary);
    }


    // ==========================================
    // HIBERNATE EXPERIMENTS
    // ==========================================

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

    public void testValidation() {
        employeeDAO.testValidation();
    }
}
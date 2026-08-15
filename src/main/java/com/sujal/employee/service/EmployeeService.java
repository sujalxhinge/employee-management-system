package com.sujal.employee.service;

import com.sujal.employee.dao.EmployeeDAO;
import com.sujal.employee.entity.Employee;

public class EmployeeService {
    private EmployeeDAO employeeDAO;
    public EmployeeService(){
        this.employeeDAO = new EmployeeDAO();
    }
    public void createEmployee(Employee employee){
        employeeDAO.save(employee);
    }
}

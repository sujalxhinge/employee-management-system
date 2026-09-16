package com.sujal.employee.service;

import com.sujal.employee.dao.DepartmentDAO;
import com.sujal.employee.entity.Department;

public class DepartmentService {

    private DepartmentDAO departmentDAO;

    public DepartmentService() {
        this.departmentDAO = new DepartmentDAO();
    }

    public void createDepartment(Department department) {
        departmentDAO.save(department);
    }
}
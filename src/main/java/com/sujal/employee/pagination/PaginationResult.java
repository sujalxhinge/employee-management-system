package com.sujal.employee.pagination;

import com.sujal.employee.entity.Employee;

import java.util.List;

public class PaginationResult {

    private List<Employee> employees;
    private int currentPage;
    private int pageSize;
    private long totalEmployees;
    private long totalPages;

    public PaginationResult(
            List<Employee> employees,
            int currentPage,
            int pageSize,
            long totalEmployees,
            long totalPages
    ) {
        this.employees = employees;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalEmployees = totalEmployees;
        this.totalPages = totalPages;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public long getTotalEmployees() {
        return totalEmployees;
    }

    public long getTotalPages() {
        return totalPages;
    }
}
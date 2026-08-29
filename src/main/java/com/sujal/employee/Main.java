package com.sujal.employee;

import com.sujal.employee.entity.Employee;
import com.sujal.employee.pagination.PaginationResult;
import com.sujal.employee.service.EmployeeService;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("Starting Employee Management System...");

        EmployeeService employeeService = new EmployeeService();

        // =====================================================
        // 1. FIND EMPLOYEE BY ID
        // =====================================================

        /*
        Employee foundEmployee = employeeService.findEmployeeById(1L);

        if (foundEmployee != null) {

            System.out.println("Employee found:");
            System.out.println("ID: " + foundEmployee.getId());
            System.out.println("First Name: " + foundEmployee.getFirstName());
            System.out.println("Last Name: " + foundEmployee.getLastName());
            System.out.println("Email: " + foundEmployee.getEmail());
            System.out.println("Salary: " + foundEmployee.getSalary());

        } else {

            System.out.println("Employee not found.");
        }
        */


        // =====================================================
        // 2. FIND ALL EMPLOYEES
        // =====================================================

        /*
        List<Employee> employees = employeeService.findAllEmployees();

        for (Employee employee : employees) {

            System.out.println(
                    employee.getId() + " | " +
                    employee.getFirstName() + " | " +
                    employee.getLastName() + " | " +
                    employee.getEmail() + " | " +
                    employee.getSalary()
            );
        }
        */


        // =====================================================
        // 3. CREATE EMPLOYEE
        // =====================================================

        /*
        Employee employee = new Employee();

        employee.setFirstName("Santosh");
        employee.setLastName("Developer");
        employee.setEmail("santosh98@example.com");
        employee.setSalary(50000.0);

        employeeService.createEmployee(employee);
        */


        // =====================================================
        // 4. UPDATE EMPLOYEE
        // =====================================================

        /*
        Employee employee = employeeService.findEmployeeById(1L);

        if (employee != null) {

            employee.setSalary(75000.0);
            employee.setEmail("updated@example.com");

            employeeService.updateEmployee(employee);
        }
        */


        // =====================================================
        // 5. DELETE EMPLOYEE
        // =====================================================

        /*
        employeeService.deleteEmployee(9L);
        */


        // =====================================================
        // 6. DIRTY CHECKING
        // =====================================================

        /*
        employeeService.updateSalaryUsingDirtyChecking(1L, 90000.0);
        */


        // =====================================================
        // 7. FIRST LEVEL CACHE
        // =====================================================

        /*
        employeeService.testFirstLevelCache(1L);
        */


        // =====================================================
        // 8. SESSION BOUNDARY
        // =====================================================

        /*
        employeeService.testSessionBoundary(1L);
        */


        // =====================================================
        // 9. ENTITY LIFECYCLE
        // =====================================================

        /*
        employeeService.testEntityLifecycle();
        */


        // =====================================================
        // 10. DETACH
        // =====================================================

        /*
        employeeService.testDetach(1L);
        */


        // =====================================================
        // 11. REMOVE LIFECYCLE
        // =====================================================

        /*
        employeeService.testRemoveLifecycle(2L);
        */


        // =====================================================
        // 12. CLEAR
        // =====================================================

        /*
        employeeService.testClear(1L);
        */


        // =====================================================
        // 13. REFRESH
        // =====================================================

        /*
        employeeService.testRefresh(1L);
        */


        // =====================================================
        // 14. VALIDATION
        // =====================================================

        /*
        employeeService.testValidation();
        */


        // =====================================================
        // 15. FIND BY FIRST NAME
        // =====================================================

        /*
        List<Employee> employees =
                employeeService.findEmployeesByFirstName("Sujal");

        for (Employee employee : employees) {

            System.out.println(
                    employee.getId() + " | " +
                    employee.getFirstName() + " | " +
                    employee.getLastName() + " | " +
                    employee.getEmail() + " | " +
                    employee.getSalary()
            );
        }
        */


        // =====================================================
        // 16. FIND BY EMAIL
        // =====================================================

        /*
        List<Employee> employees =
                employeeService.findByEmail("sarthak2@example.com");

        for (Employee employee : employees) {

            System.out.println(
                    employee.getId() + " | " +
                    employee.getFirstName() + " | " +
                    employee.getLastName() + " | " +
                    employee.getEmail() + " | " +
                    employee.getSalary()
            );
        }
        */


        // =====================================================
        // 17. SALARY GREATER THAN
        // =====================================================

        /*
        List<Employee> employees =
                employeeService.findBySalaryGreaterThan(50000.0);

        for (Employee employee : employees) {

            System.out.println(
                    employee.getId() + " | " +
                    employee.getFirstName() + " | " +
                    employee.getLastName() + " | " +
                    employee.getEmail() + " | " +
                    employee.getSalary()
            );
        }
        */


        // =====================================================
        // 18. FIRST NAME CONTAINING
        // =====================================================

        /*
        List<Employee> employees =
                employeeService.findByFirstNameContaining("Su");

        for (Employee employee : employees) {

            System.out.println(
                    employee.getId() + " | " +
                    employee.getFirstName() + " | " +
                    employee.getLastName() + " | " +
                    employee.getEmail() + " | " +
                    employee.getSalary()
            );
        }
        */


        // =====================================================
        // 19. PAGINATION - BASIC
        // =====================================================

        /*
        List<Employee> employees =
                employeeService.findEmployeesWithPagination(0, 5);

        for (Employee employee : employees) {

            System.out.println(
                    employee.getId() + " | " +
                    employee.getFirstName() + " | " +
                    employee.getSalary()
            );
        }
        */


        // =====================================================
        // 20. COUNT EMPLOYEES
        // =====================================================

        /*
        long totalEmployees =
                employeeService.countEmployees();

        System.out.println(
                "Total Employees: " + totalEmployees
        );
        */


        // =====================================================
        // 21. TOTAL PAGES
        // =====================================================

        /*
        long totalPages =
                employeeService.getTotalPages(10);

        System.out.println(
                "Total Pages: " + totalPages
        );
        */


        // =====================================================
        // 22. PAGINATION RESULT
        // =====================================================

        PaginationResult result =
                employeeService.getEmployeesPage(0, 5);

        System.out.println();
        System.out.println("========== PAGINATION RESULT ==========");

        System.out.println(
                "Current Page: " +
                        result.getCurrentPage()
        );

        System.out.println(
                "Page Size: " +
                        result.getPageSize()
        );

        System.out.println(
                "Total Employees: " +
                        result.getTotalEmployees()
        );

        System.out.println(
                "Total Pages: " +
                        result.getTotalPages()
        );

        System.out.println(
                "Has Next Page: " +
                        result.hasNextPage()
        );

        System.out.println(
                "Has Previous Page: " +
                        result.hasPreviousPage()
        );

        System.out.println();
        System.out.println("Employees on Current Page:");

        for (Employee employee : result.getEmployees()) {

            System.out.println(
                    employee.getId() + " | " +
                            employee.getFirstName() + " | " +
                            employee.getLastName() + " | " +
                            employee.getEmail() + " | " +
                            employee.getSalary()
            );
        }

        System.out.println("========================================");
    }
}
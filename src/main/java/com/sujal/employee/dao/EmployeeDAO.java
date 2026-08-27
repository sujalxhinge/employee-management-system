package com.sujal.employee.dao;

import com.sujal.employee.config.HibernateUtil;
import com.sujal.employee.entity.Employee;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Set;

public class EmployeeDAO {

    // ==========================================
    // CREATE
    // ==========================================

    public void save(Employee employee) {

        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            session.persist(employee);

            transaction.commit();

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            throw e;

        } finally {
            session.close();
        }
    }


    // ==========================================
    // READ - FIND BY ID
    // ==========================================

    public Employee findById(Long id) {

        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        Employee employee = session.find(Employee.class, id);

        session.close();

        return employee;
    }


    // ==========================================
    // READ - FIND ALL
    // ==========================================

    public List<Employee> findAll() {

        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        List<Employee> employees = session
                .createQuery("FROM Employee", Employee.class)
                .getResultList();

        session.close();

        return employees;
    }


    // ==========================================
    // UPDATE
    // ==========================================

    public void update(Employee employee) {

        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        Transaction transaction = null;

        try {

            transaction = session.beginTransaction();

            session.merge(employee);

            transaction.commit();

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            throw e;

        } finally {
            session.close();
        }
    }


    // ==========================================
    // DELETE
    // ==========================================

    public void delete(Long id) {

        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        Transaction transaction = null;

        try {

            transaction = session.beginTransaction();

            Employee employee = session.find(Employee.class, id);

            if (employee != null) {
                session.remove(employee);
            }

            transaction.commit();

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            throw e;

        } finally {
            session.close();
        }
    }


    // ==========================================
    // DIRTY CHECKING
    // ==========================================

    public void updateUsingDirtyChecking(Long id, Double newSalary) {

        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        Transaction transaction = null;

        try {

            transaction = session.beginTransaction();

            Employee employee = session.find(Employee.class, id);

            if (employee != null) {
                employee.setSalary(newSalary);
            }

            transaction.commit();

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            throw e;

        } finally {
            session.close();
        }
    }


    // ==========================================
    // FIRST-LEVEL CACHE
    // ==========================================

    public void testFirstLevelCache(Long id) {

        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        try {

            Employee emp1 = session.find(Employee.class, id);

            System.out.println(
                    "First employee: " + emp1.getFirstName()
            );

            Employee emp2 = session.find(Employee.class, id);

            System.out.println(
                    "Second employee: " + emp2.getFirstName()
            );

            System.out.println(
                    "Same object? " + (emp1 == emp2)
            );

        } finally {
            session.close();
        }
    }


    // ==========================================
    // SESSION BOUNDARY
    // ==========================================

    public void testSessionBoundary(Long id) {

        // Session 1
        Session session1 = HibernateUtil
                .getSessionFactory()
                .openSession();

        Employee emp1 = session1.find(Employee.class, id);

        System.out.println(
                "Session 1: " + emp1.getFirstName()
        );

        session1.close();


        // Session 2
        Session session2 = HibernateUtil
                .getSessionFactory()
                .openSession();

        Employee emp2 = session2.find(Employee.class, id);

        System.out.println(
                "Session 2: " + emp2.getFirstName()
        );

        session2.close();
    }


    // ==========================================
    // ENTITY LIFECYCLE
    // ==========================================

    public void testEntityLifecycle() {

        Employee employee = new Employee();

        employee.setFirstName("Lifecycle");
        employee.setLastName("Test");
        employee.setEmail("lifecycle@example.com");
        employee.setSalary(60000.0);

        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        Transaction transaction = session.beginTransaction();

        // TRANSIENT → MANAGED
        session.persist(employee);

        // Dirty checking
        employee.setSalary(65000.0);

        transaction.commit();

        // MANAGED → DETACHED
        session.close();

        // Change detached entity
        employee.setSalary(70000.0);

        Session session2 = HibernateUtil
                .getSessionFactory()
                .openSession();

        Transaction transaction2 = session2.beginTransaction();

        // DETACHED → MANAGED
        Employee managedEmployee = session2.merge(employee);

        transaction2.commit();

        session2.close();
    }


    // ==========================================
    // REMOVE LIFECYCLE
    // ==========================================

    public void testRemoveLifecycle(Long id) {

        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        Transaction transaction = null;

        try {

            transaction = session.beginTransaction();

            Employee employee = session.find(Employee.class, id);

            if (employee != null) {
                session.remove(employee);
            }

            transaction.commit();

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            throw e;

        } finally {
            session.close();
        }
    }


    // ==========================================
    // DETACH
    // ==========================================

    public void testDetach(Long id) {

        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        Transaction transaction = null;

        try {

            transaction = session.beginTransaction();

            Employee employee = session.find(Employee.class, id);

            if (employee != null) {

                System.out.println(
                        "Before detach: " + employee.getSalary()
                );

                session.detach(employee);

                employee.setSalary(99999.0);

                System.out.println(
                        "After detach: " + employee.getSalary()
                );
            }

            transaction.commit();

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            throw e;

        } finally {
            session.close();
        }
    }


    // ==========================================
    // CLEAR
    // ==========================================

    public void testClear(Long id) {

        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        Transaction transaction = null;

        try {

            transaction = session.beginTransaction();

            Employee employee = session.find(Employee.class, id);

            if (employee != null) {

                System.out.println(
                        "Before clear: " + employee.getSalary()
                );

                session.clear();

                employee.setSalary(99999.0);

                System.out.println(
                        "After clear: " + employee.getSalary()
                );
            }

            transaction.commit();

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            throw e;

        } finally {
            session.close();
        }
    }


    // ==========================================
    // REFRESH
    // ==========================================

    public void testRefresh(Long id) {

        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        Transaction transaction = null;

        try {

            transaction = session.beginTransaction();

            Employee employee = session.find(Employee.class, id);

            if (employee != null) {

                System.out.println(
                        "Before change: " + employee.getSalary()
                );

                employee.setSalary(12345.0);

                System.out.println(
                        "Before refresh: " + employee.getSalary()
                );

                session.refresh(employee);

                System.out.println(
                        "After refresh: " + employee.getSalary()
                );
            }

            transaction.commit();

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            throw e;

        } finally {
            session.close();
        }
    }


    // ==========================================
    // VALIDATION
    // ==========================================

    public Set<ConstraintViolation<Employee>> validateEmployee(
            Employee employee
    ) {

        ValidatorFactory factory =
                Validation.buildDefaultValidatorFactory();

        Validator validator = factory.getValidator();

        Set<ConstraintViolation<Employee>> violations =
                validator.validate(employee);

        factory.close();

        return violations;
    }


    // ==========================================
    // TEST VALIDATION
    // ==========================================

    public void testValidation() {

        Employee employee = new Employee();

        employee.setFirstName("A");
        employee.setLastName("Developer");
        employee.setEmail("test-example");
        employee.setSalary(-1.0);

        Set<ConstraintViolation<Employee>> violations =
                validateEmployee(employee);

        for (ConstraintViolation<Employee> violation : violations) {

            System.out.println(
                    violation.getPropertyPath()
                            + " : "
                            + violation.getMessage()
            );
        }
    }
    public List<Employee> findByFirstName(String firstName) {

        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        try {

            return session.createQuery(

                           " FROM Employee e WHERE e.email = :email",
                            Employee.class
                    )
                    .setParameter("firstName", firstName)
                    .getResultList();

        } finally {
            session.close();
        }
    }
    public List<Employee> findByEmail(String email) {

        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        try {
            return session.createQuery(
                            "FROM Employee e WHERE e.email = :email",
                            Employee.class
                    )
                    .setParameter("email", email)
                    .getResultList();

        } finally {
            session.close();
        }
    }
    public List<Employee> findBySalaryGreaterThan(Double salary) {

        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        try {

            return session.createQuery(
                            "FROM Employee e WHERE e.salary > :salary",
                            Employee.class
                    )
                    .setParameter("salary", salary)
                    .getResultList();

        } finally {
            session.close();
        }
    }
    public List<Employee> findByFirstNameContaining(String keyword) {

        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        try {

            return session.createQuery(
                            "FROM Employee e WHERE e.firstName LIKE :keyword",
                            Employee.class
                    )
                    .setParameter("keyword", "%" + keyword + "%")
                    .getResultList();

        } finally {
            session.close();
        }
    }
    public List<Employee> findEmployeesWithPagination(
            int page,
            int pageSize
    ) {

        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        try {

            int offset = page * pageSize;

            return session.createQuery(
                            "FROM Employee e ORDER BY e.id",
                            Employee.class
                    )
                    .setFirstResult(offset)
                    .setMaxResults(pageSize)
                    .getResultList();

        } finally {
            session.close();
        }
    }
    public long countEmployees() {

        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        try {

            return session.createQuery(
                    "SELECT COUNT(e) FROM Employee e",
                    Long.class
            ).getSingleResult();

        } finally {
            session.close();
        }
    }
}
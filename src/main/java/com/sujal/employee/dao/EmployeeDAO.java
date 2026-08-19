package com.sujal.employee.dao;
import com.sujal.employee.entity.Employee;
import com.sujal.employee.config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeeDAO {
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
    public Employee findById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Employee employee = session.find(Employee.class,id);
        session.close();
        return employee;
    }
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
    public void update(Employee employee){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.merge(employee);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null){
                transaction.rollback();
            }
        }
    }
    public void delete(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Employee employee = session.find(Employee.class,id);
            if(employee!=null){
                session.remove(employee);
            }
            transaction.commit();

        } catch (Exception e) {
            if(transaction!=null){
                transaction.rollback();
            }
            throw e;
        }finally {
            session.close();
        }
    }
    public void updateUsingDirtyChecking(Long id,Double newSalary){
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
    public void testFirstLevelCache(Long id) {

        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        try {

            Employee emp1 = session.find(Employee.class, id);

            System.out.println("First employee: " + emp1.getFirstName());

            Employee emp2 = session.find(Employee.class, id);

            System.out.println("Second employee: " + emp2.getFirstName());

            System.out.println("Same object? " + (emp1 == emp2));

        } finally {
            session.close();
        }
    }
    public void testSessionBoundary(Long id) {

        // Session 1
        Session session1 = HibernateUtil
                .getSessionFactory()
                .openSession();

        Employee emp1 = session1.find(Employee.class, id);

        System.out.println("Session 1: " + emp1.getFirstName());

        session1.close();


        // Session 2
        Session session2 = HibernateUtil
                .getSessionFactory()
                .openSession();

        Employee emp2 = session2.find(Employee.class, id);

        System.out.println("Session 2: " + emp2.getFirstName());

        session2.close();
    }
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

        session.persist(employee);
        employee.setSalary(65000.0);
        transaction.commit();

        session.close();
        employee.setSalary(70000.0);
    }

}

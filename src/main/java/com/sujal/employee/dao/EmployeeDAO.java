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

}

package com.sujal.employee.dao;
import com.sujal.employee.entity.Employee;
import com.sujal.employee.config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

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

}

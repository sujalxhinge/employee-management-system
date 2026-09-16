package com.sujal.employee.dao;

import com.sujal.employee.config.HibernateUtil;
import com.sujal.employee.entity.Department;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DepartmentDAO {

    public void save(Department department) {

        Session session =
                HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            session.persist(department);

            transaction.commit();

            System.out.println("Department saved successfully.");

        } finally {
            session.close();
        }
    }
}
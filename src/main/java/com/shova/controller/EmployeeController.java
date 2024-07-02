package com.shova.controller;

import com.shova.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeController {
    public void createEmployeeTable() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction  = session.beginTransaction();
        Employee uOne = new Employee();
        transaction.commit();
        System.out.println("Successfully saved");
        factory.close();
        session.close();

    }
}

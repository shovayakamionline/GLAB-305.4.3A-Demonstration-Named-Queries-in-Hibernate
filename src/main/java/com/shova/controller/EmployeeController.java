package com.shova.controller;

import com.shova.model.Employee;
import java.util.Iterator;
import java.util.List;
import javax.persistence.TypedQuery;
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

    public void findEmployeeByName() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
//------------  Hibernate Named Query   -------------
        TypedQuery query = session.getNamedQuery("findEmployeeByName");
        query.setParameter("name","Tom Thele");
        List<Employee> employees=query.getResultList();
        Iterator<Employee> itr = employees.iterator();
        while(itr.hasNext()){
            Employee employee = itr.next();
            System.out.println(employee);
        }
        factory.close();
        session.close();
    }

    public void findEmployeeById() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
//------------  Hibernate Named Query   -------------
        TypedQuery query = session.getNamedQuery("get_Emp_name_by_id");
        query.setParameter("id",3);
        List<Object[]> emName=  query.getResultList();
        for(Object[] obj: emName)
        {
            System.out.println("Employee name: " + obj[0] +" | Employee Salary: "+ obj[1] +" | Emp Job Title: "+ obj[2]);
        }
        factory.close();
        session.close();
    }

    public void showOfficeCodes_AsDepartment() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
//------------  Hibernate Named Query   -------------
        TypedQuery query = session.getNamedQuery("empDepAlias");
        List<Object[]> list  =  query.getResultList();
        for(Object[] obj1: list )
        {
            System.out.println("OfficeCode: " + obj1[1] + " | Dep Name: " +obj1[3]+ " | Employee Name: " + obj1[2]);
        }
        factory.close();
        session.close();
    }
}

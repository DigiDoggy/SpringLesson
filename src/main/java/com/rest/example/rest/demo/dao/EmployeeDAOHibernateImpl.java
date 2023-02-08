package com.rest.example.rest.demo.dao;

import com.rest.example.rest.demo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

    //Define field for Entity manager
    private EntityManager entityManager;

    //set up constructor injection
    @Autowired
    public EmployeeDAOHibernateImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }


    @Override
    public List<Employee> findAll() {

        //get current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        //create a query
        Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);

        //Execute query and get result list
        List<Employee> employees = theQuery.getResultList();

        return employees;
    }


    @Override
    public Employee findById(int theId) {

        //get current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        //get the employee based on id
        Employee theEmployee = currentSession.get(Employee.class, theId);

        //return the employee
        return theEmployee;
    }

    @Override
    public void save(Employee theEmployee) {
        //get current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        //Save new employee
        currentSession.saveOrUpdate(theEmployee);

    }

    @Override
    public void deleteByID(int theId) {

        //get current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        //delete object with primery key
        Query theQuery = currentSession.createQuery("delete from Employee where id=:employeeId");
        theQuery.setParameter("employeeId", theId);

        theQuery.executeUpdate();
    }
}

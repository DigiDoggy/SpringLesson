package com.rest.example.rest.demo.dao;

import com.rest.example.rest.demo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById(int theId);

    void save(Employee theEmployee);

    void deleteByID(int theId);

}

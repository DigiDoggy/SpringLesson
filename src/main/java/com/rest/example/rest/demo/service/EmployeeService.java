package com.rest.example.rest.demo.service;

import com.rest.example.rest.demo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int theId);

    void save(Employee theEmployee);

    void deleteByID(int theId);

}

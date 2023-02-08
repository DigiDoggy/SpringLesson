package com.rest.example.rest.demo.rest;

import com.rest.example.rest.demo.entity.Employee;
import com.rest.example.rest.demo.service.EmployeeService;
import com.rest.example.rest.demo.service.EmployeeServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    public EmployeeRestController (EmployeeService employeeService){
        this.employeeService=employeeService;
    }
    //Expose /employees and return list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    // add mapping for GET /employees/{employeeId}
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);

        if(theEmployee == null){
            throw  new RuntimeException("Employee id not found - " + employeeId);
        }
        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){

        employeeService.save(theEmployee);
        return theEmployee;
    }

    //add mapping for delete /employees/{employee} -delete employee
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);

        if(theEmployee == null){
            throw  new RuntimeException("Employee id not found - " + employeeId);
        }
        employeeService.deleteByID(employeeId);
        return "Deleted employee id -" + employeeId;
    }


    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        employeeService.save(theEmployee);
        return theEmployee;
    }

//    // add mapping for GET /employees/{employeeId}
//    @PutMapping("/employees/{employeeId}")
//    public Employee updateEmployee(@RequestBody  int employeeId){
//        Employee theEmployee = employeeService.findById(employeeId);
//
//        if(theEmployee == null){
//            throw  new RuntimeException("Employee id not found - " + employeeId);
//        }
//        return theEmployee;
//    }



}

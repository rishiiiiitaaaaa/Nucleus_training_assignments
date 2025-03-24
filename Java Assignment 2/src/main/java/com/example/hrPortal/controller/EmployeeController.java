package com.example.hrPortal.controller;


import com.example.hrPortal.model.Employee;
import com.example.hrPortal.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


//add1

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "http://localhost:5500", allowCredentials = "true")
 
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Get all employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // Get employee by ID
    @GetMapping("/{empId}")
    public Optional<Employee> getEmployeeById(@PathVariable Integer empId) {
        return employeeService.getEmployeeById(empId);
    }

    // Add a new employee
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    // Update an employee
    @PutMapping("/{empId}")
    public Employee updateEmployee(@PathVariable Integer empId, @RequestBody Employee employee) {
        return employeeService.updateEmployee(empId, employee);
    }

    // Delete an employee
    @DeleteMapping("/{empId}")
    public String deleteEmployee(@PathVariable Integer empId) {
        employeeService.deleteEmployee(empId);
        return "Employee deleted successfully!";
    }
}

 

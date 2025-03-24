package com.example.hrPortal.service;

import com.example.hrPortal.model.Employee;
import com.example.hrPortal.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(Integer empId) {
        return employeeRepository.findById(empId);
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
public Employee updateEmployee(Integer empId, Employee updatedEmployee) {
    return employeeRepository.findById(empId)
        .map(existingEmployee -> {
            existingEmployee.setEmpName(updatedEmployee.getEmpName());
            existingEmployee.setEmpDepartment(updatedEmployee.getEmpDepartment());
            existingEmployee.setEmpEmail(updatedEmployee.getEmpEmail());
            existingEmployee.setEmpSalary(updatedEmployee.getEmpSalary());
            return employeeRepository.save(existingEmployee);
        })
        .orElseThrow(() -> new RuntimeException("Employee not found"));
}

    @Override
    public void deleteEmployee(Integer empId) {
        employeeRepository.deleteById(empId);
    }
}



 
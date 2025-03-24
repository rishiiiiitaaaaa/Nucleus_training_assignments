package com.example.hrPortal.model;
import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Integer empId;

    @Column(name = "emp_name", nullable = false)
    private String empName;

    @Column(name = "emp_department")
    private String empDepartment;

    @Column(name = "emp_email", nullable = false, unique = true)
    private String empEmail;

    @Column(name = "emp_salary")
    private Double empSalary;

    // Constructors
    public Employee() {}

    public Employee(String empName, String empDepartment, String empEmail, Double empSalary) {
        this.empName = empName;
        this.empDepartment = empDepartment;
        this.empEmail = empEmail;
        this.empSalary = empSalary;
    }

    // Getters and Setters
    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpDepartment() {
        return empDepartment;
    }

    public void setEmpDepartment(String empDepartment) {
        this.empDepartment = empDepartment;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public Double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(Double empSalary) {
        this.empSalary = empSalary;
    }
}
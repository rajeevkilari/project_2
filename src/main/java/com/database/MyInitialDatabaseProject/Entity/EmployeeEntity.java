package com.database.MyInitialDatabaseProject.Entity;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "employee")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private int empId;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "age")
    private int empAge;

    @Column(name = "department")
    private String empDept;

    @Autowired
    public EmployeeEntity(String fullName, int empAge, String empDept) {
        this.fullName = fullName;
        this.empAge = empAge;
        this.empDept = empDept;
    }

    public EmployeeEntity() {

    }


    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public int getEmpID() {
        return empId;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setEmpAge(int empAge) {
        this.empAge = empAge;
    }

    public int getEmpAge() {
        return empAge;
    }

    public void setEmpDept(String empDept) {
        this.empDept = empDept;
    }

    public String getEmpDept() {
        return empDept;
    }

    @Override
    public String toString() {
        return "EmployeeEntity{" +
                "empId=" + empId +
                ", fullName='" + fullName + '\'' +
                ", empAge=" + empAge +
                ", empDept='" + empDept + '\'' +
                '}';
    }
}

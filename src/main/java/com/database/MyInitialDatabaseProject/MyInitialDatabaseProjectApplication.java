package com.database.MyInitialDatabaseProject;

import com.database.MyInitialDatabaseProject.Entity.EmployeeEntity;
import com.database.MyInitialDatabaseProject.Repository.EmployeeDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class MyInitialDatabaseProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyInitialDatabaseProjectApplication.class, args);
        //System.out.println("hello database");
    }

    @Bean
    public CommandLineRunner commandLineRunner(EmployeeDAO empDAO) {
        return runner -> {
            //createEmpData(empDAO);
            //insertMultipleEmpData(empDAO);
            //readEmpData(empDAO);
            //selectMultipleEmpData(empDAO);
            //updateEmpData(empDAO);
            updateMultipleEmpData(empDAO);
            //deleteEmpData(empDAO);
            //truncateEmpData(empDAO);
        };
    }

    public void createEmpData(EmployeeDAO empDAO) {
        EmployeeEntity employee = new EmployeeEntity("rajeev", 26, "IT");
        empDAO.createEmployeeData(employee);
    }

    public void insertMultipleEmpData(EmployeeDAO empDAO) {
        EmployeeEntity employee1 = new EmployeeEntity("rajiv", 26, "software");
        EmployeeEntity employee2 = new EmployeeEntity("bharat", 28, "government");
        EmployeeEntity employee3 = new EmployeeEntity("rajeev", 27, "IT");
        empDAO.createEmployeeData(employee1);
        empDAO.createEmployeeData(employee2);
        empDAO.createEmployeeData(employee3);

    }

    public void readEmpData(EmployeeDAO empDAO) {
        int id = 1;
        EmployeeEntity employee = empDAO.readEmployeeData(id);
        System.out.println(employee + " returned data");
    }

    public void selectMultipleEmpData(EmployeeDAO empDAO) {
        List<EmployeeEntity> employeeList = empDAO.selectMultipleEmployeeData();
        for (EmployeeEntity eachEmployee : employeeList) {
            System.out.print(eachEmployee);
        }
    }

    public void updateEmpData(EmployeeDAO empDAO) {
        int id = 1;
        EmployeeEntity employee = empDAO.readEmployeeData(1);
        employee.setFullName("rajiv aditya");
        employee.setEmpAge(27);
        employee.setEmpDept("software");
        empDAO.updateEmployeeData(employee);
        //System.out.println(employee);
    }

    public void updateMultipleEmpData(EmployeeDAO empDAO) {
        String oldEmpDept = "government";
        String newEmpDept = "sachivalayam";
        List<EmployeeEntity> updatingList = empDAO.updateMultipleEmployeeData(oldEmpDept);
        for (EmployeeEntity eachEmployee : updatingList) {
            eachEmployee.setEmpDept(newEmpDept);
            empDAO.updateEmployeeData(eachEmployee);
            System.out.println(eachEmployee);
        }
    }

    public void deleteEmpData(EmployeeDAO empDAO) {
        int id = 2;
        empDAO.deleteEmployeeData(id);
    }

    public void truncateEmpData(EmployeeDAO empDAO) {
        empDAO.truncateEmployeeData();
    }

}

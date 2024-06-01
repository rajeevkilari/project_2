package com.database.MyInitialDatabaseProject.Repository;

import com.database.MyInitialDatabaseProject.Entity.EmployeeEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EmployeeDAO {
    void createEmployeeData(EmployeeEntity employee);

    EmployeeEntity readEmployeeData(Integer empId);

    List<EmployeeEntity> selectMultipleEmployeeData();

    void updateEmployeeData(EmployeeEntity employee);

    List<EmployeeEntity> updateMultipleEmployeeData(String oldEmpDept);

    void deleteEmployeeData(Integer empId);

    int truncateEmployeeData();

}

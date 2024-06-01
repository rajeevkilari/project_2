package com.database.MyInitialDatabaseProject.Repository;

import com.database.MyInitialDatabaseProject.Entity.EmployeeEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDAOImplementation implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void createEmployeeData(EmployeeEntity employee) {
        entityManager.persist(employee);
    }

    @Override
    @Transactional
    public EmployeeEntity readEmployeeData(Integer empId) {
        return entityManager.find(EmployeeEntity.class, empId);
    }

    @Override
    public List<EmployeeEntity> selectMultipleEmployeeData() {
        TypedQuery<EmployeeEntity> query = entityManager.createQuery("from EmployeeEntity", EmployeeEntity.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void updateEmployeeData(EmployeeEntity employee) {
        entityManager.merge(employee);
    }

    @Override
    @Transactional
    public List<EmployeeEntity> updateMultipleEmployeeData(String oldEmpDept) {
        TypedQuery<EmployeeEntity> query =
                entityManager.createQuery("from EmployeeEntity where empDept= : conditionData", EmployeeEntity.class);
        query.setParameter("conditionData", oldEmpDept);
        return query.getResultList();
    }


    @Override
    @Transactional
    public void deleteEmployeeData(Integer empId) {
        EmployeeEntity employee = entityManager.find(EmployeeEntity.class, empId);
        entityManager.remove(employee);
    }

    @Override
    @Transactional
    public int truncateEmployeeData(){
        int deletedRows = entityManager.createQuery("delete from EmployeeEntity").executeUpdate();
        return deletedRows;


    }
}

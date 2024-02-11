package com.pulkit.EmployeeManagementSystem.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pulkit.EmployeeManagementSystem.Model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Serializable> {
    
}

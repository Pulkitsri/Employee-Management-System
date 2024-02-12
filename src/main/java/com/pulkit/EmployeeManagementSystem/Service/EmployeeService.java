package com.pulkit.EmployeeManagementSystem.Service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.pulkit.EmployeeManagementSystem.Model.Employee;

public interface EmployeeService {
    public Employee findEmpById(Integer empid);
    public String addEmployee(Employee employee);
    public Employee updateEmployee(Employee employee);
    public String deleteEmployee(Integer empid);
    public List<Employee> getAllEmployees();
    Page<Employee> findPagenated(int pageNo,int pageSize);

} 

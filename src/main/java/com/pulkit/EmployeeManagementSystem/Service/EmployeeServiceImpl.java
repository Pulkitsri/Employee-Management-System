package com.pulkit.EmployeeManagementSystem.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pulkit.EmployeeManagementSystem.Model.Employee;
import com.pulkit.EmployeeManagementSystem.Repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public Employee findEmpById(Integer empid) {
        Optional<Employee> empbyId = employeeRepo.findById(empid);
        if(empbyId.isPresent()){
            return empbyId.get();
        }
        else{
            return null;
        }
    }

    @Override
    public String addEmployee(Employee employee) {
       // this.employee = employee;
        employeeRepo.save(employee);
        return "Employee added successfully.";
    }

    @Override
    public String deleteEmployee(Integer empid) {
        if(employeeRepo.existsById(empid)){
            employeeRepo.deleteById(empid);
            return "Employee Deleted Successfully";
        }
        else{
            return "Employee Not found.";
        }
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        if(employeeRepo.existsById(employee.getEmpId())){
            employeeRepo.save(employee);
        }
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> allEmployees = employeeRepo.findAll();
        return allEmployees;
    }   
    
}

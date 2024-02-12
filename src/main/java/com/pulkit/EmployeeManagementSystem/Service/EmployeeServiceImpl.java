package com.pulkit.EmployeeManagementSystem.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
        Employee employee =null;
        if(empbyId.isPresent()){
            employee = empbyId.get();
        }
        else{
            throw new RuntimeException("Employee Not Found for Id :: "+empid);
        }
        return employee;
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

    @Override
    public Page<Employee> findPagenated(int pageNo, int pageSize) {
        Pageable pageable =  PageRequest.of(pageNo-1, pageSize);
        return this.employeeRepo.findAll(pageable);
        
    }
}

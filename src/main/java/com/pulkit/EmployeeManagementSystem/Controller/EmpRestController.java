package com.pulkit.EmployeeManagementSystem.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.pulkit.EmployeeManagementSystem.Model.Employee;
import com.pulkit.EmployeeManagementSystem.Service.EmployeeService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/employee")
public class EmpRestController {
    
     @Autowired
     private EmployeeService employeeService;
     
     @GetMapping("{empid}")
     public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer empid) {
         Employee empById = employeeService.findEmpById(empid);
         return new ResponseEntity<>(empById,HttpStatus.OK);
     }

     @PostMapping()
     public String addEmployee(@RequestBody Employee employee){
         String status = employeeService.addEmployee(employee);
         return status;
     }

     @PutMapping
     public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee)
     {
         Employee emp = employeeService.updateEmployee(employee);
         return new ResponseEntity<>(emp,HttpStatus.OK);
     }

     @DeleteMapping("{empId}")
     public String deleteEmployee(@PathVariable Integer empId){
         String status = employeeService.deleteEmployee(empId);
         return status;
     }

     @GetMapping("/all")
     public List<Employee> getAllEmployees(){
         List<Employee> allEmployees = employeeService.getAllEmployees();
         return allEmployees;
     }
}

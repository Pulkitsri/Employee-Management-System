package com.pulkit.EmployeeManagementSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.pulkit.EmployeeManagementSystem.Model.Employee;
import com.pulkit.EmployeeManagementSystem.Service.EmployeeService;

import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class EmpController {
    
    
    @Autowired
    private EmployeeService employeeService;
    
    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listemployees", employeeService.getAllEmployees());
        return "index";
    }

    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model){
        //create model attribute to bind from data
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "new_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.addEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/showFormforUpdate/{id}")
    public String showFormforUpdate(@PathVariable (value="id") Integer id,Model model){
        //Get Employee from the service
        Employee employee = employeeService.findEmpById(id);
        //set employee as a model attribute to pre populate the form
        model.addAttribute("employee", employee);
        return "update_employee";
        
    }

    @PostMapping("/updateEmployee")
    public String updateEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.updateEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable (value = "id") Integer id, Model model){
        //Get Employee from the service
        String status = employeeService.deleteEmployee(id);
        //set employee as a model attribute to pre populate the form
        model.addAttribute("status", status);
        return "redirect:/";
    }
}

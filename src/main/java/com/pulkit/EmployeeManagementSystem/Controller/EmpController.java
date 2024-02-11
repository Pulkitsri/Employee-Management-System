package com.pulkit.EmployeeManagementSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.pulkit.EmployeeManagementSystem.Service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class EmpController {
    
    
    @Autowired
    private EmployeeService employeeService;
    
    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listemployees", employeeService.getAllEmployees());
        return "index";
    }
}

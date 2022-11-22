package com.codegym.controller;

import com.codegym.model.Employee;
import com.codegym.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;

    @GetMapping("/list")
    public String showList(Model model){
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employee",employees);
        return "list";
    }
}

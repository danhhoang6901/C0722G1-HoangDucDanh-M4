package com.codegym.controller;

import com.codegym.model.customer.Customer;
import com.codegym.service.ICustomerService;
import com.codegym.service.impl.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("/list")
    public String listCustomer(@PageableDefault(page = 0, size = 5) Pageable pageable, Model model) {
        Page<Customer> customers = customerService.findAll(pageable);
        model.addAttribute("customers", customers);
        return "customer/list";
    }
}

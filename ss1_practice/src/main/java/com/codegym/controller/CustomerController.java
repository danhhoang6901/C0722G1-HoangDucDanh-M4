package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @RequestMapping("/customers")
    public String showList(Model model) {
        List<Customer> customerList = customerService.findAll();
        model.addAttribute("customerList", customerList);
        return "customer/list";
    }

    @RequestMapping(value = "/edit")
    public String editCustomer(Model model, @RequestParam int id, String name, String email, String address) {
        model.addAttribute("id", id);
        model.addAttribute("name", name);
        model.addAttribute("email", email);
        model.addAttribute("address", address);
        Customer customer = customerService.findById(id);
        customer.setId(id);
        customer.setName(name);
        customer.setEmail(email);
        customer.setAddress(address);
        customerService.update(id, customer);
        model.addAttribute("customer", customer);
        return "customer/edit";
    }

}

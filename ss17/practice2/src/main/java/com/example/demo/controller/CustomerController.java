package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("/list")
    public String list(Model model) {
        Iterable<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "list";
    }

    @GetMapping("/create")
    public String formCreate(Model model) {
        model.addAttribute("customer", new Customer());
        return "create";
    }

    @PostMapping("/create")
    public String create(Customer customer, RedirectAttributes redirectAttributes) {
        customer.setId((long) (Math.random() * 10000));
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("msg", "Successfully added new");
        return "redirect:/list";
    }

    @GetMapping("/edit")
    public String formEdit(@RequestParam("id") Long id, Model model) {
        Optional<Customer> customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("msg", "Update successful");
        return "redirect:/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id, RedirectAttributes redirectAttributes) {
        customerService.remove(id);
        redirectAttributes.addFlashAttribute("msg", "Delete successfully");
        return "redirect:/list";
    }
    
    
}

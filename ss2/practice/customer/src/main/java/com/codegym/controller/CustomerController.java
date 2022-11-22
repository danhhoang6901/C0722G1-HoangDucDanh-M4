package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    ICustomerService customerService;

    @GetMapping("/list")
    public String showList(Model model) {
        List<Customer> customerList = customerService.getAll();
        model.addAttribute("customerList", customerList);
        return "list";
    }

    @GetMapping("/detail/{id}")
    public String getDetail(@PathVariable("id") Integer id, Model model) {
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        return "detail";
    }

    @GetMapping("/create")
    public String showFromCreate() {
        return "create";
    }

    @PostMapping("/create")
    public String saveCustomer(@RequestParam("id") Integer id,
                               @RequestParam("name") String name,
                               @RequestParam("email") String email,
                               @RequestParam("address") String address,
                               RedirectAttributes redirectAttributes) {
        customerService.save(new Customer(id, name, email, address));
        redirectAttributes.addFlashAttribute("msg", "Xóa thành công");
        return "redirect:/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {
        Customer customer = customerService.findById(id);
        customerService.delete(id);
        model.addAttribute("customer", customer);
        redirectAttributes.addFlashAttribute("msg", "Xóa thành công");
        return "redirect:/list";
    }
}

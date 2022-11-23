package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
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
public class ProductController {
    @Autowired
    IProductService productService;

    @GetMapping("/list")
    public String showList(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/create")
    public String add(Product product, RedirectAttributes redirectAttributes) {
        product.setId((int) (Math.random() * 10000));
        productService.add(product);
        redirectAttributes.addFlashAttribute("msg", "Successfully added new");
        return "redirect:/list";
    }

    @GetMapping("/edit")
    public String showFormCreate(@RequestParam("id") Integer id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(Product product, RedirectAttributes redirectAttributes) {
        productService.edit(product);
        redirectAttributes.addFlashAttribute("msg", "Update successful");
        return "redirect:/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Integer id, RedirectAttributes redirectAttributes) {
        productService.delete(id);
        redirectAttributes.addFlashAttribute("msg", "Delete successfully");
        return "redirect:/list";
    }

    @GetMapping("/view")
    public String view(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "view";
    }

    @GetMapping("/search")
    public String search(@RequestParam String name, Model model) {
        model.addAttribute("products",productService.search(name));
        return "list";
    }
}

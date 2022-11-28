package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    ICategoryService categoryService;

    @GetMapping("/list")
    public String list(Model model) {
        List<Blog> blogs = blogService.findAll();
        model.addAttribute("blog", blogs);
        return "list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categorys", categories);
        model.addAttribute("category", new Category());
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping("/create")
    public String create(Blog blog, RedirectAttributes redirectAttributes) {
        blog.setId((int) (Math.random() * 10000));
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("msg", "Successfully added new");
        return "redirect:/list";
    }

    @GetMapping("/edit")
    public String showFormEdit(@RequestParam("id") int id, Model model) {
        Optional<Blog> blogs = blogService.findById(id);
        model.addAttribute("blog", blogs);
        return "edit";
    }

    @PostMapping("edit")
    public String edit(Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("msg", "Update successful");
        return "redirect:/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id, RedirectAttributes redirectAttributes) {
        blogService.remove(id);
        redirectAttributes.addFlashAttribute("msg", "Delete successfully");
        return "redirect:/list";
    }

    @GetMapping("/view")
    public String view(@RequestParam("id") int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "view";
    }
}

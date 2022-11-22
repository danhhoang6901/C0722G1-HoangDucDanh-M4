package com.codegym.controller;

import com.codegym.model.ConfiguringEmail;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
public class MailController {
    @GetMapping("/update")
    public String showForm(Model model) {
        model.addAttribute("configuringEmail", new ConfiguringEmail());
        List<String> languge = Arrays.asList("English", "Vietnamese", "Japanese", "Chinese");
        List<Integer> pageSize = Arrays.asList(5, 10, 15, 25, 50, 100);
        List<String> spamsFillter = Arrays.asList("Enable spams fillter");
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("languge", languge);
        model.addAttribute("spamsFillter", spamsFillter);
        return "update";
    }

    @PostMapping("/update")
    public String submit(@ModelAttribute("configuringEmail") ConfiguringEmail configuringEmail, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("msg","Cập nhật thành công");
        return "info";
    }
//    @Autowired
//    IConfiguringEmailService configuringEmailService;
//
//    @GetMapping("/list")
//    public String showConfiguringEmail(Model model) {
//        List<ConfiguringEmail> configuringEmail = configuringEmailService.findAll();
//        model.addAttribute("configuringEmail", configuringEmail);
//        return "list";
//    }
//
//    @GetMapping("/update/{id}")
//    public String showUpdate(@PathVariable("id") Integer id, Model model) {
//        ConfiguringEmail configuringEmail = configuringEmailService.findById(id);
//        List<String> languge = Arrays.asList("English", "Vietnamese", "Japanese", "Chinese");
//        List<Integer> pageSize = Arrays.asList(5, 10, 15, 25, 50, 100);
//        model.addAttribute("configuringEmail", configuringEmail);
//        model.addAttribute("pageSize", pageSize);
//        model.addAttribute("languge", languge);
//        return "update";
//    }
//
//    @PostMapping("/update")
//    public String update(ConfiguringEmail configuringEmail, RedirectAttributes redirectAttributes) {
//        configuringEmailService.update(configuringEmail);
//        redirectAttributes.addFlashAttribute("msg", "Cập nhật thành công");
//        return "redirect:/list";
//    }
}

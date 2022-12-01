package com.codegym.controller;

import com.codegym.model.User;
import com.codegym.model.UserDTO;
import com.codegym.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/list")
    public String showList(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "list";
    }

    @GetMapping("/create")
    public String formCreate(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        model.addAttribute("users", new User());
        return "create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute("userDTO") UserDTO userDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new UserDTO().validate(userDTO, bindingResult);
        if (bindingResult.hasErrors()) {

            return "create";
        } else {
            User user1 = new User();
            BeanUtils.copyProperties(userDTO, user1);
            userService.save(user1);
            redirectAttributes.addFlashAttribute("msg", "Successfully added new");
            return "redirect:/list";
        }
    }
}

package com.codegym.controller;

import com.codegym.service.ICaculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/caculate")
public class CaculateController {
    @Autowired
    ICaculateService caculateService;

    @GetMapping
    public String caculateForm(){
        return "caculate";
    }

    @PostMapping
    public String caculate(Model model, int usd) {
        int result = caculateService.caculate(usd);
        model.addAttribute("usd", usd);
        model.addAttribute("result", result);
        return "caculate";
    }
}

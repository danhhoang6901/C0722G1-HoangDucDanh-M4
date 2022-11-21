package com.codegym.controller;

import com.codegym.service.ICaculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaculatorController {
    @Autowired
    ICaculatorService caculatorService;

    @GetMapping("/caculator")
    public String formCaculator() {
        return "caculator";
    }

    @PostMapping("/caculator")
    public String caculator(@RequestParam("numberOne") double numberOne,
                            @RequestParam("numberTwo") double numberTwo,
                            @RequestParam("submit") String submit,
                            Model model) {
        double result = caculatorService.caculator(numberOne, numberTwo, submit);
        model.addAttribute("numberOne",numberOne);
        model.addAttribute("numberTwo",numberTwo);
        model.addAttribute("submit",submit);
        model.addAttribute("result", result);
        return "caculator";
    }
}

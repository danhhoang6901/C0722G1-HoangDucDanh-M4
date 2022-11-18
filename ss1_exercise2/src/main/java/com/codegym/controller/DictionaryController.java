package com.codegym.controller;

import com.codegym.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/dictionary")
public class DictionaryController {

    @Autowired
    IDictionaryService dictionaryService;

    @GetMapping
    public String dictionaryForm() {
        return "dictionary";
    }

    @PostMapping
    public String dictionary(Model model, String word) {
        Map<String, String> translate = dictionaryService.translate();
        model.addAttribute("word", word);
        model.addAttribute("transalte", translate);
        return "dictionary";
    }
}

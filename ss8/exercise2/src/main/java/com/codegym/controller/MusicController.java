package com.codegym.controller;

import com.codegym.model.Music;
import com.codegym.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class MusicController {
    @Autowired
    private IMusicService musicService;

    @GetMapping("/list")
    public String showList(Model model) {
        List<Music> music = musicService.findAll();
        model.addAttribute("music", music);
        return "list";
    }

    @GetMapping("/create")
    public String formCreate(Model model) {
        model.addAttribute("music", new Music());
        return "create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute("music") Music music, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new Music().validate(music, bindingResult);
        if (bindingResult.hasErrors()) {
            return "create";
        }
        musicService.save(music);
        redirectAttributes.addFlashAttribute("msg", "Successfully added new");
        return "redirect:/list";
    }

    @GetMapping("/edit")
    public String showFormEdit(@RequestParam("id") int id, Model model) {
        Optional<Music> music = musicService.findById(id);
        model.addAttribute("music", music);
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@Validated @ModelAttribute("music") Music music,BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new Music().validate(music, bindingResult);
        if (bindingResult.hasErrors()) {
            return "edit";
        }

        musicService.save(music);
        redirectAttributes.addFlashAttribute("msg", "Update successful");
        return "redirect:/list";
    }
}

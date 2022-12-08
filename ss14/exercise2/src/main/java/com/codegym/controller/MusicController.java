package com.codegym.controller;

import com.codegym.model.Music;
import com.codegym.model.MusicDTO;
import com.codegym.service.IMusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MusicController {
    @Autowired
    private IMusicService musicService;

    @GetMapping("/")
    public String showList(@PageableDefault(page = 0, size = 2) Pageable pageable, Model model) {
        Page<Music> music = musicService.findAll(pageable);
        model.addAttribute("music", music);
        return "list";
    }

    @GetMapping("/create")
    public String formCreate(Model model) {
        model.addAttribute("musicDTO", new MusicDTO());
        model.addAttribute("music", new Music());
        return "create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute("musicDTO") MusicDTO musicDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new MusicDTO().validate(musicDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "create";
        } else {
            Music music = new Music();
            BeanUtils.copyProperties(musicDTO, music);
            musicService.save(music);
            redirectAttributes.addFlashAttribute("msg", "Successfully added new");
            return "redirect:/list";
        }

    }

    @GetMapping("{id}/edit")
    public String showFormEdit(@PathVariable("id") int id, Model model) {
        Music music = musicService.findById(id);
        MusicDTO musicDTO = new MusicDTO();
        BeanUtils.copyProperties(music, musicDTO);
        model.addAttribute("musicDTO", musicDTO);
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@Validated @ModelAttribute("musicDTO") MusicDTO musicDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new MusicDTO().validate(musicDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "edit";
        } else {
            Music music = new Music();
            BeanUtils.copyProperties(musicDTO, music);
            musicService.save(music);
            redirectAttributes.addFlashAttribute("msg", "Update successful");
            return "redirect:/list";
        }
    }

    @PostMapping("{id}/delete")
    public String delete(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        musicService.remove(id);
        redirectAttributes.addFlashAttribute("msg", "Delete successfully");
        return "redirect:/";
    }
}

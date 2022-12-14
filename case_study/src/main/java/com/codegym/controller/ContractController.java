package com.codegym.controller;

import com.codegym.dto.contract.ContractDto;
import com.codegym.dto.contract.IContractDto;
import com.codegym.model.contract.Contract;
import com.codegym.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService contractService;

    @GetMapping("/list")
    public String listContract(@PageableDefault(page = 0, size = 4) Pageable pageable, Model model) {
        Page<IContractDto> contractDtos = contractService.findAll(pageable);
        model.addAttribute("contractList", contractDtos);
        return "/contract/list";
    }

    @GetMapping("/create")
    public String formCreateContract() {
        return "redirect:/contract/list";
    }

    @PostMapping("/create")
    public String createContract(@ModelAttribute("contract")Contract contract, Model model, RedirectAttributes redirectAttributes){
        model.addAttribute("contract",)
    }

}

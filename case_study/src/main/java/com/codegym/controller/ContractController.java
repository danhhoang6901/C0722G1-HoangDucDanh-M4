package com.codegym.controller;

import com.codegym.dto.contract.ContractDetailDto;
import com.codegym.dto.contract.ContractDto;
import com.codegym.dto.contract.IContractDto;
import com.codegym.model.contract.Contract;
import com.codegym.service.IContractDetailService;
import com.codegym.service.IContractService;
import com.codegym.service.ICustomerService;
import com.codegym.service.IFacilityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService contractService;

    @Autowired
    private IContractDetailService contractDetailService;

    @Autowired
    private IFacilityService facilityService;

    @Autowired
    private ICustomerService customerService;

    @GetMapping("/list")
    public String listContract(@PageableDefault(page = 0, size = 4) Pageable pageable, Model model) {
        Page<IContractDto> contractDtos = contractService.findAll(pageable);
        model.addAttribute("contractList", contractDtos);
        model.addAttribute("attachFacility", contractService.findAttachFacility());
        model.addAttribute("contractDetail",contractDetailService.findAll());
        model.addAttribute("customer", customerService.findAll());
        model.addAttribute("facility",facilityService.findAll());
        model.addAttribute("contractDto", new ContractDto());
        model.addAttribute("contractDetailDto", new ContractDetailDto());
        return "/contract/list";
    }

    @GetMapping("/create")
    public String formCreateContract(Model model) {
        model.addAttribute("contract", new Contract());
        model.addAttribute("attachtFacility", contractService.findAttachFacility());
        model.addAttribute("contractDetail", contractDetailService.findAll());
        model.addAttribute("facility", facilityService.findAll());
        model.addAttribute("customer", customerService.findAll());
        model.addAttribute("contractDto", new ContractDto());
        return "redirect:/contract/list";
    }

    @PostMapping("/create")
    public String createContract(@ModelAttribute("contractDto") ContractDto contractDto, RedirectAttributes redirectAttributes) {
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto, contract);
        contractService.save(contract);
        redirectAttributes.addFlashAttribute("msg", "Successfully added new");
        return "redirect:/contract/list";
    }

}

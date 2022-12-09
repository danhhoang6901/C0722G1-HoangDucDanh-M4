package com.codegym.controller;

import com.codegym.model.facility.Facility;
import com.codegym.service.IFacilityService;
import com.codegym.service.IFacilityTypeService;
import com.codegym.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    private IFacilityService facilityService;

    @Autowired
    private IFacilityTypeService facilityTypeService;

    @Autowired
    private IRentTypeService rentTypeService;

    @GetMapping("/list")
    public String listFacilty(@PageableDefault(page = 0, size = 3) Pageable pageable, Model model) {
        Page<Facility> facilities = facilityService.findAll(pageable);
        model.addAttribute("facilities", facilities);
        return "facility/list";
    }
}

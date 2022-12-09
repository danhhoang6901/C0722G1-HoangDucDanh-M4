package com.codegym.service.impl;

import com.codegym.repository.IFacilityTypeRepository;
import com.codegym.service.IFacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacilityTypeService implements IFacilityTypeService {
    @Autowired
    private IFacilityTypeRepository facilityTypeRepository;
}

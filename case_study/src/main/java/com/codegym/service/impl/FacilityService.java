package com.codegym.service.impl;

import com.codegym.model.facility.Facility;
import com.codegym.repository.IFacilityRepository;
import com.codegym.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private IFacilityRepository facilityRepository;

    @Override
    public Page<Facility> findAll(Pageable pageable) {
        return facilityRepository.findAll(pageable);
    }

    @Override
    public Page<Facility> findByNameAndFacilityType(Pageable pageable, String name, String facilityType) {
        return facilityRepository.findByNameAndFacilityType(pageable, name, facilityType);
    }

    @Override
    public void delete(int id) {
        facilityRepository.deleteById(id);
    }

    @Override
    public void save(Facility facility) {
        facilityRepository.save(facility);  
    }
}

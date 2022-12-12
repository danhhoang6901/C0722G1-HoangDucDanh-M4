package com.codegym.service;

import com.codegym.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFacilityService {
    Page<Facility> findAll(Pageable pageable);

    Page<Facility> findByNameAndFacilityType(Pageable pageable, String name, String facilityType);

    void delete(int id);

    void save(Facility facility);
}


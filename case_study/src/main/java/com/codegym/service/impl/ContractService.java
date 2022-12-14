package com.codegym.service.impl;

import com.codegym.dto.contract.IContractDto;
import com.codegym.model.contract.AttachFacility;
import com.codegym.model.contract.Contract;
import com.codegym.repository.IAttachFacilityRepository;
import com.codegym.repository.IContractRepository;
import com.codegym.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository contractRepository;

    @Autowired
    private IAttachFacilityRepository attachFacilityRepository;

    @Override
    public Page<IContractDto> findAll(Pageable pageable) {
        return contractRepository.getList(pageable);
    }

    @Override
    public List<AttachFacility> findAttachFacility() {
        return attachFacilityRepository.findAll();
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }
}

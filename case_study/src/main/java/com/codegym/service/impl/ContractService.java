package com.codegym.service.impl;

import com.codegym.dto.contract.IContractDto;
import com.codegym.model.contract.Contract;
import com.codegym.repository.IContractRepository;
import com.codegym.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository contractRepository;

    @Override
    public Page<IContractDto> findAll(Pageable pageable) {
        return contractRepository.getList(pageable);
    }
}

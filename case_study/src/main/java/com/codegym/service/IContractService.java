package com.codegym.service;

import com.codegym.dto.contract.IContractDto;
import com.codegym.model.contract.AttachFacility;
import com.codegym.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
    Page<IContractDto> findAll(Pageable pageable);

    List<AttachFacility> findAttachFacility();

    void save(Contract contract);
}

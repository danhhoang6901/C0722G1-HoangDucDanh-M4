package com.codegym.service.impl;

import com.codegym.model.ConfiguringEmail;
import com.codegym.repository.IConfiguringEmailRepository;
import com.codegym.service.IConfiguringEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfiguringEmailService implements IConfiguringEmailService {
    @Autowired
    IConfiguringEmailRepository configuringEmailRepository;

    @Override
    public List<ConfiguringEmail> findAll() {
        return configuringEmailRepository.findAll();
    }

    @Override
    public ConfiguringEmail findById(Integer id) {
        return configuringEmailRepository.findById(id);
    }

    @Override
    public void update(ConfiguringEmail configuringEmail) {
        configuringEmailRepository.update(configuringEmail);
    }
}

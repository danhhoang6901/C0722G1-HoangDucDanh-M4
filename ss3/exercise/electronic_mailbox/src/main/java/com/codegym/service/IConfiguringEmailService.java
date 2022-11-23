package com.codegym.service;

import com.codegym.model.ConfiguringEmail;

import java.util.List;

public interface IConfiguringEmailService {
    List<ConfiguringEmail> findAll();

    ConfiguringEmail findById(Integer id);

    void update(ConfiguringEmail configuringEmail);
}

package com.codegym.repository;

import com.codegym.model.ConfiguringEmail;

import java.util.List;

public interface IConfiguringEmailRepository {
    List<ConfiguringEmail> findAll();

    ConfiguringEmail findById(Integer id);

    void update(ConfiguringEmail configuringEmail);
}

package com.codegym.repository.impl;

import com.codegym.model.ConfiguringEmail;
import com.codegym.repository.IConfiguringEmailRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ConfiguringEmailRepository implements IConfiguringEmailRepository {
    private static List<ConfiguringEmail> configuringEmails = new ArrayList<>();

    static {
        configuringEmails.add(new ConfiguringEmail(1, "Vietnamese", 25, "Enable spams fillter", "danh"));
    }

    @Override
    public List<ConfiguringEmail> findAll() {
        return configuringEmails;
    }

    @Override
    public ConfiguringEmail findById(Integer id) {
        return configuringEmails.get(id - 1);
    }

    @Override
    public void update(ConfiguringEmail configuringEmail) {
        int index = findIndexById(configuringEmail.getId());
        configuringEmails.set(index, configuringEmail);
    }

    private int findIndexById(int id) {
        for (int i = 0; i < configuringEmails.size(); i++) {
            if (configuringEmails.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
}

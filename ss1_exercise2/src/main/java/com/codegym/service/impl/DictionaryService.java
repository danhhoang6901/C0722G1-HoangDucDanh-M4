package com.codegym.service.impl;

import com.codegym.service.IDictionaryService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class DictionaryService implements IDictionaryService {

    @Override
    public Map<String, String> translate() {
        Map<String, String> translate = new LinkedHashMap<>();
        translate.put("danh","vip");
        translate.put("vinh","gà");
        translate.put("hoang","chê");
        return translate;
    }
}

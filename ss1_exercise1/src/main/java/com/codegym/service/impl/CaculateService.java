package com.codegym.service.impl;

import com.codegym.service.ICaculateService;
import org.springframework.stereotype.Service;

@Service
public class CaculateService implements ICaculateService {
    @Override
    public int caculate(int usd) {
        return usd * 23000;
    }
}

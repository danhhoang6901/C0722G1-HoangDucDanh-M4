package com.codegym.service.impl;

import com.codegym.model.OrderBook;
import com.codegym.repository.IOrderRepository;
import com.codegym.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private IOrderRepository orderRepository;

    @Override
    public void save(OrderBook order) {

    }
}

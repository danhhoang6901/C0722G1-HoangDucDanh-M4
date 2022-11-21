package com.codegym.service;

import com.codegym.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> getAll();

    Customer findById(Integer id);

    void save(Customer customer);
}

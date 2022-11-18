package com.codegym.repository;

import com.codegym.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAll();

    void update(int id, Customer customer);

    Customer findById(int id);
}

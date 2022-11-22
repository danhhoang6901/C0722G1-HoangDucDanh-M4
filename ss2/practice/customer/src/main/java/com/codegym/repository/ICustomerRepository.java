package com.codegym.repository;

import com.codegym.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> getAll();

    Customer findById(Integer id);

    void save(Customer customer);

    void delete(Integer id);
}

package com.codegym.service;

import com.codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable);

    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(int id);

    void delete(int id);

    Page<Customer> findByBlogNameEmailAndCustomerTypeContaining(Pageable pageable, String name, String email, String customerType);
}

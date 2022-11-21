package com.codegym.repository.impl;

import com.codegym.model.Customer;
import com.codegym.repository.ICustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository implements ICustomerRepository {
    private static List<Customer> customers = new ArrayList<>();

    static {
        customers.add(new Customer(1, "Danh", "danhhoang@gmail.com", "Đà nẵng"));
        customers.add(new Customer(2, "Danh1", "danhhoang1@gmail.com", "Đà nẵng 1"));
        customers.add(new Customer(3, "Danh2", "danhhoang2@gmail.com", "Đà nẵng 2"));
    }

    @Override
    public List<Customer> getAll() {
        return customers;
    }

    @Override
    public Customer findById(Integer id) {
        return customers.get(id - 1);
    }

    @Override
    public void save(Customer customer) {
        customers.add(customer);
    }
}

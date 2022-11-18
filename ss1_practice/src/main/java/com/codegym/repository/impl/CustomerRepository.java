package com.codegym.repository.impl;

import com.codegym.model.Customer;
import com.codegym.repository.ICustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository implements ICustomerRepository {
    private static List<Customer> customerList = new ArrayList<>();

    static {
        customerList.add(new Customer(1, "Hoàng Đức Danh", "danhhoang@gmail.com", "Đà Nẵng"));
        customerList.add(new Customer(2, "Phạm Quang Vinh", "quangvinh@gmail.com", "Đà Nẵng"));
        customerList.add(new Customer(3, "Nguyễn Mậu Hoàng", "mauhoang@gmail.com", "Đà Nẵng"));
    }

    @Override
    public List<Customer> findAll() {
        return customerList;
    }


    @Override
    public Customer findById(int id) {
        return customerList.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customerList.set(id,customer);
    }
}

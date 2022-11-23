package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void add(Product product);

    Product findById(Integer id);

    void edit(Product product);

    void delete(int id);

    List<Product> search(String name);
}

package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void add(Product product);


    void edit(Product product);

    void delete(Integer id);

    Product findById(Integer id);

    List<Product> search(String name);
}

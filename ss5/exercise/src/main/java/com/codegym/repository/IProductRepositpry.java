package com.codegym.repository;

import com.codegym.model.Product;

import java.util.List;

public interface IProductRepositpry {
    List<Product> findAll();

    void add(Product product);

    void edit(Product product);

    void delete(Integer id);

    Product findById(Integer id);

    List<Product> search(String name);
}

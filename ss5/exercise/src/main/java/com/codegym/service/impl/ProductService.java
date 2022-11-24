package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepositpry;
import com.codegym.repository.impl.ConnectionUtil;
import com.codegym.service.IProductService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepositpry productRepositpry;

    @Override
    public List<Product> findAll() {
        return productRepositpry.findAll();
    }

    @Override
    public void add(Product product) {
        productRepositpry.add(product);
    }


    @Override
    public void edit(Product product) {
        productRepositpry.edit(product);
    }

    @Override
    public void delete(Integer id) {
        productRepositpry.delete(id);
    }

    @Override
    public Product findById(Integer id) {
        return productRepositpry.findById(id);
    }

    @Override
    public List<Product> search(String name) {
        return productRepositpry.search(name);
    }
}

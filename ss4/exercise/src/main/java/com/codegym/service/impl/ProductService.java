package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void add(Product product) {
        productRepository.add(product);
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public void edit(Product product) {
        productRepository.edit(product);
    }

    @Override
    public void delete(int id) {
        productRepository.delete(id);
    }

    @Override
    public List<Product> search(String name) {
        return productRepository.search(name);
    }


}

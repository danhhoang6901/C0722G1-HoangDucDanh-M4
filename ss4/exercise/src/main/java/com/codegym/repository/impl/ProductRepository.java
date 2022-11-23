package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "Điện thoại", 10000000, "Đẹp", "Apple"));
        products.add(new Product(2, "Điện thoại1", 20000000, "Đẹp hơn", "Apple"));
        products.add(new Product(3, "Điện thoại2", 30000000, "Đẹp hơn nữa", "Apple"));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public Product findById(Integer id) {
        return products.get(id - 1);
    }

    @Override
    public void edit(Product product) {
        int index = findIndexById(product.getId());
        products.set(index, product);
    }

    @Override
    public void delete(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> search(String name) {
        List<Product> products = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().contains(name)) {
                products.add(product);
            }
        }
        return products;
    }


    private int findIndexById(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }


}

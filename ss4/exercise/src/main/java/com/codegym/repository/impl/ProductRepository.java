package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private static List<Product> products = new ArrayList<>();



    @Override
    public List<Product> findAll() {
        Session session = null;
        List<Product> productList = null;
        try{
            session = ConnectionUtil.sessionFactory.openSession();
            productList = session.createQuery("from Product").getResultList();

        }finally {
            if (session != null){
                session.close();
            }
        }
        return productList;
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
        List<Product> products1 = findAll();
        for (Product product : products1) {
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

package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepositpry;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProducRepository implements IProductRepositpry {
    @Override
    public List<Product> findAll() {
        Session session = null;
        List<Product> products = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            products = session.createQuery("FROM Product ").getResultList();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return products;
    }

    @Override
    public void add(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void edit(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.merge(product);
            transaction.commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void delete(Integer id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            Product product = session.load(Product.class, id);
            session.delete(product);
            transaction.commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Product findById(Integer id) {
        Session session = null;
        Product product = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            product = (Product) session.createQuery("from Product where id = :idx").setParameter("idx", id).getSingleResult();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return product;
    }

    @Override
    public List<Product> search(String name) {
        Session session = null;
        List<Product> products = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            products = session.createQuery("from Product where name like:search").setParameter("search", '%' + name + '%').getResultList();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return products;
    }

}

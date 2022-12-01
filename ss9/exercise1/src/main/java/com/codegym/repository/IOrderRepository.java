package com.codegym.repository;

import com.codegym.model.OrderBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<OrderBook, Integer> {
}

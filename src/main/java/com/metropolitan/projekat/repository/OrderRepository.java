package com.metropolitan.projekat.repository;

import com.metropolitan.projekat.entiteti.Order;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAll();
    Order findById(long id);
    Order save(Order order);
    void deleteById(long id);
}

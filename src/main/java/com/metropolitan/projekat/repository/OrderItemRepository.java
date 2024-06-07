package com.metropolitan.projekat.repository;

import com.metropolitan.projekat.entiteti.OrderItem;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findAll();
    OrderItem findById(long id);
    OrderItem save(OrderItem orderItem);
    void deleteById(long id);
}

package com.metropolitan.projekat.service;


import com.metropolitan.projekat.entiteti.Order;

import java.util.List;

public interface OrderService {
    Order saveOrder(Order order);
    Order updateOrder(Order order);
    void deleteOrder(Long id);
    Order getOrderById(int id);
    List<Order> getAllOrders();
}

package com.metropolitan.projekat.service;


import com.metropolitan.projekat.entiteti.OrderItem;

import java.util.List;

public interface OrderItemService {
    OrderItem saveOrderItem(OrderItem orderItem);
    OrderItem updateOrderItem(OrderItem orderItem);
    void deleteOrderItem(Long id);
    OrderItem getOrderItemById(int id);
    List<OrderItem> getAllOrderItems();
}

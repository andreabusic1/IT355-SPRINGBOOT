package com.metropolitan.projekat;

import com.metropolitan.projekat.entiteti.Order;
import com.metropolitan.projekat.repository.OrderRepository;
import com.metropolitan.projekat.service.OrderService;
import com.metropolitan.projekat.service.serviceimpl.OrderServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class OrderServiceImplTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderServiceImpl orderService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveOrder() {
        Order order = new Order();
        when(orderRepository.save(order)).thenReturn(order);

        Order result = orderService.saveOrder(order);
        assertEquals(order, result);
    }

    @Test
    void testUpdateOrder() {
        Order order = new Order();
        when(orderRepository.save(order)).thenReturn(order);

        Order result = orderService.updateOrder(order);
        assertEquals(order, result);
    }

    @Test
    void testDeleteOrder() {
        Long id = 1L;
        doNothing().when(orderRepository).deleteById(id);

        orderService.deleteOrder(id);
        verify(orderRepository, times(1)).deleteById(id);
    }

    @Test
    void testGetOrderById() {
        int id = 1;
        Order order = new Order();
        when(orderRepository.findById(id)).thenReturn(order);

        Order result = orderService.getOrderById(id);
        assertEquals(order, result);
    }

    @Test
    void testGetAllOrders() {
        List<Order> orders = Arrays.asList(new Order(), new Order());
        when(orderRepository.findAll()).thenReturn(orders);

        List<Order> result = orderService.getAllOrders();
        assertEquals(orders, result);
    }
}

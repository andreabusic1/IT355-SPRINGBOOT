package com.metropolitan.projekat;

import com.metropolitan.projekat.entiteti.OrderItem;
import com.metropolitan.projekat.repository.OrderItemRepository;
import com.metropolitan.projekat.service.serviceimpl.OrderItemServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

class OrderItemServiceImplTest {

    @Mock
    private OrderItemRepository orderItemRepository;

    @InjectMocks
    private OrderItemServiceImpl orderItemService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveOrderItem() {
        OrderItem orderItem = new OrderItem();
        when(orderItemRepository.save(orderItem)).thenReturn(orderItem);

        OrderItem result = orderItemService.saveOrderItem(orderItem);
        assertEquals(orderItem, result);
    }

    @Test
    void testUpdateOrderItem() {
        OrderItem orderItem = new OrderItem();
        when(orderItemRepository.save(orderItem)).thenReturn(orderItem);

        OrderItem result = orderItemService.updateOrderItem(orderItem);
        assertEquals(orderItem, result);
    }

    @Test
    void testDeleteOrderItem() {
        Long id = 1L;
        doNothing().when(orderItemRepository).deleteById(id);

        orderItemService.deleteOrderItem(id);
        verify(orderItemRepository, times(1)).deleteById(id);
    }

    @Test
    void testGetOrderItemById() {
        int id = 1;
        OrderItem orderItem = new OrderItem();
        when(orderItemRepository.findById(id)).thenReturn(orderItem);

        OrderItem result = orderItemService.getOrderItemById(id);
        assertEquals(orderItem, result);
    }

    @Test
    void testGetAllOrderItems() {
        List<OrderItem> orderItems = Arrays.asList(new OrderItem(), new OrderItem());
        when(orderItemRepository.findAll()).thenReturn(orderItems);

        List<OrderItem> result = orderItemService.getAllOrderItems();
        assertEquals(orderItems, result);
    }
}

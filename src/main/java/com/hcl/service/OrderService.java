package com.hcl.service;

import com.hcl.model.Order;
import com.hcl.model.OrderItem;

import java.util.List;
import java.util.Set;

public interface OrderService {

    void insertOrder(Order order);
    void insertOrders(List<Order> order);
    List<Order> getAllOrders();
    Order getOrderById(Long orderId);
    void updateOrder(Order order);
    void deleteOrderById(long orderId);
    Order getActiveOrder(long userId);


}

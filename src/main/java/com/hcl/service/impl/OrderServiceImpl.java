package com.hcl.service.impl;

import com.hcl.dao.OrderDao;
import com.hcl.model.Order;
import com.hcl.model.OrderItem;
import com.hcl.service.OrderService;
import com.hcl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;

    @Autowired
    UserService userService;

    public void insertOrder(Order order){
        orderDao.insertOrder(order);
    }
    public void insertOrders(List<Order> orders){
        orderDao.insertOrders(orders);
    }
    public List<Order> getAllOrders(){
        return orderDao.getAllOrders();
    }
    public Order getOrderById(Long orderId){
        return orderDao.getOrderById(orderId);
    }
    public void updateOrder(Order order){
        orderDao.updateOrder(order);
    }
    public void deleteOrderById(long orderId){
        orderDao.deleteOrderById(orderId);
    }
    public Order getActiveOrder(long userId) {
        Order order = orderDao.getOrderByStatusAndUserId("ACTIVE", userId);
        if(order == null){
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            order = new Order("ACTIVE",userService.getUserByUsername(auth.getName()));
            orderDao.insertOrder(order);
        }
        return order;
    }
}

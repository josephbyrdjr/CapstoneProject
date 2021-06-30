package com.hcl.repository;

import com.hcl.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findOrderByStatusAndUserId(String status, Long userId);
}

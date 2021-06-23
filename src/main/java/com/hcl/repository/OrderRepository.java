package com.hcl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.model.Order;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query(value = "select * from orders where user_id = ?1", nativeQuery = true)
    List<Order> findOrdersByUserId(long id);

    @Query(value = "select * from orders where user_id = ?1 and item_id = ?2", nativeQuery = true)
    Order findOrdersByUserIdAndItemId(long userId, long itemId);
}

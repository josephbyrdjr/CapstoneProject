package com.hcl.repository;

import com.hcl.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
    List<OrderItem> findAllByOrderId(long orderId);
    OrderItem findOrderItemByOrderIdAndItemId(long orderId, long ItemId);
}

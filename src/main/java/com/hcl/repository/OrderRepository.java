package com.hcl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}

package com.hcl.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.hcl.model.Order;
import org.springframework.boot.test.context.SpringBootTest;

import com.hcl.dao.OrderDao;
import com.hcl.model.User;
import com.hcl.model.Item;
import com.hcl.model.Order;
import com.hcl.service.impl.OrderServiceImpl;
import com.hcl.service.impl.OrderServiceImpl;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

@SpringBootTest
public class OrderServiceTest {
	@InjectMocks
	OrderServiceImpl orderService;

	@Mock
    OrderDao dao;

	@Test
	public void testAutowired() {
		assertNotNull(orderService);
	}

	@Test
	public void testInsertOrder() {
		Item item = new Item();
		User user = new User();
		Order Order = new Order("Test", user);
		orderService.insertOrder(Order);
		verify(dao, times(1)).insertOrder(Order);
	}

	@Test
	public void testInsertOrders() {
		Item item = new Item();
		User user = new User();
		Order Order1 = new Order("Test1", user);
		Order Order2 = new Order("Test2", user);
		Order Order3 = new Order("Test3", user);
		List Orders = new ArrayList();
		Orders.add(Order1);
		Orders.add(Order2);
		Orders.add(Order3);
		orderService.insertOrders(Orders);
		verify(dao, times(1)).insertOrders(Orders);
	}

	@Test
	public void testGetAllOrders() {
		List<Order> list = new ArrayList<Order>();
		Item item = new Item();
		User user = new User();
		Order Order1 = new Order("Test1", user);
		Order Order2 = new Order("Test2", user);
		Order Order3 = new Order("Test3", user);
		list.add(Order1);
		list.add(Order2);
		list.add(Order3);

		when(dao.getAllOrders()).thenReturn(list);

		List<Order> OrderList = orderService.getAllOrders();

		assertEquals(3, OrderList.size());
		verify(dao, times(1)).getAllOrders();
	}

	@Test
	public void testGetOrderById() {
		Item item = new Item();
		User user = new User();
		when(dao.getOrderById(1L)).thenReturn(new Order("Test", user));
		Order Order = orderService.getOrderById(1L);

		assertEquals("Test", Order.getStatus());
	}

	@Test
	public void testUpdateOrder() {
		Item item = new Item();
		User user = new User();
		Order Order = new Order("Test1", user);
		Order.setStatus("Test2");
		orderService.updateOrder(Order);
		assertEquals("Test2", Order.getStatus());
		verify(dao, times(1)).updateOrder(Order);
	}

	@Test
	public void testDeleteOrderById() {
		Item item = new Item();
		User user = new User();
		when(dao.getOrderById(1L)).thenReturn(new Order("Test1", user));
		Order Order = orderService.getOrderById(1L);
		orderService.deleteOrderById(1L);
		verify(dao, times(1)).deleteOrderById(1L);
	}
	
	@Test
	public void testGetActiveOrder() {
		User user = new User();
		when(dao.getOrderByStatusAndUserId("ACTIVE", 1)).thenReturn(new Order("Test", user));
		Order order = orderService.getActiveOrder(1);
		verify(dao, times(1)).getOrderByStatusAndUserId("ACTIVE", 1);
	}

}

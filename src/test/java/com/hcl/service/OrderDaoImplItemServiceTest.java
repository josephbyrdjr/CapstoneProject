package com.hcl.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.hcl.model.OrderItem;
import org.springframework.boot.test.context.SpringBootTest;

import com.hcl.dao.OrderItemDao;
import com.hcl.model.User;
import com.hcl.model.Item;
import com.hcl.model.Order;
import com.hcl.service.impl.OrderItemServiceImpl;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

@SpringBootTest
public class OrderDaoImplItemServiceTest {

	@InjectMocks
	OrderItemServiceImpl orderItemService;

	@Mock
    OrderItemDao dao;

	@Test
	public void testAutowired() {
		assertNotNull(orderItemService);
	}

	@Test
	public void testInsertOrderItem() {
		Item item = new Item();
		Order order = new Order();
		OrderItem OrderItem = new OrderItem(1,1, item, order);
		orderItemService.insertOrderItem(OrderItem);
		verify(dao, times(1)).insertOrderItem(OrderItem);
	}

	@Test
	public void testInsertOrderItems() {
		Item item = new Item();
		Order order = new Order();
		OrderItem orderItem1 = new OrderItem(1,1, item, order);
		OrderItem orderItem2 = new OrderItem(2,2, item, order);
		OrderItem orderItem3 = new OrderItem(3,3, item, order);
		List Orders = new ArrayList();
		Orders.add(orderItem1);
		Orders.add(orderItem2);
		Orders.add(orderItem3);
		orderItemService.insertOrderItems(Orders);
		verify(dao, times(1)).insertOrderItems(Orders);
	}

	@Test
	public void testGetAllOrdersItems() {
		Set<OrderItem> list = new HashSet<OrderItem>();
		Item item = new Item();
		Order order = new Order();
		OrderItem orderItem1 = new OrderItem(1,1, item, order);
		OrderItem orderItem2 = new OrderItem(2,2, item, order);
		OrderItem orderItem3 = new OrderItem(3,3, item, order);
		list.add(orderItem1);
		list.add(orderItem2);
		list.add(orderItem3);

		when(dao.getAllOrderItems()).thenReturn(list);

		Set<OrderItem> orderItemList = orderItemService.getAllOrdersItems();

		assertEquals(3, orderItemList.size());
		verify(dao, times(1)).getAllOrderItems();
	}

	@Test
	public void testGetOrderItemById() {
		Item item = new Item();
		Order order = new Order();
		when(dao.getOrderItemById(1L)).thenReturn(new OrderItem(1,1, item, order));
		OrderItem OrderItem = orderItemService.getOrderItemById(1L);

		assertEquals(1, OrderItem.getId());
	}

	@Test
	public void testUpdateOrderItem() {
		Item item = new Item();
		Order order = new Order();
		OrderItem OrderItem = new OrderItem(1,1, item, order);
		OrderItem.setQuantity(5);
		orderItemService.updateOrderItem(OrderItem);
		assertEquals(5, OrderItem.getQuantity());
		verify(dao, times(1)).updateOrderItem(OrderItem);
	}

	@Test
	public void testDeleteOrderItemById() {
		Item item = new Item();
		Order order = new Order();
		when(dao.getOrderItemById(1L)).thenReturn(new OrderItem(1,1, item, order));
		OrderItem OrderItem = orderItemService.getOrderItemById(1L);
		orderItemService.deleteOrderItemById(1L);
		verify(dao, times(1)).deleteOrderItemById(1L);
	}

	@Test
	public void testGetOrderItemByOrderIdAndItemId() {
		Item item = new Item();
		Order order = new Order();
		when(dao.getOrderItemByOrderIdAndItemId(1, 1)).thenReturn(new OrderItem(1,1, item, order));
		OrderItem OrderItem = orderItemService.getOrderItemByOrderIdAndItemId(1, 1);
		assertEquals(1, OrderItem.getId());
		verify(dao, times(1)).getOrderItemByOrderIdAndItemId(1, 1);
	}
}
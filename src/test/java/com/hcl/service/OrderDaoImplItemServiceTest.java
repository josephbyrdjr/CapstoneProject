package com.hcl.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.hcl.model.OrderItem;
import org.springframework.boot.test.context.SpringBootTest;

import com.hcl.dao.OrderItemDao;
import com.hcl.model.User;
import com.hcl.model.Item;
import com.hcl.service.impl.OrderItemServiceImpl;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

@SpringBootTest
public class OrderDaoImplItemServiceTest {
//
//	@InjectMocks
//	OrderItemServiceImpl OrderItemService;
//
//	@Mock
//    OrderItemDao dao;
//
//	@Test
//	public void testAutowired() {
//		assertNotNull(OrderService);
//	}
//
//	@Test
//	public void testInsertOrder() {
//		Item item = new Item();
//		User user = new User();
//		OrderItem OrderItem = new OrderItem(1L, 1, "Test", item, user);
//		OrderItemService.insertOrderItem(OrderItem);
//		verify(dao, times(1)).insertOrderItem(OrderItem);
//	}
//
//	@Test
//	public void testInsertOrders() {
//		Item item = new Item();
//		User user = new User();
//		OrderItem orderItem1 = new OrderItem(1L, 1, "Test1", item, user);
//		OrderItem orderItem2 = new OrderItem(2L, 1, "Test2", item, user);
//		OrderItem orderItem3 = new OrderItem(3L, 1, "Test3", item, user);
//		List Orders = new ArrayList();
//		Orders.add(orderItem1);
//		Orders.add(orderItem2);
//		Orders.add(orderItem3);
//		OrderItemService.insertOrderItems(Orders);
//		verify(dao, times(1)).insertOrderItems(Orders);
//	}
//
//	@Test
//	public void testGetAllOrders() {
//		List<OrderItem> list = new ArrayList<OrderItem>();
//		Item item = new Item();
//		User user = new User();
//		OrderItem orderItem1 = new OrderItem(1L, 1, "Test1", item, user);
//		OrderItem orderItem2 = new OrderItem(2L, 1, "Test2", item, user);
//		OrderItem orderItem3 = new OrderItem(3L, 1, "Test3", item, user);
//		list.add(orderItem1);
//		list.add(orderItem2);
//		list.add(orderItem3);
//
//		when(dao.getAllOrderItems()).thenReturn(list);
//
//		List<OrderItem> orderItemList = OrderService.getAllOrdersItems();
//
//		assertEquals(3, orderItemList.size());
//		verify(dao, times(1)).getAllOrderItems();
//	}
//
//	@Test
//	public void testGetOrderById() {
//		Item item = new Item();
//		User user = new User();
//		when(dao.getOrderItemById(1L)).thenReturn(new OrderItem(1L, 1, "Test", item, user));
//		OrderItem OrderItem = OrderService.getOrderItemById(1L);
//
//		assertEquals("Test", OrderItem.getStatus());
//	}
//
//	@Test
//	public void testUpdateOrder() {
//		Item item = new Item();
//		User user = new User();
//		OrderItem OrderItem = new OrderItem(1, 1, "Test", item, user);
//		OrderItem.setStatus("Test2");
//		OrderService.updateOrderItem(OrderItem);
//		assertEquals("Test2", OrderItem.getStatus());
//		verify(dao, times(1)).updateOrderItem(OrderItem);
//	}
//
//	@Test
//	public void testDeleteOrderById() {
//		Item item = new Item();
//		User user = new User();
//		when(dao.getOrderItemById(1L)).thenReturn(new OrderItem(1, 1, "Test", item, user));
//		OrderItem OrderItem = OrderService.getOrderItemById(1L);
//		OrderService.deleteOrderItemById(1L);
//		verify(dao, times(1)).deleteOrderItemById(1L);
//	}
//
//	@Test
//	public void testGetOrdersByUserId() {
//		Item item = new Item();
//		User user = new User();
//		User user2 = new User();
//		user.setId(1L);
//		user2.setId(2L);
//		List<OrderItem> list = new ArrayList<OrderItem>();
//		OrderItem orderItem1 = new OrderItem(1L, 1, "Test1", item, user);
//		OrderItem orderItem2 = new OrderItem(2L, 1, "Test2", item, user);
//		OrderItem orderItem3 = new OrderItem(3L, 1, "Test3", item, user2);
//		list.add(orderItem1);
//		list.add(orderItem2);
//		list.add(orderItem3);
//		when(dao.getOrdersByUserId(1L)).thenReturn(Arrays.asList(orderItem1, orderItem2));
//		List<OrderItem> orderItemList = OrderService.getOrdersByUserId(1L);
//
//		assertEquals(2, orderItemList.size());
//		verify(dao, times(1)).getOrdersByUserId(1L);
//	}
//
//	@Test
//	public void testGetOrdersByUserIdAndItemId() {
//		Item item = new Item();
//		User user = new User();
//		item.setId(1L);
//		user.setId(1L);
//		when(dao.getOrdersByUserIdAndItemId(1L, 1L)).thenReturn(new OrderItem(1L, 1, "Test", item, user));
//		OrderItem OrderItem = OrderService.getOrdersByUserIdAndItemId(1L, 1L);
//
//		assertEquals("Test", OrderItem.getStatus());
//	}
}
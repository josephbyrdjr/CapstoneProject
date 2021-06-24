package com.hcl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

import com.hcl.dao.OrderDao;
import com.hcl.model.Order;
import com.hcl.model.User;
import com.hcl.model.Item;
import com.hcl.service.OrderService;
import com.hcl.service.impl.OrderServiceImpl;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

@SpringBootTest
public class OrderServiceTest {
	
	@InjectMocks
	OrderServiceImpl OrderService;
	
	@Mock
	OrderDao dao;
	
	@Test
	public void testAutowired() {
		assertNotNull(OrderService);
	}

	@Test
	public void testInsertOrder() {
		Item item = new Item();
		User user = new User();
		Order Order = new Order(1L, 1, "Test", item, user);
		OrderService.insertOrders(Order);
		verify(dao, times(1)).insertOrder(Order);
	}
	
	@Test
	public void testInsertOrders() {
		Item item = new Item();
		User user = new User();
		Order Order1 = new Order(1L, 1, "Test1", item, user);
		Order Order2 = new Order(2L, 1, "Test2", item, user);
		Order Order3 = new Order(3L, 1, "Test3", item, user);
		List Orders = new ArrayList();
		Orders.add(Order1);
		Orders.add(Order2);
		Orders.add(Order3);
		OrderService.insertOrders(Orders);
		verify(dao, times(1)).insertOrders(Orders);
	}
	
	@Test
	public void testGetAllOrders() {
		List<Order> list = new ArrayList<Order>();
		Item item = new Item();
		User user = new User();
		Order Order1 = new Order(1L, 1, "Test1", item, user);
		Order Order2 = new Order(2L, 1, "Test2", item, user);
		Order Order3 = new Order(3L, 1, "Test3", item, user);
		list.add(Order1);
		list.add(Order2);
		list.add(Order3);
		
		when(dao.getAllOrders()).thenReturn(list);
		
		List<Order> OrderList = OrderService.getAllOrders();
		
		assertEquals(3, OrderList.size());
		verify(dao, times(1)).getAllOrders();
	}
	
	@Test
	public void testGetOrderById() {
		Item item = new Item();
		User user = new User();
		when(dao.getOrderById(1L)).thenReturn(new Order(1L, 1, "Test", item, user));
		Order Order = OrderService.getOrderById(1L);
		
		assertEquals("Test", Order.getStatus());
	}
	
	@Test
	public void testUpdateOrder() {
		Item item = new Item();
		User user = new User();
		Order Order = new Order(1, 1, "Test", item, user);
		Order.setStatus("Test2");
		OrderService.updateOrder(Order);
		assertEquals("Test2", Order.getStatus());
		verify(dao, times(1)).updateOrder(Order);
	}
	
	@Test
	public void testDeleteOrderById() {
		Item item = new Item();
		User user = new User();
		when(dao.getOrderById(1L)).thenReturn(new Order(1, 1, "Test", item, user));
		Order Order = OrderService.getOrderById(1L);
		OrderService.deleteOrderById(1L);
		//assertEquals("NULL", Order.getOrdername());
		verify(dao, times(1)).deleteOrderById(1L);
	}
	
	//Not sure if this is correct, still needs some work...
	//Was returning 3 without the for loop for some reason
	//Will look into this more later
	@Test
	public void testGetOrdersByUserId() {
		Item item = new Item();
		User user = new User();
		User user2 = new User();
		user.setId(1L);
		user2.setId(2L);
		List<Order> list = new ArrayList<Order>();
		Order Order1 = new Order(1L, 1, "Test1", item, user);
		Order Order2 = new Order(2L, 1, "Test2", item, user);
		Order Order3 = new Order(3L, 1, "Test3", item, user2);
		list.add(Order1);
		list.add(Order2);
		list.add(Order3);
//		for(int i = 0; i < list.size(); i++) {
//			if(list.get(i).getUser().getId() != 1L) {
//				list.remove(i);
//			}
//		}
		when(dao.getOrdersByUserId(1L)).thenReturn(list);
		List<Order> OrderList = OrderService.getOrdersByUserId(1L);
		
		//Should only pull 2 of the Orders from "list" but pulls all 3 from some reason
		//Query wrong?
		assertEquals(2, OrderList.size());
		verify(dao, times(1)).getOrdersByUserId(1L);
	}
	
	//Fails but I am not sure why... Throws a NullPointerException
	@Test
	public void testGetOrdersByUserIdAndItemId() {
		Item item = new Item();
		User user = new User();
		item.setId(1L);
		user.setId(1L);
		when(dao.getOrderById(1L)).thenReturn(new Order(1L, 1, "Test", item, user));
		Order Order = OrderService.getOrdersByUserIdAndItemId(1L, 1L);
		
		assertEquals("Test", Order.getStatus());
	}
}
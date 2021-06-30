package com.hcl.service;

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

import com.hcl.dao.UserDao;
import com.hcl.model.User;
import com.hcl.service.UserService;
import com.hcl.service.impl.UserServiceImpl;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

@SpringBootTest
public class UserServiceTest {
	
	@InjectMocks
	UserServiceImpl userService;
	
	@Mock
	UserDao dao;
	
	@Test
	public void testAutowired() {
		assertNotNull(userService);
	}

	@Test
	public void testInsertUser() {
		User user = new User(1, "UsernameTest", "FirstNameTest", "LastNameTest");
		userService.insertUser(user);
		verify(dao, times(1)).insertUser(user);
	}
	
	@Test
	public void testInsertUsers() {
		User user1 = new User(1, "UsernameTest1", "FirstNameTest1", "LastNameTest1");
		User user2 = new User(2, "UsernameTest2", "FirstNameTest2", "LastNameTest2");
		User user3 = new User(3, "UsernameTest3", "FirstNameTest3", "LastNameTest3");
		List users = new ArrayList();
		users.add(user1);
		users.add(user2);
		users.add(user3);
		userService.insertUsers(users);
		verify(dao, times(1)).insertUsers(users);
	}
	
	@Test
	public void testGetAllUsers() {
		List<User> list = new ArrayList<User>();
		User user1 = new User("Test1","root", true, "FirstNameTest1", "LastNameTest1","EmailTest1",
				"PhoneNumberTest1", "AddressTest1", "Apt#Test1", "CityTest1","StateTest1", "ZipcodeTest1");
		User user2 = new User("Test2","root", true, "FirstNameTest2", "LastNameTest2","EmailTest2",
				"PhoneNumberTest2", "AddressTest2", "Apt#Test2", "CityTest2","StateTest2", "ZipcodeTest2"); 
		User user3 = new User("Test3","root", true, "FirstNameTest3", "LastNameTest3","EmailTest3",
				"PhoneNumberTest3", "AddressTest3", "Apt#Test3", "CityTest3","StateTest3", "ZipcodeTest3");
		list.add(user1);
		list.add(user2);
		list.add(user3);
		
		when(dao.getAllUsers()).thenReturn(list);
		
		List<User> userList = userService.getAllUsers();
		
		assertEquals(3, userList.size());
		verify(dao, times(1)).getAllUsers();
	}
	
	@Test
	public void testGetUserById() {
		long id = 1;
		when(dao.getUserById(id)).thenReturn(new User(id, "UsernameTest", "FirstNameTest", "LastNameTest"));
		User user = userService.getUserById(id);
		
		assertEquals("UsernameTest", user.getUsername());
		assertEquals("FirstNameTest", user.getFirstName());
		assertEquals("LastNameTest", user.getLastName());
	}
	
	@Test
	public void testUpdateuser() {
		User user = new User(1, "UsernameTest", "FirstnameTest", "LastnameTest");
		user.setUsername("UsernameTest2");
		userService.updateUser(user);
		assertEquals("UsernameTest2", user.getUsername());
		verify(dao, times(1)).updateUser(user);
	}
	
	@Test
	public void testGetUserByusername() {
		when(dao.getUserByUsername("UsernameTest")).thenReturn(new User(1, "UsernameTest", "FirstNameTest", "LastNameTest"));
		User user = userService.getUserByUsername("UsernameTest");
		
		assertEquals(1, user.getId());
		assertEquals("FirstNameTest", user.getFirstName());
		assertEquals("LastNameTest", user.getLastName());
	}
	
	//Not finished
	@Test
	public void testDeleteUserById() {
		when(dao.getUserByUsername("UsernameTest")).thenReturn(new User(1, "UsernameTest", "FirstNameTest", "LastNameTest"));
		User user = userService.getUserByUsername("UsernameTest");
		userService.deleteUserById(1);
		//assertEquals("NULL", user.getUsername());
		verify(dao, times(1)).deleteUserById(1);
		
	}
}

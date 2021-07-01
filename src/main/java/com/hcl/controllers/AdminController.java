package com.hcl.controllers;

import com.hcl.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hcl.model.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	private static Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	UserService userService;

	@Autowired
	AuthService authService;
	
	@Autowired
    OrderItemService orderItemService;

	@Autowired
	OrderService orderService;

	@Autowired
	ItemService itemService;

	@GetMapping
	public String displayAdmin(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("user", userService.getUserByUsername(auth.getName())); 
        
		return "admin";
	}

	@GetMapping("/allUsers")
	public String displayAllUsers(Model model) {

		return "allUsers";
	}

	@GetMapping("/allOrders")
	public String displayAllOrders(Model model) {
		return "allOrders";
	}

	@GetMapping("/allItems")
	public String displayAllItems(Model model) {
		return "allItems";
	}

	@GetMapping("/editItem/{id}")
	public String displayEditItem(@PathVariable long id, Model model) {
		model.addAttribute("item", itemService.getItemById(id));
		return "editItem";
	}

	@PostMapping("/editItem/{id}")
	public String editItem(@PathVariable long id, @RequestParam double price, @RequestParam String name, @RequestParam String thumbnail,
			@RequestParam String category, @RequestParam String description, @RequestParam long inventoryLeft, Model model) {

		Item item = itemService.getItemById(id);
		item.setPrice(price);
		item.setName(name);
		item.setThumbnail(thumbnail);
		item.setCategory(category);
		item.setDescription(description);
		item.setInventoryLeft(inventoryLeft);
		itemService.updateItem(item);
		logger.info("Item edited successfully");
		return "allItems";
	}

	@GetMapping("/addItem")
	public String displayAddItem(Model model) {
		return "addItem";
	}

	@PostMapping("/addItem")
	public String addItem(@RequestParam double price, @RequestParam String name, @RequestParam String thumbnail,
			@RequestParam String category, @RequestParam String description, @RequestParam long inventoryLeft, Model model) {

		Item item = new Item(price, name, thumbnail, category, description, inventoryLeft);
		itemService.insertItem(item);
		model.addAttribute("msg", "New Item Added");
		logger.info("New item added");
		return "allItems";
	}
	
	@GetMapping("/editOrderById/{id}")
	public String displayEditOrder(@PathVariable long id, Model model) {
		System.out.println(orderItemService.getOrderItemById(id));
		model.addAttribute("order", orderService.getOrderById(id));
		return "editOrderById";
	}
	
	@PostMapping("editOrderById/{id}")
	public String editOrderById(@PathVariable long id, @RequestParam String status, Model model) {
		Order order = orderService.getOrderById(id);
		order.setStatus(status);
		orderService.updateOrder(order);
		logger.info("Order "+ order.getId()+" updated");
		return "allOrders";
	}
	
	@GetMapping("/editUserById/{id}")
	public String displayEditUser(@PathVariable long id, Model model) {
		model.addAttribute("user", userService.getUserById(id));
		return "editUserById";
	}

	@PostMapping("/editUserById/{id}")
	public String editUser(@PathVariable long id, @RequestParam String username, @RequestParam String pwd, @RequestParam String firstName,
			@RequestParam String lastName, @RequestParam String email, @RequestParam String phoneNumber,
			@RequestParam String address, @RequestParam String apartmentNumber, @RequestParam String city,
			@RequestParam String state, @RequestParam String zip, Model model) {

		BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
		
		User user = userService.getUserById(id); 
		user.setUsername(username);
		user.setPassword(bCrypt.encode(pwd));
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setPhoneNumber(phoneNumber);
		user.setAddress(address);
		user.setApartmentNumber(apartmentNumber);
		user.setCity(city);
		user.setState(state);
		user.setZip(zip);
		userService.updateUser(user);
		model.addAttribute("msg", "User updated");
		model.addAttribute("username", username);
		logger.info("User edited successfully");
		return "allUsers";
	}
	
	@PostMapping("/addAuth/{id}")
	public String addAuth(@PathVariable long id, Model model) {
		User user = userService.getUserById(id);
		Authority auth = authService.findById(2L);
		user.addAuth(auth);
		userService.updateUser(user);
		model.addAttribute("msg", "Admin Authority added to User");
		logger.info("User: "+user.getUsername()+" given Admin authority");
		return "allUsers";
	}
	
	@GetMapping("/deleteUser/{id}")
	public String deleteUserById(@PathVariable long id, Model model) {
		userService.deleteUserById(id);
		return "allUsers";
	}
	
	@GetMapping("/deleteOrder/{id}")
	public String deleteOrderById(@PathVariable long id, Model model) {
		Order order = orderService.getOrderById(id);
		order.getOrderItems().forEach(orderItem -> orderItemService.deleteOrderItemById(orderItem.getId()));
		orderService.deleteOrderById(id);
		return "allOrders";
	}
	
	@GetMapping("/deleteItem/{id}")
	public String deleteItemById(@PathVariable long id, Model model) {
		itemService.deleteItemById(id);
		return "allItems";
	}

}

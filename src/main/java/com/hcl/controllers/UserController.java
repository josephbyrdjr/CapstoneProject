package com.hcl.controllers;

import com.hcl.model.*;
import com.hcl.service.AuthService;
import com.hcl.service.OrderService;
import com.hcl.service.UserService;

import java.util.Set;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Controller
public class UserController {

	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	@Autowired
	AuthService authService;

	@Autowired
	OrderService orderService;

	@GetMapping("/")
	public String displayHome(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); // get logged in username
		model.addAttribute("username", name);
		if(name == "anonymousUser") {
			return "home";
		}
		Set<OrderItem> orderItems = new HashSet<>();
		User user = userService.getUserByUsername(auth.getName());
		orderItems = orderService.getActiveOrder(user.getId()).getOrderItems();

		int cartQuantity = 0;
		cartQuantity = orderItems.stream().map(OrderItem::getQuantity)
				.reduce(0, Integer::sum);
		model.addAttribute("cartQuantity", cartQuantity);

		return "home";
	}

	@GetMapping("/register")
	public String showRegisterForm(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); // get logged in username
		model.addAttribute("username", name);
		return "userRegistration";
	}

	@PostMapping("/register")
	public String grabDisplayData(@RequestParam String username, @RequestParam String pwd,
			@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email,
			@RequestParam String phoneNumber, @RequestParam String address, @RequestParam String apartmentNumber,
			@RequestParam String city, @RequestParam String state, @RequestParam String zip, Model model) {

		BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
		User user = new User(username, bCrypt.encode(pwd), true, firstName, lastName, email, phoneNumber, address,
				apartmentNumber, city, state, zip);

		Authority auth = authService.findById(1L);
		user.addAuth(auth);
		userService.insertUser(user);
		model.addAttribute("msg", "New User Added");
		logger.info("New User: " + user.getUsername() + " was added successfully");
		return "login";
	}

	@GetMapping(value = "/login")
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("errorMsg", "Your username and password are invalid.");
		if (logout != null)
			model.addAttribute("msg", "You have been logged out successfully.");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); // get logged in username
		model.addAttribute("username", name);
		return "login";
	}

	@GetMapping("/editUser")
	public String edit(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("user", userService.getUserByUsername(auth.getName()));
		return "editUser";
	}

	@PostMapping("/editUser")
	public String editUser(@RequestParam String username, @RequestParam String pwd, @RequestParam String firstName,
			@RequestParam String lastName, @RequestParam String email, @RequestParam String phoneNumber,
			@RequestParam String address, @RequestParam String apartmentNumber, @RequestParam String city,
			@RequestParam String state, @RequestParam String zip, Model model) {

		BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.getUserByUsername(auth.getName());
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
		logger.info("User: " + user.getUsername() + " was updated successfully");
		return "home";
	}

	@GetMapping("/about")
	public String displayAbout(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); // get logged in username
		model.addAttribute("username", name);
		if(name == "anonymousUser") {
			return "about";
		}

		Set<OrderItem> orderItems = new HashSet<>();
		User user = userService.getUserByUsername(auth.getName());
		orderItems = orderService.getActiveOrder(user.getId()).getOrderItems();

		int cartQuantity = 0;
		cartQuantity = orderItems.stream().map(OrderItem::getQuantity)
				.reduce(0, Integer::sum);
		model.addAttribute("cartQuantity", cartQuantity);
		return "about";
	}

}
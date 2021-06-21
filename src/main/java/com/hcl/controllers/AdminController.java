package com.hcl.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hcl.model.*;
import com.hcl.service.AuthService;
import com.hcl.service.ItemService;
import com.hcl.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	
	@Autowired
	UserService userService;
	
	@Autowired
	AuthService authService;
	
	@Autowired
	ItemService itemService;
	
	
	@GetMapping
	public String displayAdmin(Model model) {
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
		
		return "editItem";
	}
	
	@PutMapping("editItem")
	public String editItem(Model model) {
		
		
		return "allItems";
	}
	
	@PostMapping("/addItem")
	public String addItem(@RequestParam double price, @RequestParam String name,
						@RequestParam String thumbnail, @RequestParam String category,
						@RequestParam String description, Model model) {
		
		Item item = new Item(price,name,thumbnail,category,description);
		itemService.insertItem(item);
		model.addAttribute("msg", "New Item Added");
		
		
		return "allItems";
	}
	
	
}

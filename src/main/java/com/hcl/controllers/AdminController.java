package com.hcl.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	
	@GetMapping("/")
	public String displayAdmin(Model model) {
		return "admin";
	}
	
	
	@GetMapping("/editItem")
	public String displayEditItem(Model model) {
		
		return "editItem";
	}
	
	@PostMapping("/editItem")
	public String addItem(@RequestParam double price, @RequestParam String name,
						@RequestParam String thumbnail, @RequestParam String category,
						@RequestParam String description, Model model) {
		
		Item item = new Item(price,name,thumbnail,category,description);
		itemService.insertItem(item);
		model.addAttribute("msg", "New Item Added");
		
		return "editItem";
	}
	
	@GetMapping("/editOrder")
	public String displayEditOrder(Model model ) {
		
		return "editOrder";
	}
	
	@PutMapping("/editOrder")
	public String editOrder(@RequestParam int quantity) {
		return "editOrder";
	}
	
	
}

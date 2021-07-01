package com.hcl.controllers;


import com.hcl.model.OrderItem;
import com.hcl.model.User;
import com.hcl.service.ItemService;
import com.hcl.service.OrderItemService;
import com.hcl.service.OrderService;
import com.hcl.service.UserService;

import java.math.BigDecimal;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CartController {

    @Autowired
    ItemService itemService;

    @Autowired
    OrderItemService orderItemService;
    
    @Autowired
    UserService userService;

    @Autowired
	OrderService orderService;

    
    @RequestMapping("/orderItem/shoppingCart")
    public String displayCart(Model model) {

    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	String name = auth.getName(); // get logged in username
        model.addAttribute("username", name);
		Set<OrderItem> orderItems = new HashSet<>();
		User user = userService.getUserByUsername(auth.getName());
		orderItems = orderService.getActiveOrder(user.getId()).getOrderItems();
		model.addAttribute("orderItems", orderItems);
		
		double total = 0;
		int cartQuantity = 0;
		total = orderItems.stream()
				.map(orderItem -> orderItem.getItem().getPrice() * orderItem.getQuantity())
				.reduce(0.0, Double::sum);
		cartQuantity = orderItems.stream().map(OrderItem::getQuantity)
				.reduce(0, Integer::sum);
		BigDecimal tot = new BigDecimal(total).setScale(2, 1);
		model.addAttribute("total", tot);
		model.addAttribute("cartQuantity", cartQuantity);
    	
    	return "cart";
    }
    
    
    @GetMapping("/checkout")
    public String displayCheckout(Model model) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	User user = userService.getUserByUsername(auth.getName()); // get logged in user
    	Set<OrderItem> orders = orderService.getActiveOrder(user.getId()).getOrderItems();
    	System.out.println("order id : "+orders);
    	model.addAttribute("user", user);
    	model.addAttribute("orders", orders);
    	
    	return "checkout";
    }
    
    
    
   
    
   
    
    

}

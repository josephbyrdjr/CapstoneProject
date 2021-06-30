package com.hcl.controllers;

import com.hcl.controllers.rest.OrderRestController;
import com.hcl.model.Order;
import com.hcl.model.User;
import com.hcl.service.ItemService;
import com.hcl.service.OrderService;
import com.hcl.service.UserService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CartController {

    @Autowired
    ItemService itemService;

    @Autowired
    OrderService orderService;
    
    @Autowired
    UserService userService;

    
    @RequestMapping("/order/shoppingCart")
    public String displayCart(Model model) {

    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	String name = auth.getName(); // get logged in username
        model.addAttribute("username", name);
		List<Order> orders = new ArrayList<Order>();
		User user = userService.getUserByUsername(auth.getName());
		orders = orderService.getOrdersByUserId(user.getId());
		model.addAttribute("orders", orders);
		
		double total = 0;
		int cartQuantity = 0;
		for(int i = 0; i < orders.size(); i++) {
			total += orders.get(i).getQuantity() * orders.get(i).getItem().getPrice();
			cartQuantity += orders.get(i).getQuantity();
		}
		BigDecimal tot = new BigDecimal(total).setScale(2, 1);
		model.addAttribute("total", tot);
		model.addAttribute("cartQuantity", cartQuantity);
    	
    	return "cart";
    }
    
    
    @GetMapping("/checkout")
    public String displayCheckout(Model model) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	User user = userService.getUserByUsername(auth.getName()); // get logged in user
    	model.addAttribute("username", user.getUsername());
    	model.addAttribute("user", user);
    	
    	return "checkout";
    }
    
    
    
   
    
   
    
    

}

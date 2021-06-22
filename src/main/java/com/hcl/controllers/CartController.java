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

    
    @RequestMapping("order/shoppingCart")
    public String displayCart(Model model) {

    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		List<Order> orders = new ArrayList<Order>();
		orders = orderService.getOrdersByUserId(userService.getUserByUsername(auth.getName()).getId());
		model.addAttribute("orders", orders);
		
		double total = 0;
		for(int i = 0; i < orders.size(); i++) {
			total += orders.get(i).getQuantity() * orders.get(i).getItem().getPrice();
		}
		BigDecimal tot = new BigDecimal(total).setScale(2, 1);
		model.addAttribute("total", tot);
    	
    	return "cart";
    }
    
   
    
   
    
    

}

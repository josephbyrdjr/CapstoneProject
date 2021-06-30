package com.hcl.controllers;

import com.hcl.model.Order;
import com.hcl.model.User;
import com.hcl.service.ItemService;
import com.hcl.service.OrderService;
import com.hcl.service.UserService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CatalogController {

    @Autowired
    ItemService itemService;

    @Autowired
    OrderService orderService;
    
    @Autowired
    UserService userService;

    @GetMapping("/catalog")
    public String displayCatalog(Model model) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); // get logged in username
        model.addAttribute("username", name);
        if(name == "anonymousUser") {
			return "catalog";
		}
        
        List<Order> orders = new ArrayList<Order>();
		User user = userService.getUserByUsername(auth.getName());
		orders = orderService.getOrdersByUserId(user.getId());
		
		int cartQuantity = 0;
		for(int i = 0; i < orders.size(); i++) {
			cartQuantity += orders.get(i).getQuantity();
		}
		model.addAttribute("cartQuantity", cartQuantity);
        return "catalog";
    }
    
    @GetMapping("catalog/{id}")
    public String displayItem(@PathVariable long id, Model model) {

        model.addAttribute("item", itemService.getItemById(id));
    	
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); // get logged in username
        model.addAttribute("username", name);
        if(name == "anonymousUser") {
			return "item";
		}
        
        List<Order> orders = new ArrayList<Order>();
		User user = userService.getUserByUsername(auth.getName());
		orders = orderService.getOrdersByUserId(user.getId());
		
		int cartQuantity = 0;
		for(int i = 0; i < orders.size(); i++) {
			cartQuantity += orders.get(i).getQuantity();
		}
		model.addAttribute("cartQuantity", cartQuantity);
        
    	return "item";
    }
    
   
    
    

}

package com.hcl.controllers;

import com.hcl.model.OrderItem;
import com.hcl.model.User;
import com.hcl.service.ItemService;
import com.hcl.service.OrderItemService;
import com.hcl.service.OrderService;
import com.hcl.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashSet;
import java.util.Set;

@Controller
public class CatalogController {

    @Autowired
    ItemService itemService;

    @Autowired
    OrderItemService orderItemService;
    
    @Autowired
    UserService userService;

    @Autowired
    OrderService orderService;

    @GetMapping("/catalog")
    public String displayCatalog(Model model) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); // get logged in username
        model.addAttribute("username", name);
        if(name == "anonymousUser") {
			return "catalog";
		}

        Set<OrderItem> orderItems = new HashSet<>();
        User user = userService.getUserByUsername(auth.getName());
        orderItems = orderService.getActiveOrder(user.getId()).getOrderItems();

        int cartQuantity = 0;
        cartQuantity = orderItems.stream().map(OrderItem::getQuantity)
                .reduce(0, Integer::sum);
        model.addAttribute("cartQuantity", cartQuantity);
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

        Set<OrderItem> orderItems = new HashSet<>();
        User user = userService.getUserByUsername(auth.getName());
        orderItems = orderService.getActiveOrder(user.getId()).getOrderItems();

        int cartQuantity = 0;
        cartQuantity = orderItems.stream().map(OrderItem::getQuantity)
                .reduce(0, Integer::sum);
        model.addAttribute("cartQuantity", cartQuantity);
        
    	return "item";
    }
    
   
    
    

}

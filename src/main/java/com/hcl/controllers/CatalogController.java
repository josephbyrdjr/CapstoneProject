package com.hcl.controllers;

import com.hcl.model.User;
import com.hcl.service.ItemService;
import com.hcl.service.OrderService;
import com.hcl.service.UserService;

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

        return "catalog";
    }
    
    @GetMapping("catalog/{id}")
    public String displayItem(@PathVariable long id, Model model) {
    	
    		
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getUserByUsername(auth.getName());
        model.addAttribute("item", itemService.getItemById(id)); 
        model.addAttribute("userId", user.getId());
    	
    	return "item";
    }
    

}

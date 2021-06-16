package com.hcl.controllers;

import com.hcl.service.ItemService;
import com.hcl.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CatalogController {

    @Autowired
    ItemService itemService;

    @Autowired
    OrderService orderService;

    @GetMapping("/catalog")
    public String displayCatalog(Model model) {

        return "catalog";
    }

}

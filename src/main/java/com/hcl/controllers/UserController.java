package com.hcl.controllers;

//import com.hcl.model.Authorities;
import com.hcl.model.*;
import com.hcl.service.AuthService;
import com.hcl.service.UserService;

import java.util.Set;
import java.util.HashSet;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    
    @Autowired 
    AuthService authService;

    @GetMapping("/")
    public String displayHome(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); // get logged in username
        model.addAttribute("username", name);
        return "home";
    }

    @GetMapping("/register")
    public String showRegisterForm() {
        return "userRegistration";
    }

    @PostMapping("/register")
    public String grabDisplayData(@RequestParam String username, @RequestParam String pwd,
                                  Model model) {
        BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
        User user = new User();
        Set<Authorities> auths = new HashSet<>();
        user.setUsername(username);
        user.setPassword(bCrypt.encode(pwd));
        user.setEnabled(true);
        userService.insertUser(user);
        Authorities a = authService.findById(1l);
        auths.add(a); /// ENum Need
        user.setAuths(auths);
        userService.updateUser(user);
        model.addAttribute("msg", "New User Added");
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("errorMsg", "Your username and password are invalid.");
        if (logout != null)
            model.addAttribute("msg", "You have been logged out successfully.");
        return "login";
    }

    @GetMapping("/editUser")
    public String edit() {
        return "editUser";
    }

    @PostMapping("/editUser")
    public String editUser(@RequestParam String username, @RequestParam String pwd,
                                  Model model) {
        BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getUserByUsername(auth.getName()); ///// Streams ??
        user.setUsername(username);
        user.setPassword(bCrypt.encode(pwd));
        userService.updateUser(user);
        model.addAttribute("msg", "User updated");
        model.addAttribute("username", username);
        return "home";
    }

}
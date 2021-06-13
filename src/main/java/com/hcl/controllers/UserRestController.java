package com.hcl.controllers;

import com.hcl.model.Authorities;
import com.hcl.model.User;
import com.hcl.service.AuthService;
import com.hcl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class UserRestController {

    @Autowired
    UserService userService;

    @Autowired
    AuthService authService;

    @GetMapping("/user")
    private List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/user/{userId}")
    private User getUser(@PathVariable(value = "userId") long userId){
        return userService.getUserById(userId);
    }

    @PostMapping("user")
    private void createUser(@RequestBody User user){
        BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
        Set<Authorities> auths = user.getAuths();
        user.setAuths(new HashSet<>());
        user.setPassword(bCrypt.encode(user.getPassword()));
        for(Authorities auth: auths){
            user.addAuth(authService.findById(auth.getId()));
        }
        userService.insertUser(user);

    }

    @PutMapping("user")
    private void updateUser(@RequestBody User user){
        BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
        user.setPassword(bCrypt.encode(user.getPassword()));
        userService.insertUser(user);
    }

//    @DeleteMapping Mapping("user")
//    private void deleteUser(@RequestBody User user){
//        userService.dUser(user);
//    }
}

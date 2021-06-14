package com.hcl.controllers;

import com.hcl.model.Authorities;
import com.hcl.model.User;
import com.hcl.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class AuthoritiesRestController {

    @Autowired
    AuthService authService;

    @GetMapping("/authorities")
    private List<Authorities> getAllAuthorities(){
        return authService.getAllAuths();
    }

    @GetMapping("/authorities/{authoritiesId}")
    private Authorities getAuthorities(@PathVariable(value = "authoritiesId") long id){
        return authService.findById(id);
    }

    @PostMapping("authorities")
    private void createAuthority(@RequestBody Authorities auth){
        authService.insertAuth(auth);

    }

    @PutMapping("authorities")
    private void updateAuthorities(@RequestBody Authorities auth){
        authService.insertAuth(auth);
    }

    @DeleteMapping("authorities/{authoritiesId}")
    private void deleteAuthorities(@PathVariable(name = "authoritiesId") long id){
        authService.deleteById(id);
    }
}

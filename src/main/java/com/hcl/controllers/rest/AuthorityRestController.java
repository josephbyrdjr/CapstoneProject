package com.hcl.controllers.rest;

import com.hcl.model.Authority;
import com.hcl.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorityRestController {

    @Autowired
    AuthService authService;

    @GetMapping("/authorities")
    private List<Authority> getAllAuthorities(){
        return authService.getAllAuths();
    }

    @GetMapping("/authorities/{authoritiesId}")
    private Authority getAuthorities(@PathVariable(value = "authoritiesId") long id){
        return authService.findById(id);
    }

    @PostMapping("authorities")
    private void createAuthority(@RequestBody Authority auth){
        authService.insertAuth(auth);

    }

    @PutMapping("authorities")
    private void updateAuthorities(@RequestBody Authority auth){
        authService.insertAuth(auth);
    }

    @DeleteMapping("authorities/{authoritiesId}")
    private void deleteAuthorities(@PathVariable(name = "authoritiesId") long id){
        authService.deleteById(id);
    }
}

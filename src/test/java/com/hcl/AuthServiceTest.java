package com.hcl;

import com.hcl.model.Authority;
import com.hcl.service.AuthService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class AuthServiceTest {
    @Autowired
    AuthService authService;

    @Test
    public void testAutowired(){
        assertNotNull(authService);
    }

    @Test
    public void testAuthCrud(){
        authService.insertAuth(new Authority(100001L,"TestAuthority"));
        assertTrue(authService.getAllAuths().stream().anyMatch(a -> a.getAuthority().equals("TestAuthority")));
        authService.deleteById(100001L);
        assertTrue(authService.getAllAuths().stream().noneMatch(a -> a.getAuthority().equals("TestAuthority")));
    }
}

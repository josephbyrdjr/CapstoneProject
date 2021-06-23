package com.hcl;

import com.hcl.dao.AuthDao;
import com.hcl.dao.ItemDao;
import com.hcl.model.Authority;
import com.hcl.model.Item;
import com.hcl.service.AuthService;
import com.hcl.service.impl.AuthServiceImpl;
import com.hcl.service.impl.ItemServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AuthServiceTest {
;

    @Autowired
    AuthService authService;

    @BeforeEach
    public void init(){
        authService.insertAuth(new Authority(1,"test1"));
        authService.insertAuth(new Authority(2,"test2"));
        authService.insertAuth(new Authority(3,"test3"));
    }

    @Test
    public void getAllAuthsTest(){
        List<Authority> auths = authService.getAllAuths();
        assertTrue(auths.stream().anyMatch(auth -> auth.getAuthority().equals("test1")));
        assertTrue(auths.stream().anyMatch(auth -> auth.getAuthority().equals("test2")));
        assertTrue(auths.stream().anyMatch(auth -> auth.getAuthority().equals("test3")));
        assertEquals(auths.size(), 3);
    }

    @Test
    public void getAuthByIdTest(){
        assertEquals(authService.findById(1L).getAuthority(), "test1");
    }

    @Test
    public void updateItemTest(){
        Authority auth = authService.findById(1L);
        auth.setAuthority("testing");
        authService.updateAuth(auth);
        assertEquals(authService.findById(1L).getAuthority(),"testing");
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void deleteItemTest(){
        authService.deleteById(1L);
        assertEquals(authService.getAllAuths().size(), 2);
        assertFalse(authService.getAllAuths().stream().anyMatch(auth -> auth.getAuthority().equals("test1")));
    }
}

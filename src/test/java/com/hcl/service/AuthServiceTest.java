package com.hcl.service;

import com.hcl.model.Authority;
import com.hcl.model.Item;
import com.hcl.repository.AuthRepository;
import com.hcl.service.AuthService;
import com.hcl.service.impl.AuthServiceImpl;
import com.hcl.service.impl.ItemServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class AuthServiceTest {

    @MockBean
    AuthRepository authRepository;

    @Autowired
    AuthService authService;

    @Test
    public void insertAuthTest(){
        Authority auth = new Authority(1L, "test1");
        authService.insertAuth(auth);
        verify(authRepository, times(1)).save(auth);
    }

    @Test
    public void getAllAuthsTest(){
        List<Authority> list = new ArrayList<>();
        list.add(new Authority(1,"test1"));
        list.add(new Authority(2,"test2"));
        list.add(new Authority(3,"test3"));
        when(authRepository.findAll()).thenReturn(list);
        List<Authority> auths = authService.getAllAuths();
        assertTrue(auths.stream().anyMatch(auth -> auth.getAuthority().equals("test1")));
        assertTrue(auths.stream().anyMatch(auth -> auth.getAuthority().equals("test2")));
        assertTrue(auths.stream().anyMatch(auth -> auth.getAuthority().equals("test3")));
        assertEquals(auths.size(), 3);
    }

    @Test
    public void getAuthByIdTest(){
        long id = 1L;
        when(authRepository.findById(id)).thenReturn(java.util.Optional.of(new Authority(id, "test1")));
        assertEquals(authService.findById(id).getAuthority(), "test1");
    }

    @Test
    public void updateItemTest(){
        Authority auth = new Authority(1L, "test1");
        auth.setAuthority("testing");
        authService.updateAuth(auth);
        verify(authRepository, times(1)).save(auth);
    }

    @Test
    public void deleteItemTest(){
        authService.deleteById(1L);
        verify(authRepository, times(1)).deleteById(1L);
    }
}

package com.hcl.restcontroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.controllers.rest.AuthorityRestController;
import com.hcl.model.Authority;
import com.hcl.service.AuthService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class AuthorityRestControllerTest {
    ObjectMapper mapper;
    @MockBean
    AuthService authService;

    @InjectMocks
    AuthorityRestController authorityRestController;

    private MockMvc mockMvc;
    @BeforeEach
    public void init(){
        mapper = new ObjectMapper();
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(authorityRestController).build();
    }
    @Test
    public void getAllAuthsTest() throws Exception {
        List<Authority> list = Arrays.asList(
                new Authority(1L, "test1"),
                new Authority(2L, "test2"),
                new Authority(3L, "test3"));
        when(authService.getAllAuths()).thenReturn(list);

        mockMvc.perform(get("/authorities")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].authority").value("test1"))
                .andExpect(jsonPath("$[1].authority").value("test2"))
                .andExpect(jsonPath("$[2].authority").value("test3"));
    }

    @Test
    public void getAuthTest() throws Exception{
        Authority auth = new Authority(1L, "test1");

        when(authService.findById(1L)).thenReturn(auth);

        mockMvc.perform(get("/authorities/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.authority").value("test1"));
    }

    @Test
    public void postAuthTest() throws  Exception{
        Authority auth = new Authority(1L, "test1");

        mockMvc.perform(post("/authorities")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(auth)))
                .andExpect(status().isOk());
    }

    @Test
    public void putAuthTest() throws  Exception{
        Authority auth = new Authority(1L, "test1");

        mockMvc.perform(put("/authorities")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(auth)))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteAuthTest() throws Exception{
        mockMvc.perform(delete("/authorities/1"))
                .andExpect(status().isOk());
    }
}
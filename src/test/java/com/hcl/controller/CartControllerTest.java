package com.hcl.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.model.User;
import com.hcl.repository.AuthRepository;
import com.hcl.repository.ItemRepository;
import com.hcl.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CartControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper;

    @Autowired
    UserRepository userRepository;


    @BeforeEach
    public void init(){
        mapper = new ObjectMapper();
    }

    @Test
    @WithMockUser(username = "user", password = "password", roles = "USER")
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void displayCartTest() throws Exception {
        User user = new User("user", "pass", true,
                "", "", "", "", "",
                "","", "","");
        userRepository.save(user);
        mockMvc.perform(get("/orderItem/shoppingCart")).andExpect(status().isOk());
    }
    
    @Test
    @Transactional
    @WithMockUser(username = "user", password = "password", roles = "USER")
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void displayCheckoutTest() throws Exception {
    	User user = new User("user", "pass", true,
                "", "", "", "", "",
                "","", "","");
        userRepository.save(user);
        mockMvc.perform(get("/checkout")).andExpect(status().isOk());
    }
    
    @Test
    @WithMockUser(username = "user", password = "password", roles = "USER")
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void placeOrderTest() throws Exception {
    	User user = new User("user", "pass", true,
                "", "", "", "", "",
                "","", "","");
        userRepository.save(user);
        mockMvc.perform(post("/confirmation")).andExpect(status().isOk());
    }
    
}

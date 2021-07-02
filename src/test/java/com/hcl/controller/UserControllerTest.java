package com.hcl.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.model.Authority;
import com.hcl.model.Item;
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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest  {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthRepository authRepository;

    private ObjectMapper mapper;


    @BeforeEach
    public void init(){
        mapper = new ObjectMapper();
    }

    @Test
    public void homeGetTest() throws Exception {
        mockMvc.perform(get("/")).andExpect(status().isOk());
    }

    @Test
    public void registerGetTest() throws Exception {
        mockMvc.perform(get("/register")).andExpect(status().isOk());
    }


    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void registerPostTest() throws Exception {
        Authority auth = new Authority(1L, "ROLE_USER");
        authRepository.save(auth);
        mockMvc.perform(post("/register")
                .param("username", "user")
                .param("pwd", "password")
                .param("firstName", "")
                .param("lastName", "")
                .param("email", "")
                .param("phoneNumber", "")
                .param("address", "")
                .param("apartmentNumber", "")
                .param("city", "")
                .param("state", "")
                .param("zip", ""))
                .andExpect(status().isOk());
        assertTrue(userRepository.findAll().stream().anyMatch(user -> user.getUsername().equals("user")));

    }

    @Test
    public void loginGetTest() throws Exception {
        mockMvc.perform(get("/login")).andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "user", password = "password", roles = "USER")
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void editUserGetTest() throws Exception {
        mockMvc.perform(get("/editUser")).andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "user", password = "password", roles = "USER")
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void editUserPostTest() throws Exception {
        User user = new User("user", "pass", true,
                "jeff", "", "", "", "",
                "","", "","");
        userRepository.save(user);

        mockMvc.perform(post("/editUser")
                .param("username", "user")
                .param("pwd", "password")
                .param("firstName", "jim")
                .param("lastName", "")
                .param("email", "")
                .param("phoneNumber", "")
                .param("address", "")
                .param("apartmentNumber", "")
                .param("city", "")
                .param("state", "")
                .param("zip", ""))
                .andExpect(status().isOk());
        assertTrue(userRepository.findAll().stream().anyMatch(u -> u.getFirstName().equals("jim")));
        assertFalse(userRepository.findAll().stream().anyMatch(u -> u.getFirstName().equals("jeff")));

    }

    @Test
    public void displayAboutTest() throws Exception {
    	mockMvc.perform(get("/about")).andExpect(status().isOk());
    }
    
}

package com.hcl.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.model.Item;
import com.hcl.repository.ItemRepository;
import com.hcl.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AdminControllerTest  {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    UserRepository userRepository;

    private ObjectMapper mapper;


    @BeforeEach
    public void init(){
        mapper = new ObjectMapper();
    }

    @Test
    @WithMockUser(username = "user", password = "password", roles = "ADMIN")
    public void adminCredentialsTest() throws Exception {
        mockMvc.perform(get("/admin")).andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "user", password = "password", roles = "USER")
    public void adminCredentialsFailTest() throws Exception {
        mockMvc.perform(get("/admin")).andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(username = "user", password = "password", roles = "ADMIN")
    public void allUsersTest() throws Exception {
        mockMvc.perform(get("/admin/allUsers")).andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "user", password = "password", roles = "ADMIN")
    public void allOrdersTest() throws Exception {
        mockMvc.perform(get("/admin/allOrders")).andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "user", password = "password", roles = "ADMIN")
    public void allItemsTest() throws Exception {
        mockMvc.perform(get("/admin/allItems")).andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "user", password = "password", roles = "ADMIN")
    public void addItemTest() throws Exception {
        Item item1 = new Item(9.99, "test1", "", "", "");
        mockMvc.perform(post("/admin/addItem")
                .param("price", "9.99")
                .param("name", "test1")
                .param("thumbnail", "")
                .param("category", "")
                .param("description", ""))
                .andExpect(status().isOk());
        assertTrue(itemRepository.findAll().stream().anyMatch(item -> item.getName() == "test1"));
    }


}

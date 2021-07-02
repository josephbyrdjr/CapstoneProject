package com.hcl.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.model.Item;
import com.hcl.model.User;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CatalogControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper;

    @Autowired
    ItemRepository itemRepository;


    @BeforeEach
    public void init(){
        mapper = new ObjectMapper();
    }


    @Test
    public void catalogGetTest() throws Exception {
        mockMvc.perform(get("/catalog")).andExpect(status().isOk());
    }

    @Test
    public void catalogItemGetTest() throws Exception {
        Item item = new Item(1, 9.99, "", "", "", "", 100L);
        itemRepository.save(item);
        mockMvc.perform(get("/catalog/1")).andExpect(status().isOk());
    }
}
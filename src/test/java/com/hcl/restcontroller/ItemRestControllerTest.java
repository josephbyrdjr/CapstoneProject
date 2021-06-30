package com.hcl.restcontroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.controllers.rest.ItemRestController;
import com.hcl.model.Item;
import com.hcl.service.ItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class ItemRestControllerTest {
    ObjectMapper mapper;
    @MockBean
    ItemService itemService;

    @InjectMocks
    ItemRestController itemRestController;

    private MockMvc mockMvc;

    @BeforeEach
    public void init(){
        mapper = new ObjectMapper();
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(itemRestController).build();
    }

    @Test
    public void getAllItemsTest() throws Exception {
        List<Item> list = Arrays.asList(
                new Item(1L, 9.99,"test1", "", "", "", 100L),
                new Item(2L, 9.99, "test2", "", "", "", 100L),
                new Item(3L, 9.99, "test3", "", "", "", 100L));
        when(itemService.getAllItems()).thenReturn(list);

        mockMvc.perform(get("/item")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name").value("test1"))
                .andExpect(jsonPath("$[1].name").value("test2"))
                .andExpect(jsonPath("$[2].name").value("test3"));
    }

    @Test
    public void getItemTest() throws Exception{
        Item item = new Item(1L, 9.99, "test1", "", "", "", 100L);

        when(itemService.getItemById(1L)).thenReturn(item);

        mockMvc.perform(get("/item/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("test1"));
    }

    @Test
    public void postItemTest() throws  Exception{
        Item item = new Item(1L, 9.99, "test1", "", "", "", 100L);

        mockMvc.perform(post("/item")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(item)))
                .andExpect(status().isOk());
    }

    @Test
    public void putItemTest() throws  Exception{
        Item item = new Item(1L, 9.99, "test1", "", "", "", 100L);

        mockMvc.perform(put("/item")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(item)))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteItemTest() throws Exception{
        mockMvc.perform(delete("/item/1"))
                .andExpect(status().isOk());
    }
}

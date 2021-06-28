package com.hcl.restcontroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.controllers.rest.OrderRestController;
import com.hcl.model.Item;
import com.hcl.model.Order;
import com.hcl.model.User;
import com.hcl.service.ItemService;
import com.hcl.service.OrderService;
import com.hcl.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class h2DatabaseTests {

    @Autowired
    OrderRestController orderRestController;

    @Autowired
    UserService userService;

    @Autowired
    ItemService itemService;
    
    @Autowired
    OrderService orderService;

    private MockMvc mockMvc;

    @BeforeEach
    public void init(){
        mockMvc = MockMvcBuilders.standaloneSetup(orderRestController).build();
    }

    @Test
    @WithMockUser(username = "test", password = "pass", roles = "USER")
    public void postOrderTest() throws  Exception{
        userService.insertUser(new User("test", "pass", true, "", "", "", "", "", "","", "",""));
        itemService.insertItem(new Item(1,9.99,"", "", "", ""));
        mockMvc.perform(post("/order")
                .contentType(MediaType.APPLICATION_JSON)
                .param("quantity", "1")
                .param("itemId", "1"))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    @WithMockUser(username = "test", password = "pass", roles = "USER")
    public void postOrderAntiTest() throws  Exception{
        userService.insertUser(new User("test", "pass", true, "", "", "", "", "", "","", "",""));
        mockMvc.perform(post("/order")
                .contentType(MediaType.APPLICATION_JSON)
                .param("quantity", "1")
                .param("itemId", "1"))
                .andExpect(status().is4xxClientError());
    }
    
    @Test
    @WithMockUser(username = "test", password = "pass", roles = "USER")
    public void putOrderTest() throws Exception {
    	Item item = new Item(1,9.99,"", "", "", "");
		User user = new User("test", "pass", true, "", "", "", "", "", "","", "","");
		itemService.insertItem(item);
		userService.insertUser(user);
    	orderService.insertOrders(new Order(1, 1, "Test", item, user));
        
        mockMvc.perform(post("/updateOrder") .contentType(MediaType.APPLICATION_JSON)
                .param("orderId", "1")
                .param("quantity", "1"))
                .andExpect(status().is3xxRedirection());
    }
}

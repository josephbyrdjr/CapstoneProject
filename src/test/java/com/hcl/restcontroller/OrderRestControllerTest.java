package com.hcl.restcontroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.controllers.rest.OrderRestController;
import com.hcl.model.Item;
import com.hcl.model.Order;
import com.hcl.model.User;
import com.hcl.repository.UserRepository;
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

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class OrderRestControllerTest {
    ObjectMapper mapper;
    @MockBean
    OrderService orderService;

    @InjectMocks
    OrderRestController orderRestController;

    @Autowired
    UserService userService;

    private MockMvc mockMvc;
    @BeforeEach
    public void init(){
        mapper = new ObjectMapper();
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(orderRestController).build();
    }

    @Test
    public void getAllOrdersTest() throws Exception {
    	Item item = new Item();
		User user = new User();
        List<Order> list = Arrays.asList(
        		new Order(1L, 1, "Test1", item, user),
        		new Order(2L, 1, "Test2", item, user),
        		new Order(3L, 1, "Test3", item, user));
        when(orderService.getAllOrders()).thenReturn(list);

        mockMvc.perform(get("/order")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].status").value("Test1"))
                .andExpect(jsonPath("$[1].status").value("Test2"))
                .andExpect(jsonPath("$[2].status").value("Test3"));
    }

    @Test
    public void getOrderTest() throws Exception{
    	Item item = new Item();
		User user = new User();
        Order order = new Order(1L, 1, "Test", item, user);

        when(orderService.getOrderById(1L)).thenReturn(order);

        mockMvc.perform(get("/order/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status").value("Test"));
    }

    @Test
    public void putOrderTest() throws  Exception{
    	Item item = new Item(1L, 9.99, "test1", "", "", "");
		User user = new User(1L, "UsernameTest", "FirstNameTest", "LastNameTest");
        Order order = new Order(1L, 1, "Test", item, user);

        int quantity = order.getQuantity();
        long itemId = item.getId();
        
        mockMvc.perform(put("/order").param("quantity", "$.quantity").param("itemId", "$.itemId")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(order)))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteOrderTest() throws Exception{
        mockMvc.perform(delete("/order/1"))
                .andExpect(status().isOk());
    }
}

package com.hcl.restcontroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.controllers.rest.OrderItemRestController;
import com.hcl.model.Item;
import com.hcl.model.OrderItem;
import com.hcl.model.User;
import com.hcl.service.OrderItemService;
import com.hcl.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
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
public class OrderDaoImplItemRestControllerTest {
    ObjectMapper mapper;
    @MockBean
    OrderItemService orderItemService;

    @InjectMocks
    OrderItemRestController orderItemRestController;

    @Autowired
    UserService userService;

    private MockMvc mockMvc;
    @BeforeEach
    public void init(){
        mapper = new ObjectMapper();
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(orderItemRestController).build();
    }

    @Test
    public void getAllOrdersTest() throws Exception {
//    	Item item = new Item();
//		User user = new User();
//        List<OrderItem> list = Arrays.asList(
//        		new OrderItem(1L, 1, "Test1", item, user),
//        		new OrderItem(2L, 1, "Test2", item, user),
//        		new OrderItem(3L, 1, "Test3", item, user));
//        when(orderItemService.getAllOrdersItems()).thenReturn(list);
//
//        mockMvc.perform(get("/order")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$[0].status").value("Test1"))
//                .andExpect(jsonPath("$[1].status").value("Test2"))
//                .andExpect(jsonPath("$[2].status").value("Test3"));
    }

    @Test
    public void getOrderTest() throws Exception{
//    	Item item = new Item();
//		User user = new User();
//        OrderItem orderItem = new OrderItem(1L, 1, "Test", item, user);
//
//        when(orderItemService.getOrderItemById(1L)).thenReturn(orderItem);
//
//        mockMvc.perform(get("/order/1")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.status").value("Test"));
    }

    @Test
    public void deleteOrderTest() throws Exception{
//        mockMvc.perform(get("/deleteOrder/1"))
//                .andExpect(status().is3xxRedirection());
    }
}

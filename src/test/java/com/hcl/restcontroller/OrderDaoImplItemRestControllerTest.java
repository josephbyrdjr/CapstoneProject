package com.hcl.restcontroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.controllers.rest.OrderItemRestController;
import com.hcl.model.Item;
import com.hcl.model.Order;
import com.hcl.model.OrderItem;
import com.hcl.model.User;
import com.hcl.repository.OrderRepository;
import com.hcl.service.OrderItemService;
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
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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
    OrderRepository orderRepo;

    private MockMvc mockMvc;
    @BeforeEach
    public void init(){
        mapper = new ObjectMapper();
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(orderItemRestController).build();
    }

    @Test
    public void getAllItemsTest() throws Exception {
    	Item item = new Item();
		Order order = new Order();
        
        OrderItem orderItem1 = new OrderItem(1,1, item, order);
        OrderItem orderItem2 = new OrderItem(2,2, item, order);
        OrderItem orderItem3 = new OrderItem(3,3, item, order);
        Set<OrderItem> list = new HashSet<>(Arrays.asList(orderItem1, orderItem2, orderItem3));
        when(orderItemService.getAllOrdersItems()).thenReturn(list);

        
        mockMvc.perform(get("/orderItem")
                .contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].quantity").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].quantity").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].quantity").value(1));
    }

    @Test
    public void getOrderTest() throws Exception{
    	Item item = new Item();
    	Order order = new Order();
        OrderItem orderItem = new OrderItem(1,1, item, order);

        when(orderItemService.getOrderItemById(1L)).thenReturn(orderItem);

        mockMvc.perform(get("/orderItem/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.quantity").value(1));
    }
    
//    @Test
//    public void createOrderTest() throws Exception {
//    	Item item = new Item();
//    	Order order = new Order();
//        OrderItem orderItem = new OrderItem(1,1, item, order);
//        
//        mockMvc.perform(post("/orderItem").contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(orderItem)))
//		.andExpect(status().is3xxRedirection());
//    }

    @Test
    public void deleteOrderTest() throws Exception{
        mockMvc.perform(get("/deleteOrderItem/1"))
                .andExpect(status().is3xxRedirection());
    }
}

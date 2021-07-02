package com.hcl.restcontroller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.controllers.rest.OrderRestController;
import com.hcl.model.Item;
import com.hcl.model.Order;
import com.hcl.model.OrderItem;
import com.hcl.model.User;
import com.hcl.service.OrderService;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class OrderRestContorllerTest {
	ObjectMapper mapper;
	
	@MockBean
	OrderService orderService;
	
	@InjectMocks
	OrderRestController orderRestController;
	
	private MockMvc mockMvc;
	
	@BeforeEach
    public void init(){
        mapper = new ObjectMapper();
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(orderRestController).build();
    }
	
	@Test
    public void getAllOrdersTest() throws Exception {
		User user = new User();
        
        Order order1 = new Order("Test1", user);
        Order order2 = new Order("Test2", user);
        Order order3 = new Order("Test3", user);
        List<Order> list = new ArrayList<>(Arrays.asList(order1, order2, order3));
        when(orderService.getAllOrders()).thenReturn(list);

        
        mockMvc.perform(get("/order")
                .contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].status").value("Test1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].status").value("Test2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].status").value("Test3"));
    }
	
	@Test
    public void getOrderTest() throws Exception{
		User user = new User();
        
    	Order order = new Order("Test1", user);

        when(orderService.getOrderById(1L)).thenReturn(order);

        mockMvc.perform(get("/order/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status").value("Test1"));
    }
	
	@Test
    public void deleteOrderTest() throws Exception{
        mockMvc.perform(get("/deleteOrder/1"))
                .andExpect(status().is3xxRedirection());
    }

}

package com.hcl.controllers.rest;

import com.hcl.model.Item;
import com.hcl.model.Order;
import com.hcl.model.OrderItem;
import com.hcl.model.User;
import com.hcl.service.ItemService;
import com.hcl.service.OrderItemService;
import com.hcl.service.OrderService;
import com.hcl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class OrderRestController {

    @Autowired
    UserService userService;

    @Autowired
    ItemService itemService;

    @Autowired
    OrderItemService orderItemService;

    @Autowired
    OrderService orderService;

    @GetMapping("/order")
    private List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/order/{orderId}")
    private Order getOrder(@PathVariable(value = "orderId") long orderId) {
        return orderService.getOrderById(orderId);
    }

    @PostMapping("/order")
    private void createOrder(@RequestParam(name = "quantity") int quantity, @RequestParam(name = "itemId") long itemId,
                             HttpServletResponse response) throws IOException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		User user = userService.getUserByUsername(auth.getName());
		Order order = new Order("ACTIVE", user);
		orderService.insertOrder(order);
    }

    @PostMapping("/updateOrder")
    private void updateOrder(@RequestParam long orderId, @RequestParam String status, HttpServletResponse response)
            throws IOException {
        Order order = orderService.getOrderById(orderId);
        order.setStatus(status);
        orderService.updateOrder(order);
        response.sendRedirect("/order/shoppingCart");

    }

    @GetMapping("/deleteOrder/{orderId}")
    private void deleteOrder(@PathVariable(value = "orderId") long id, HttpServletResponse response)
            throws IOException {
        orderService.deleteOrderById(id);
        response.sendRedirect("/order/shoppingCart");
    }
}

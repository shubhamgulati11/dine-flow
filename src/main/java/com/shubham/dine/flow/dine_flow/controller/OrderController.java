package com.shubham.dine.flow.dine_flow.controller;

import com.shubham.dine.flow.dine_flow.Repository.OrderRepository;
import com.shubham.dine.flow.dine_flow.entity.OrderItem;
import com.shubham.dine.flow.dine_flow.entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/create")
    public ResponseEntity<?> createOrder(@RequestBody Orders orders){
        linkOrderItems(orders);
        orderRepository.save(orders);
        return ResponseEntity.ok().body("Order created");
    }

    @GetMapping("/all")
    public List<Orders> getAllOrders(@RequestParam long customerId){
        return orderRepository.findByCustomerId(customerId);
    }

    private void linkOrderItems(Orders order) {
        if (order.getItems() != null) {
            for (OrderItem item : order.getItems()) {
                item.setOrder(order);
            }
        }
    }


}

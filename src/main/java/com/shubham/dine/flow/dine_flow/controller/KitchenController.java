package com.shubham.dine.flow.dine_flow.controller;

import com.shubham.dine.flow.dine_flow.Repository.OrderRepository;
import com.shubham.dine.flow.dine_flow.entity.OrderStatus;
import com.shubham.dine.flow.dine_flow.entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kitchen")
public class KitchenController {

    @Autowired
    OrderRepository orderRepository;

    @GetMapping("/orders")
    public ResponseEntity<List<Orders>> getPendingOrders() {
        List<Orders> orders = orderRepository.findByStatusIn(List.of(OrderStatus.PLACED, OrderStatus.IN_PROGRESS));
        return ResponseEntity.ok(orders);
    }

    @PutMapping("/orders/{orderId}/status")
    public ResponseEntity<?> updateOrderStatus(
            @PathVariable Long orderId,
            @RequestParam OrderStatus status) {

        Orders order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setStatus(status);
        orderRepository.save(order);

        return ResponseEntity.ok().body("Order updated");
    }

}

package com.trallkong.csitsbackend.controller;

import com.trallkong.csitsbackend.entity.Order;
import com.trallkong.csitsbackend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{buyerId}")
    public ResponseEntity<List<Order> > getAllByBuyerId(@PathVariable Long buyerId) {
        List<Order> orders = orderService.getAllByBuyerId(buyerId);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{sellerId}")
    public ResponseEntity<List<Order> > getAllBySellerId(@PathVariable Long sellerId) {
        List<Order> orders = orderService.getAllBySellerId(sellerId);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Order order = orderService.getOrderById(id);
        return ResponseEntity.ok(order);
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order createdOrder = orderService.addOrder(order);
        return ResponseEntity.ok(createdOrder);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order order) {
        Order updatedOrder = orderService.updateOrder(id, order);
        return ResponseEntity.ok(updatedOrder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}

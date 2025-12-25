package com.trallkong.csitsbackend.controller;

import com.trallkong.csitsbackend.entity.Orders;
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
    public ResponseEntity<List<Orders> > getAllByBuyerId(@PathVariable Long buyerId) {
        List<Orders> orders = orderService.getAllByBuyerId(buyerId);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{sellerId}")
    public ResponseEntity<List<Orders> > getAllBySellerId(@PathVariable Long sellerId) {
        List<Orders> orders = orderService.getAllBySellerId(sellerId);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orders> getOrderById(@PathVariable Long id) {
        Orders orders = orderService.getOrderById(id);
        return ResponseEntity.ok(orders);
    }

    @PostMapping
    public ResponseEntity<Orders> createOrder(@RequestBody Orders orders) {
        Orders createdOrders = orderService.addOrder(orders);
        return ResponseEntity.ok(createdOrders);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Orders> updateOrder(@PathVariable Long id, @RequestBody Orders orders) {
        Orders updatedOrders = orderService.updateOrder(id, orders);
        return ResponseEntity.ok(updatedOrders);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}

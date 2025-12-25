package com.trallkong.csitsbackend.controller;

import com.trallkong.csitsbackend.entity.Payment;
import com.trallkong.csitsbackend.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<Payment>> getAllPaymentsByUserId(@PathVariable Long userId) {
        List<Payment> payments = paymentService.getAllPaymentsByUserId(userId);
        return ResponseEntity.ok(payments);
    }
}

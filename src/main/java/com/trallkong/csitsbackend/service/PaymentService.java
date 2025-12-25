package com.trallkong.csitsbackend.service;

import com.trallkong.csitsbackend.entity.Payment;
import com.trallkong.csitsbackend.repository.PaymentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment getPaymentById(Long id) {
        try {
            return paymentRepository.findById(id).orElse(null);
        } catch (Exception e) {
            log.error("PaymentService-通过id获取支付信息失败");
            throw new RuntimeException(e);
        }
    }

    public List<Payment> getAllPaymentsByUserId(Long userId) {
        try {
            return paymentRepository.findAllByUserId(userId);
        } catch (Exception e) {
            log.error("PaymentService-通过用户id获取全部支付信息失败");
            throw new RuntimeException(e);
        }
    }

    public Payment addPayment(Payment payment) {
        try {
            return paymentRepository.save(payment);
        } catch (Exception e) {
            log.error("PaymentService-添加支付信息失败");
            throw new RuntimeException(e);
        }
    }

    public void deletePayment(Long id) {
        try {
            paymentRepository.deleteById(id);
        } catch (Exception e) {
            log.error("PaymentService-删除支付信息失败");
            throw new RuntimeException(e);
        }
    }
}

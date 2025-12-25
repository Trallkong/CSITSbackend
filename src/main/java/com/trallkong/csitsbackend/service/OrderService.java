package com.trallkong.csitsbackend.service;

import com.trallkong.csitsbackend.entity.Order;
import com.trallkong.csitsbackend.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order getOrderById(Long id) {
        try {
            return orderRepository.findById(id).orElse(null);
        } catch (Exception e) {
            log.error("OrderService-通过id获取订单信息失败");
            throw new RuntimeException(e);
        }
    }

    public List<Order> getAllByBuyerId(Long buyerId) {
        try {
            return orderRepository.getAllByBuyerId(buyerId);
        } catch (Exception e) {
            log.error("OrderService-通过买家id获取所有订单信息失败");
            throw new RuntimeException(e);
        }
    }

    public List<Order> getAllBySellerId(Long sellerId) {
        try {
            return orderRepository.getAllBySellerId(sellerId);
        } catch (Exception e) {
            log.error("OrderService-通过卖家id获取所有订单信息失败");
            throw new RuntimeException(e);
        }
    }

    public Order addOrder(Order order) {
        try {
            return orderRepository.save(order);
        } catch (Exception e) {
            log.error("OrderService-添加订单信息失败");
            throw new RuntimeException(e);
        }
    }

    public void deleteOrder(Long id) {
        try {
            orderRepository.deleteById(id);
        } catch (Exception e) {
            log.error("OrderService-删除订单信息失败");
            throw new RuntimeException(e);
        }
    }

    public Order updateOrder(Long id, Order order) {
        try {
            Order oldOrder = orderRepository.findById(id).orElse(null);
            if (oldOrder == null) {
                log.info("OrderService-订单信息不存在");
                return null;
            }
            oldOrder.setBuyerId(order.getBuyerId());
            oldOrder.setSellerId(order.getSellerId());
            oldOrder.setGid(order.getGid());
            oldOrder.setState(order.getState());
            oldOrder.setAmount(order.getAmount());
            oldOrder.setOrderNo(order.getOrderNo());
            return orderRepository.save(oldOrder);
        } catch (Exception e) {
            log.error("OrderService-更新订单信息失败");
            throw new RuntimeException(e);
        }
    }
}

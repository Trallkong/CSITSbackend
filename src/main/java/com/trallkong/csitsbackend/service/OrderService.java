package com.trallkong.csitsbackend.service;

import com.trallkong.csitsbackend.entity.Orders;
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

    public Orders getOrderById(Long id) {
        try {
            return orderRepository.findById(id).orElse(null);
        } catch (Exception e) {
            log.error("OrderService-通过id获取订单信息失败");
            throw new RuntimeException(e);
        }
    }

    public List<Orders> getAllByBuyerId(Long buyerId) {
        try {
            return orderRepository.getAllByBuyerId(buyerId);
        } catch (Exception e) {
            log.error("OrderService-通过买家id获取所有订单信息失败");
            throw new RuntimeException(e);
        }
    }

    public List<Orders> getAllBySellerId(Long sellerId) {
        try {
            return orderRepository.getAllBySellerId(sellerId);
        } catch (Exception e) {
            log.error("OrderService-通过卖家id获取所有订单信息失败");
            throw new RuntimeException(e);
        }
    }

    public Orders addOrder(Orders orders) {
        try {
            return orderRepository.save(orders);
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

    public Orders updateOrder(Long id, Orders orders) {
        try {
            Orders oldOrders = orderRepository.findById(id).orElse(null);
            if (oldOrders == null) {
                log.info("OrderService-订单信息不存在");
                return null;
            }
            oldOrders.setBuyerId(orders.getBuyerId());
            oldOrders.setSellerId(orders.getSellerId());
            oldOrders.setGid(orders.getGid());
            oldOrders.setState(orders.getState());
            oldOrders.setAmount(orders.getAmount());
            oldOrders.setOrderNo(orders.getOrderNo());
            return orderRepository.save(oldOrders);
        } catch (Exception e) {
            log.error("OrderService-更新订单信息失败");
            throw new RuntimeException(e);
        }
    }
}

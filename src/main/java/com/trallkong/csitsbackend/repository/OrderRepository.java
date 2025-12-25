package com.trallkong.csitsbackend.repository;

import com.trallkong.csitsbackend.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> getAllByBuyerId(Long buyerId);

    List<Order> getAllBySellerId(Long sellerId);
}

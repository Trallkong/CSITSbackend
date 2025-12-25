package com.trallkong.csitsbackend.repository;

import com.trallkong.csitsbackend.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
    List<Orders> getAllByBuyerId(Long buyerId);

    List<Orders> getAllBySellerId(Long sellerId);
}

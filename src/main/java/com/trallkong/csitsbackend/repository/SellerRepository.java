package com.trallkong.csitsbackend.repository;

import com.trallkong.csitsbackend.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {
    Seller findByUsername(String username);
}

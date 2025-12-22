package com.trallkong.csitsbackend.controller;

import com.trallkong.csitsbackend.entity.Buyer;
import com.trallkong.csitsbackend.service.BuyerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
public class BuyerController {

    @Autowired
    private BuyerService buyerService;

    // 获取所有买家
    @GetMapping
    public ResponseEntity<List<Buyer>> getAllBuyers() {
        List<Buyer> buyers = buyerService.getAllBuyers();
        return ResponseEntity.ok(buyers);
    }

    // 通过 id 获取买家
    @GetMapping("/{id}")
    public ResponseEntity<Buyer> getBuyerById(@PathVariable Long id) {
        Buyer buyer = buyerService.getBuyerById(id);
        return ResponseEntity.ok(buyer);
    }

    // 添加买家
    @PostMapping
    public ResponseEntity<Buyer> addBuyer(@RequestBody Buyer buyer) {
        Buyer newBuyer = buyerService.addBuyer(buyer);
        return ResponseEntity.ok(newBuyer);
    }

    // 删除买家
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBuyer(@PathVariable Long id) {
        buyerService.deleteBuyer(id);
        return ResponseEntity.ok(null);
    }

    // 修改买家信息
    @PutMapping("/{id}")
    public ResponseEntity<Buyer> updateBuyer(@PathVariable Long id, @RequestBody Buyer buyer) {
        Buyer updatedBuyer = buyerService.updateBuyer(id, buyer);
        return ResponseEntity.ok(updatedBuyer);
    }

    // 登录
    @PostMapping("/login/{username}/{passwordHash}")
    public ResponseEntity<Buyer> login(@PathVariable String username, @PathVariable String passwordHash) {
        Buyer buyer = buyerService.login(username, passwordHash);
        return ResponseEntity.ok(buyer);
    }
}

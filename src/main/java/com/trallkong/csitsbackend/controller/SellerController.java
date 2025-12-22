package com.trallkong.csitsbackend.controller;

import com.trallkong.csitsbackend.entity.Seller;
import com.trallkong.csitsbackend.service.SellerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    // 获取所有卖家
    @GetMapping
    public ResponseEntity<List<Seller>> getAllSellers() {
        List<Seller> sellers = sellerService.getAllSellers();
        return ResponseEntity.ok(sellers);
    }

    // 通过 id 获取卖家
    @GetMapping("/{id}")
    public ResponseEntity<Seller> getSellerById(@PathVariable Long id) {
        Seller seller = sellerService.getSellerById(id);
        return ResponseEntity.ok(seller);
    }

    // 通过用户名获取卖家
    @GetMapping("/username/{username}")
    public ResponseEntity<Seller> getSellerByUsername(@PathVariable String username) {
        Seller seller = sellerService.getSellerByUsername(username);
        return ResponseEntity.ok(seller);
    }

    // 添加卖家
    @PostMapping
    public ResponseEntity<Seller> addSeller(@RequestBody Seller seller) {
        Seller newSeller = sellerService.addSeller(seller);
        return ResponseEntity.ok(newSeller);
    }

    // 删除卖家
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeller(@PathVariable Long id) {
        sellerService.deleteSeller(id);
        return ResponseEntity.ok(null);
    }

    // 修改卖家信息
    @PutMapping("/{id}")
    public ResponseEntity<Seller> updateSeller(@PathVariable Long id, @RequestBody Seller seller) {
        Seller updatedSeller = sellerService.updateSeller(id, seller);
        return ResponseEntity.ok(updatedSeller);
    }

    // 登录
    @PostMapping("/login/{username}/{passwordHash}")
    public ResponseEntity<Seller> login(@PathVariable String username, @PathVariable String passwordHash) {
        Seller seller = sellerService.login(username, passwordHash);
        return ResponseEntity.ok(seller);
    }
}

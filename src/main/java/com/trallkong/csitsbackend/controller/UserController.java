package com.trallkong.csitsbackend.controller;

import com.trallkong.csitsbackend.entity.Buyer;
import com.trallkong.csitsbackend.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private BuyerService buyerService;

    @GetMapping
    public ResponseEntity<List<Buyer>> getAllUsers() {
        try {
            List<Buyer> buyers =  buyerService.getAllBuyers();
            if (buyers != null) {
                return ResponseEntity.ok(buyers);
            } else {
                return ResponseEntity.status(500).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Buyer> getUserById(@PathVariable Long id) {
        try {
            Buyer buyer = buyerService.getBuyerById(id);
            if (buyer != null) {
                return ResponseEntity.ok(buyer);
            } else {
                return ResponseEntity.status(500).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }

    }

    @PostMapping
    public ResponseEntity<Void> addUser(@RequestBody Buyer buyer) {
        try {
            buyerService.addBuyer(buyer);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        try {
            buyerService.deleteBuyer(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Buyer> updateUser(@PathVariable Long id, @RequestBody Buyer buyer) {
        try {
            Buyer updatedBuyer = buyerService.updateBuyer(id, buyer);
            if (updatedBuyer != null) {
                return ResponseEntity.ok(updatedBuyer);
            } else {
                return ResponseEntity.status(500).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
}

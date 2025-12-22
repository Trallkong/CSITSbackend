package com.trallkong.csitsbackend.service;

import com.trallkong.csitsbackend.entity.Buyer;
import com.trallkong.csitsbackend.repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyerService {

    @Autowired
    private BuyerRepository buyerRepository;

    // 获取所有买家
    public List<Buyer> getAllBuyers() {
        try {
            return buyerRepository.findAll();
        } catch (Exception e) {
            System.out.println("UserService-获取所有用户失败: " + e);
            throw e;
        }
    }

    // 通过 id 获取买家
    public Buyer getBuyerById(Long id) {
        try {
            return buyerRepository.findById(id).orElse(null);
        } catch (Exception e) {
            System.out.println("UserService-获取用户失败: " + e);
            throw e;
        }
    }

    // 添加买家
    public void addBuyer(Buyer buyer) {
        try {
            Long count = buyerRepository.count() + 1;
            buyer.setBuyerId(count);
            buyerRepository.save(buyer);
        } catch (Exception e) {
            System.out.println("UserService-添加用户失败: " + e);
            throw e;
        }
    }

    // 删除买家
    public void deleteBuyer(Long id) {
        try {
            buyerRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("UserService-删除用户失败: " + e);
            throw e;
        }
    }

    // 修改买家信息
    public Buyer updateBuyer(Long id, Buyer buyer) {
        try {
            buyer.setBuyerId(id);
            return buyerRepository.save(buyer);
        } catch (Exception e) {
            System.out.println("UserService-修改用户失败: " + e);
            throw e;
        }
    }
}

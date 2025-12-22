package com.trallkong.csitsbackend.service;

import com.trallkong.csitsbackend.entity.Buyer;
import com.trallkong.csitsbackend.repository.BuyerRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BuyerService {

    @Autowired
    private BuyerRepository buyerRepository;

    // 获取所有买家
    public List<Buyer> getAllBuyers() {
        try {
            return buyerRepository.findAll();
        } catch (Exception e) {
            log.error("BuyerService-获取所有买家失败: {}", String.valueOf(e));
            throw e;
        }
    }

    // 通过 id 获取买家
    public Buyer getBuyerById(Long id) {
        try {
            return buyerRepository.findById(id).orElse(null);
        } catch (Exception e) {
            log.error("BuyerService-根据id获取用户失败: {}", String.valueOf(e));
            throw e;
        }
    }

    // 通过用户名获取买家
    public Buyer getBuyerByUsername(String username) {
        try {
            return buyerRepository.findByUsername(username);
        } catch (Exception e) {
            log.error("BuyerService-根据username获取用户失败: {}", String.valueOf(e));
            throw e;
        }
    }

    // 添加买家
    public Buyer addBuyer(Buyer buyer) {
        try {
            Long count = buyerRepository.count() + 1;
            buyer.setBuyerId(count);
            return buyerRepository.save(buyer);
        } catch (Exception e) {
            log.error("BuyerService-添加用户失败: {}", String.valueOf(e));
            throw e;
        }
    }

    // 删除买家
    public void deleteBuyer(Long id) {
        try {
            buyerRepository.deleteById(id);
        } catch (Exception e) {
            log.error("BuyerService-删除用户失败: {}", String.valueOf(e));
            throw e;
        }
    }

    // 修改买家信息
    public Buyer updateBuyer(Long id, Buyer buyer) {
        try {
            buyer.setBuyerId(id);
            return buyerRepository.save(buyer);
        } catch (Exception e) {
            log.error("BuyerService-修改用户信息失败: {}", String.valueOf(e));
            throw e;
        }
    }

    // 登录
    @Transactional
    public Buyer login(String username, String passwordHash) {
        try {
            Buyer buyer = getBuyerByUsername(username);
            if (buyer != null) {
                if (buyer.getPasswordHash().equals(passwordHash)) {
                    log.info("BuyerService-登录成功");
                    return buyer;
                } else {
                    log.warn("BuyerService-密码错误");
                    throw new RuntimeException("密码错误");
                }
            } else {
                log.warn("BuyerService-用户不存在");
                throw new RuntimeException("用户不存在");
            }
        } catch (Exception e) {
            log.error("BuyerService-登录失败: {}", String.valueOf(e));
            throw e;
        }
    }
}

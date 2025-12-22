package com.trallkong.csitsbackend.service;

import com.trallkong.csitsbackend.entity.Seller;
import com.trallkong.csitsbackend.repository.SellerRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    // 获取所有卖家
    public List<Seller> getAllSellers() {
        try {
            return sellerRepository.findAll();
        } catch (Exception e) {
            log.error("SellerService-获取所有卖家失败: {}", String.valueOf(e));
            throw e;
        }
    }

    // 通过 id 获取卖家
    public Seller getSellerById(Long id) {
        try {
            return sellerRepository.findById(id).orElse(null);
        } catch (Exception e) {
            log.error("SellerService-根据id获取用户失败: {}", String.valueOf(e));
            throw e;
        }
    }

    // 通过用户名获取卖家
    public Seller getSellerByUsername(String username) {
        try {
            return sellerRepository.findByUsername(username);
        } catch (Exception e) {
            log.error("SellerService-根据username获取用户失败: {}", String.valueOf(e));
            throw e;
        }
    }

    // 添加卖家
    public Seller addSeller(Seller seller) {
        try {
            Long count = sellerRepository.count() + 1;
            seller.setSellerId(count);
            return sellerRepository.save(seller);
        } catch (Exception e) {
            log.error("SellerService-添加用户失败: {}", String.valueOf(e));
            throw e;
        }
    }

    // 删除卖家
    public void deleteSeller(Long id) {
        try {
            sellerRepository.deleteById(id);
        } catch (Exception e) {
            log.error("SellerService-删除用户失败: {}", String.valueOf(e));
            throw e;
        }
    }

    // 修改卖家信息
    public Seller updateSeller(Long id, Seller seller) {
        try {
            seller.setSellerId(id);
            return sellerRepository.save(seller);
        } catch (Exception e) {
            log.error("SellerService-修改用户信息失败: {}", String.valueOf(e));
            throw e;
        }
    }

    // 登录
    @Transactional
    public Seller login(String username, String passwordHash) {
        if (username.isEmpty() || passwordHash.isEmpty()) {
            log.error("SellerService-用户名或密码不能为空");
            throw new IllegalArgumentException("用户名或密码不能为空");
        }

        try {
            Seller seller = getSellerByUsername(username);
            if (seller != null) {
                if (passwordHash.equals(seller.getPasswordHash())) {
                    log.info("SellerService-登录成功");
                    return seller;
                } else {
                    log.warn("SellerService-密码错误");
                    throw new RuntimeException("密码错误");
                }
            } else {
                log.warn("SellerService-用户不存在");
                throw new RuntimeException("用户不存在");
            }
        } catch (Exception e) {
            log.error("SellerService-登录失败: {}", String.valueOf(e));
            throw e;
        }
    }
}

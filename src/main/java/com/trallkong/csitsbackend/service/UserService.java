package com.trallkong.csitsbackend.service;

import com.trallkong.csitsbackend.entity.Users;
import com.trallkong.csitsbackend.repository.UserRepository;
import com.trallkong.csitsbackend.security.CryptoUtils;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // 根据 id 获取用户
    public Users getUserById(Long id) {
        try {
            return userRepository.findById(id).orElse(null);
        } catch (Exception e) {
            log.error("UserService-根据id获取用户失败");
            throw new RuntimeException(e);
        }
    }

    // 添加用户
    public Users addUser(Users users) {
        try {
            return userRepository.save(users);
        } catch (Exception e) {
            log.error("UserService-添加用户失败");
            throw new RuntimeException(e);
        }
    }

    // 更新用户
    public Users updateUser(Long id, Users newUsers) {
        try {
            Users old = userRepository.findById(id).orElse(null);
            if (old == null) {
                log.info("UserService-更新用户失败，用户不存在");
                return null;
            }
            old.setUsername(newUsers.getUsername());
            old.setPasswordHash(newUsers.getPasswordHash());
            old.setIdCardHash(newUsers.getIdCardHash());
            old.setRealname(newUsers.getRealname());
            old.setPhone(newUsers.getPhone());
            old.setSchoolId(newUsers.getSchoolId());
            old.setAddress(newUsers.getAddress());
            old.setRating(newUsers.getRating());
            old.setRemark(newUsers.getRemark());
            return userRepository.save(old);
        } catch (Exception e) {
            log.error("UserService-更新用户失败");
            throw new RuntimeException(e);
        }
    }

    // 删除用户
    public void deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            log.error("UserService-删除用户失败");
            throw new RuntimeException(e);
        }
    }

    @Transactional
    public Users login(String username, String password) {
        try {
            Users users = userRepository.findByUsername(username);
            if (users == null) {
                log.info("UserService-用户不存在");
                throw new RuntimeException("用户不存在");
            }
            if (CryptoUtils.verify(users.getPasswordHash(), password)) {
                log.info("UserService-用户登录成功");
                return users;
            } else {
                log.info("UserService-用户密码错误");
                return null;
            }
        } catch (Exception e) {
            log.error("UserService-用户登录失败");
            throw new RuntimeException(e);
        }
    }

    @Transactional
    public Users register(Users newUsers) {
        try {
            if (userRepository.findByUsername(newUsers.getUsername()) != null) {
                log.info("UserService-用户已存在");
                throw new RuntimeException("用户已存在");
            }
            if (newUsers.getIdCardHash() == null || newUsers.getIdCardHash().isEmpty()) {
                log.error("UserService-身份证不能为空");
                return null;
            }

            // 加密身份证
            String hashcode1 = CryptoUtils.encrypt(newUsers.getIdCardHash());
            newUsers.setIdCardHash(hashcode1);
            log.info("id_card: {}",hashcode1);

            // 加密密码
            String hashcode2 = CryptoUtils.encrypt(newUsers.getPasswordHash());
            newUsers.setPasswordHash(CryptoUtils.encrypt(newUsers.getPasswordHash()));
            log.info("id_card: {}",hashcode2);

            return addUser(newUsers);
        } catch (Exception e) {
            log.error("UserService-注册新用户失败");
            throw new RuntimeException(e);
        }
    }
}

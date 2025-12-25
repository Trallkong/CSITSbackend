package com.trallkong.csitsbackend.service;

import com.trallkong.csitsbackend.entity.User;
import com.trallkong.csitsbackend.repository.UserRepository;
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
    public User getUserById(Long id) {
        try {
            return userRepository.findById(id).orElse(null);
        } catch (Exception e) {
            log.error("UserService-根据id获取用户失败");
            throw new RuntimeException(e);
        }
    }

    // 添加用户
    public User addUser(User user) {
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            log.error("UserService-添加用户失败");
            throw new RuntimeException(e);
        }
    }

    // 更新用户
    public User updateUser(Long id, User newUser) {
        try {
            User old = userRepository.findById(id).orElse(null);
            if (old == null) {
                log.info("UserService-更新用户失败，用户不存在");
                return null;
            }
            old.setUsername(newUser.getUsername());
            old.setPasswordHash(newUser.getPasswordHash());
            old.setIdCardHash(newUser.getIdCardHash());
            old.setRealname(newUser.getRealname());
            old.setPhone(newUser.getPhone());
            old.setSchoolId(newUser.getSchoolId());
            old.setAddress(newUser.getAddress());
            old.setRating(newUser.getRating());
            old.setRemark(newUser.getRemark());
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
    public User login(String username, String passwordHash) {
        try {
            User user = userRepository.findByUsername(username);
            if (user == null) {
                log.info("UserService-用户不存在");
                return null;
            }
            if (user.getPasswordHash().equals(passwordHash)) {
                log.info("UserService-用户登录成功");
                return user;
            } else {
                log.info("UserService-用户密码错误");
                return null;
            }
        } catch (Exception e) {
            log.error("UserService-用户登录失败");
            throw new RuntimeException(e);
        }
    }
}

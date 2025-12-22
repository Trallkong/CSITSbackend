package com.trallkong.csitsbackend.service;

import com.trallkong.csitsbackend.entity.Admin;
import com.trallkong.csitsbackend.repository.AdminRepository;
import com.trallkong.csitsbackend.security.CryptoUtils;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    // 获取所有管理员
    public List<Admin> getAllAdmins() {
        try {
            return adminRepository.findAll();
        } catch (Exception e) {
            System.out.println("AdminService-获取所有管理员失败: " + e);
            throw e;
        }
    }

    // 通过 id 获取管理员
    public Admin getAdminById(Long id) {
        try {
            return adminRepository.findById(id).orElse(null);
        } catch (Exception e) {
            System.out.println("AdminService-获取管理员失败: " + e);
            throw e;
        }
    }

    // 通过用户名获取管理员
    public Admin getAdminByUsername(String username) {
        try {
            return adminRepository.findByUsername(username);
        } catch (Exception e) {
            System.out.println("AdminService-获取管理员失败: " + e);
            throw e;
        }
    }

    // 添加管理员
    public void addAdmin(Admin admin) {
        try {
            adminRepository.save(admin);
        } catch (Exception e) {
            System.out.println("AdminService-添加管理员失败: " + e);
            throw e;
        }
    }

    // 删除管理员
    public void deleteAdmin(Long id) {
        try {
            adminRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("AdminService-删除管理员失败: " + e);
            throw e;
        }
    }

    // 修改管理员信息
    public Admin updateAdmin(Long id, Admin admin) {
        try {
            admin.setAdminId(id);
            return adminRepository.save(admin);
        } catch (Exception e) {
            System.out.println("AdminService-修改管理员失败: " + e);
            throw e;
        }
    }

    // 登录
    @Transactional
    public Admin login(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            System.out.println("AdminService-用户名或密码不能为空");
            throw new IllegalArgumentException("用户名或密码不能为空");
        }

        try {
            Admin admin = getAdminByUsername(username);
            if (admin != null) {
                boolean res = CryptoUtils.verify(admin.getPasswordHash(), password);
                if (res) {
                    System.out.println("AdminService-登录成功");
                    return admin;
                } else {
                    System.out.println("AdminService-密码错误");
                    throw new RuntimeException("密码错误");
                }
            } else {
                System.out.println("AdminService-用户不存在");
                throw new RuntimeException("用户不存在");
            }
        } catch (Exception e) {
            System.out.println("AdminService-登录失败: " + e);
            throw e;
        }
    }
}

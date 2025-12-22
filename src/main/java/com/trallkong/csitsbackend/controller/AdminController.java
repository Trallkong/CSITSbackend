package com.trallkong.csitsbackend.controller;

import com.trallkong.csitsbackend.entity.Admin;
import com.trallkong.csitsbackend.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // 登录
    @PostMapping("/login/{username}/{passwordHash}")
    public ResponseEntity<Admin> login(@PathVariable String username, @PathVariable String passwordHash) {
        Admin admin = adminService.login(username, passwordHash);
        return ResponseEntity.ok(admin);
    }
}

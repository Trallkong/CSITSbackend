package com.trallkong.csitsbackend.controller;

import com.trallkong.csitsbackend.entity.Users;
import com.trallkong.csitsbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("login/{username}/{passwordHash}")
    public ResponseEntity<Users> login(@PathVariable String username, @PathVariable String passwordHash) {
        Users users = userService.login(username, passwordHash);
        return ResponseEntity.ok(users);
    }

    @PostMapping("/register")
    public ResponseEntity<Users> register(@RequestBody Users users) {
        Users newUsers = userService.register(users);
        return ResponseEntity.ok(newUsers);
    }
}

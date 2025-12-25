package com.trallkong.csitsbackend.controller;

import com.trallkong.csitsbackend.entity.User;
import com.trallkong.csitsbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/{username}/{passwordHash}")
    public ResponseEntity<User> login(@PathVariable String username, @PathVariable String passwordHash) {
        User user = userService.login(username, passwordHash);
        return ResponseEntity.ok(user);
    }
}

package com.test.controller;

import com.test.config.JwtTokenUtil;
import com.test.model.UserModel;
import com.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<UserModel> createUser(@RequestBody UserModel user) {
        if (userService.existsByEmail(user.getEmail())) {
            return ResponseEntity.badRequest().build();
        }

        if (user.getPin() == null || user.getPin().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        // Hash the password before saving
        user.setPassword(userService.hashPassword(user.getPin()));

        UserModel savedUser = userService.saveUser(user);
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping("/{email}")
    public ResponseEntity<UserModel> getUserByEmail(@PathVariable String email) {
        Optional<UserModel> user = userService.getUserByEmail(email);
        return user.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}

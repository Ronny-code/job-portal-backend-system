package com.job.portal.controller;

import com.job.portal.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import com.job.portal.model.User;
import com.job.portal.GlobalExceptionHandler;
import com.job.portal.service.userService;

import java.util.List;
@Data
@Service
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = userService.createUser(user);
        return ResponseEntity.ok(savedUser);
    }
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }





}

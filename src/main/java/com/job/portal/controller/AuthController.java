package com.job.portal.controller;

import com.job.portal.dto.LoginRequestDto;
import com.job.portal.model.User;
import com.job.portal.repository.UserRepository;
import com.job.portal.security.JwtUtil;
import com.job.portal.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;


    @PostMapping("/login")
    public String login(@RequestBody User loginUser) {

        User user = userRepository.findByEmail(loginUser.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if(user.getPassword().equals(loginUser.getPassword())) {

            return jwtUtil.generateToken(user.getEmail(), user.getRole());

        }

        throw new RuntimeException("Invalid credentials");
    }
}



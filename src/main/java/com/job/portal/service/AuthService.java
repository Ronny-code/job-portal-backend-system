package com.job.portal.service;

import com.job.portal.dto.LoginRequestDto;
import com.job.portal.exception.ResourceNotFoundException;
import com.job.portal.model.User;
import com.job.portal.repository.UserRepository;
import com.job.portal.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    public String login(LoginRequestDto dto) {

        User user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("Invalid email or password"));

        if (!user.getPassword().equals(dto.getPassword())) {
            throw new ResourceNotFoundException("Invalid email or password");
        }

        return jwtUtil.generateToken(user.getEmail() , user.getRole());
    }
}

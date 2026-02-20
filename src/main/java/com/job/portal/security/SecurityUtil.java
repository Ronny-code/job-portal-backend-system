package com.job.portal.security;


import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class SecurityUtil {

    @Autowired
    private JwtUtil jwtUtil;

    public String getRole(HttpServletRequest request) {

        String token = request.getHeader("Authorization").substring(7);

        Claims claims = jwtUtil.extractClaims(token);

        return claims.get("role", String.class);
    }
}

package com.job.portal.controller;

import com.job.portal.model.Job;
import com.job.portal.model.User;
import com.job.portal.repository.JobRepository;
import com.job.portal.repository.UserRepository;
import com.job.portal.security.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }
    @PostMapping
    public Job createJob(@RequestBody Job job, HttpServletRequest request) {

        String authHeader = request.getHeader("Authorization");

        String token = authHeader.substring(7);

        String email = jwtUtil.extractEmail(token);

        User recruiter = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        job.setRecruiter(recruiter);

        return jobRepository.save(job);
    }
    @GetMapping("/my-jobs")
    public List<Job> getMyJobs(HttpServletRequest request) {

        String authHeader = request.getHeader("Authorization");

        String token = authHeader.substring(7);

        String email = jwtUtil.extractEmail(token);

        User recruiter = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return jobRepository.findByRecruiter(recruiter);
    }
}
package com.job.portal.controller;

import com.job.portal.model.Application;
import com.job.portal.model.Job;
import com.job.portal.model.User;
import com.job.portal.repository.ApplicationRepository;
import com.job.portal.repository.JobRepository;
import com.job.portal.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@Data
@RestController
@RequestMapping("/api/applications")

public class ApplicationController {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public Application apply (
        @RequestParam Long userId,
        @RequestParam Long jobId )
    {
        User user = userRepository.findById(userId).orElseThrow();
        Job job = jobRepository.findById(jobId).orElseThrow();

        Application app = new Application();
        app.setUser(user);
        app.setJob(job);
        app.setStatus("APPLIED");

        return applicationRepository.save(app);
    }


}

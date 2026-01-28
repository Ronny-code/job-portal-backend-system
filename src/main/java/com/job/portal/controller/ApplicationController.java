package com.job.portal.controller;

import com.job.portal.dto.ApplicationDto;
import com.job.portal.model.Application;
import com.job.portal.model.Job;
import com.job.portal.model.User;
import com.job.portal.repository.ApplicationRepository;
import com.job.portal.repository.JobRepository;
import com.job.portal.repository.UserRepository;
import com.job.portal.service.ApplicationService;
import com.job.portal.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Data
@RestController
@RequestMapping("/api/applications")

public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;



    @PostMapping
    public ResponseEntity<Application> apply(@RequestBody ApplicationDto dto) {
        return ResponseEntity.ok(applicationService.apply(dto));
    }


}

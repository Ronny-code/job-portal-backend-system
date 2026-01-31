package com.job.portal.service;

import com.job.portal.dto.ApplicationDto;
import com.job.portal.exception.ResourceNotFoundException;
import com.job.portal.mapper.ApplicationMapper;
import com.job.portal.model.Application;
import com.job.portal.model.Job;
import com.job.portal.model.User;
import com.job.portal.repository.ApplicationRepository;
import com.job.portal.repository.JobRepository;
import com.job.portal.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Data
@Service
public class ApplicationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private ApplicationMapper mapper;

    public Application apply(ApplicationDto dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Job job = jobRepository.findById(dto.getJobId())
                .orElseThrow(() -> new ResourceNotFoundException("Job not found"));

        Application app = mapper.toEntity(dto, user, job);
        return applicationRepository.save(app);
    }

}

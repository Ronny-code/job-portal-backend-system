package com.job.portal.mapper;

import com.job.portal.dto.ApplicationDto;
import com.job.portal.model.Application;
import org.springframework.stereotype.Component;
import com.job.portal.model.User;
import com.job.portal.model.Job;

@Component
public class ApplicationMapper {

    public Application toEntity(ApplicationDto dto, User user, Job job) {
        Application app = new Application();
        app.setUser(user);
        app.setJob(job);
        app.setStatus(dto.getStatus());
        return app;
    }
}

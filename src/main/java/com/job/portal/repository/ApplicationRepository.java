package com.job.portal.repository;

import com.job.portal.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository
extends JpaRepository<Application , Long> {
    List<Application> findByUserId(Long userId);

}

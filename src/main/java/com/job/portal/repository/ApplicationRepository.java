package com.job.portal.repository;

import com.job.portal.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository
extends JpaRepository<Application , Long> {
}

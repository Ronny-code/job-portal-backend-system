package com.job.portal.repository;
import com.job.portal.model.Job;

import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;



public interface JobRepository extends JpaRepository<Job , Long> {
}

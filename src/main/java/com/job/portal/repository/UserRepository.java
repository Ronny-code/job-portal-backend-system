package com.job.portal.repository;
import com.job.portal.model.User;



import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long> {
}

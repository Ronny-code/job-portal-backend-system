package com.job.portal.repository;
import com.job.portal.model.User;
import lombok.Data;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import com.job.portal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

}


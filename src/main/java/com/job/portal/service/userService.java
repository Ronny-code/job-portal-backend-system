package com.job.portal.service;
import com.job.portal.model.User;
import com.job.portal.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data

public class userService {
    @Autowired
    private UserRepository userRepository;

    public static User createUser(User user) {
        return userRepository.save(user);
    }

}

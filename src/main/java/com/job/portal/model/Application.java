package com.job.portal.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    private  String status;  //Applied , Accepted , Rejected

    public void setUser(User user) {
        this.user = user;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}

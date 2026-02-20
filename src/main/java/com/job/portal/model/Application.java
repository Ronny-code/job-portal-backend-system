package com.job.portal.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;


@Data
@Entity
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Setter
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    @Setter
    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    public void setJob(Job job) {
        this.job = job;
    }

    @Setter
    private  String status;  //Applied , Accepted , Rejected

    public void setStatus(String status) {
        this.status = status;
    }
}

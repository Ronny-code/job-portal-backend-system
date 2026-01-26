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
    private User user;

    @ManyToOne
    private Job job;

    private  String status;  //Applied , Accepted , Rejected

    public void setUser(User user){
        this.user = user;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}

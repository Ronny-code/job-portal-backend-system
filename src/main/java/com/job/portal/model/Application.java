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
    private User user;

    @ManyToOne
    private Job job;

    private  String status;  //Applied , Accepted , Rejected

}

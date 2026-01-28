package com.job.portal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;



@Entity
@Data

@Service

public class User {
    @Getter
    @Setter
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }


    public @NotBlank String getName() {
        return name;
    }

    public void setName(@NotBlank String name) {
        this.name = name;
    }

    public void setEmail(@Email String email) {
        this.email = email;
    }

    public @Email String getEmail() {
        return email;
    }

    @NotBlank
    private String name;


    @Email
    private String email;


    @NotBlank
    private String password;



}

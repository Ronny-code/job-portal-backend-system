package com.job.portal.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class UserDto {
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    private String email;

    public void setEmail(String email) {
        this.email = email;
    }
}

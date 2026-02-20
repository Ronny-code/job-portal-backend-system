package com.job.portal.dto;



import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Data
public class LoginRequestDto {

    private String email;

    public String getEmail() {
        return email;
    }

    private String password;

    public String getPassword() {
        return password;
    }
}

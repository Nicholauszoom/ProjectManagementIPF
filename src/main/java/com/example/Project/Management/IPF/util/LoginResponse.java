package com.example.Project.Management.IPF.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {
    private String token;
    private long expiresIn;

    public LoginResponse(String token, String expiresIn) {
        this.token = token;
        this.expiresIn = Long.parseLong(expiresIn);
    }
}
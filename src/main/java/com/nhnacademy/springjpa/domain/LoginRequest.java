package com.nhnacademy.springjpa.domain;

import javax.validation.constraints.NotBlank;

public class LoginRequest {
    @NotBlank
    private String userId;
    @NotBlank
    private String userPassword;
    public String getUserId() {
        return userId;
    }
    public String getUserPassword() {
        return userPassword;
    }
}
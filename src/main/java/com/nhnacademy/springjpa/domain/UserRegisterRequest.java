package com.nhnacademy.springjpa.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRegisterRequest {
    private String userId;
    private String userPassword;
    private String userName;
    private String userProfileFileName;
}

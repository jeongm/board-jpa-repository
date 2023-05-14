package com.nhnacademy.springjpa.domain;


import java.time.LocalDateTime;
import java.util.List;

public interface UserDto {
    Long getUserNumber();
    String getUserId();
    String getPassword();
    Integer getAge();
    String getName();
    Role getPosition();
    LocalDateTime getCreatedAt();
    String getProfileFileName();
    List<PostDto> getPosts();


}

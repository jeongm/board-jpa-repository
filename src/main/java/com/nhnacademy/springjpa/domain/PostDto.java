package com.nhnacademy.springjpa.domain;

import com.nhnacademy.springjpa.entity.User;

import java.time.LocalDateTime;

public interface PostDto {
    Long getId();
    String getTitle();
    String getContent();
    LocalDateTime createdAt();
    User user();

}

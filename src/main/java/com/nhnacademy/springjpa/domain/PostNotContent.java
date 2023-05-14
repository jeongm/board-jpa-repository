package com.nhnacademy.springjpa.domain;

import org.springframework.beans.factory.annotation.Value;

public interface PostNotContent {
    @Value("#{target.id}")
    Long getPostId();
    String getTitle();
}

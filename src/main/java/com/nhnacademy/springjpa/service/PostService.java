package com.nhnacademy.springjpa.service;


import com.nhnacademy.springjpa.domain.PostDto;
import com.nhnacademy.springjpa.domain.PostNotContent;
import com.nhnacademy.springjpa.entity.Post;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {
    List<PostNotContent> getPostByPage(Pageable pageable);
    PostDto getPostById(Long id);
}

package com.nhnacademy.springjpa.service;

import com.nhnacademy.springjpa.domain.PostDto;
import com.nhnacademy.springjpa.domain.PostNotContent;
import com.nhnacademy.springjpa.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service("postService")
public class PostServiceImpl implements PostService{
    private PostRepository postRepository;


    @Override
    public List<PostNotContent> getPostByPage(Pageable pageable) {
        List<PostNotContent> posts= postRepository.getAllBy(pageable).getContent();
        return posts;
    }

    @Override
    public PostDto getPostById(Long id) {
        return postRepository.findPostById(id);
    }








}

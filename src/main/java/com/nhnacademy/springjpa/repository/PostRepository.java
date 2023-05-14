package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.domain.PostDto;
import com.nhnacademy.springjpa.domain.PostNotContent;
import com.nhnacademy.springjpa.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {
    PostDto findPostById(Long id);
    //TODO 이거 할거임? 특정 사용자가 작성한 게시물 목록
    List<Post> findByUser_UserId(String userId);
    Page<PostNotContent> getAllBy(Pageable pageable);

}
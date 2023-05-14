package com.nhnacademy.springjpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;
//    @Setter
    private  String title;
//    @Setter
    private  String content;
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    // todo post 외래키
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}

package com.nhnacademy.springjpa.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Users")
public class User {
    @Id
    @Column(name="user_number")
    private Long userNumber;

    @Column(name = "user_id")
    private String userId;

    private String password;

    private Integer age;

    private String name;

    private String position;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "profile_src")
    private String userProfileFileName;

    @OneToMany(mappedBy = "user")
    private List<Post> post;

}

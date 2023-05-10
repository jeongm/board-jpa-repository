package com.nhnacademy.springjpa.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Users")
public class User {
    @Id
    @Column(name = "user_id")
    private String userId;

    private String password;

    private int age;

    private String name;

    @OneToMany(mappedBy = "user")
    private List<Post> post;

}

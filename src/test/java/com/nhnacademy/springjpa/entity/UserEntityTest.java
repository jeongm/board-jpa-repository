package com.nhnacademy.springjpa.entity;

import com.nhnacademy.springjpa.config.RootConfig;
import com.nhnacademy.springjpa.config.WebConfig;
import com.nhnacademy.springjpa.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@Transactional
@ContextHierarchy({
        @ContextConfiguration(classes = RootConfig.class),
        @ContextConfiguration(classes = WebConfig.class)
})
class UserEntityTest {
    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void testUserEntity(){
        User user = User.builder()
                .userNumber(3L)
                .userId("user")
                .password("user")
                .age(33)
                .name("username")
                .createdAt(LocalDateTime.now())
                .build();

        entityManager.persist(user);
        entityManager.flush();

        User user2 = entityManager.find(User.class, 3L);

        assertThat(user2).isEqualTo(user);

    }

}
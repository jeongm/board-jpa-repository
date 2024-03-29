package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.config.RootConfig;
import com.nhnacademy.springjpa.config.WebConfig;
import com.nhnacademy.springjpa.domain.UserDto;
import com.nhnacademy.springjpa.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@Transactional
@ContextHierarchy({
        @ContextConfiguration(classes = RootConfig.class),
        @ContextConfiguration(classes = WebConfig.class)
})
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testFindByUserId() {
        UserDto user1 = userRepository.findByUserId("admin");
        assertThat(user1.getUserId()).isEqualTo("admin");
    }

    @Test
    void testExistsByUserIdAndPassword() {
        boolean match = userRepository.existsByUserIdAndPassword("admin","12345");
        assertThat(match).isTrue();
    }

    @Test
    void testSave() {
        User user1 = User.builder()
                .userNumber(4L)
                .userId("user1")
                .password("user1")
                .age(23)
                .name("user1name")
                .createdAt(LocalDateTime.now())
                .build();
        userRepository.saveAndFlush(user1);
        UserDto user2 = userRepository.findByUserId("user1");
        assertThat(user2.getUserId()).isEqualTo(user1.getUserId());

    }

}
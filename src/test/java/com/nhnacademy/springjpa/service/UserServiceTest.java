package com.nhnacademy.springjpa.service;

import com.nhnacademy.springjpa.config.RootConfig;
import com.nhnacademy.springjpa.config.WebConfig;
import com.nhnacademy.springjpa.domain.UserDto;
import com.nhnacademy.springjpa.domain.UserNotDetail;
import com.nhnacademy.springjpa.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@Transactional
@ContextHierarchy({
        @ContextConfiguration(classes = RootConfig.class),
        @ContextConfiguration(classes = WebConfig.class)

})
class UserServiceTest {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    void existsUserById() {
        assertThat(userService.existsUserByUserId("admin")).isTrue();
    }

    @Test
    void getUserByUserId() {
        UserDto user = userService.getUserByUserId("admin");
        assertThat(user.getUserId()).isEqualTo("admin");
    }

    @Test
    void getUsers() {
        Pageable pageable = null;
        List<UserNotDetail> users = userService.getUsers(pageable);
        assertThat(users.size()).isEqualTo(6);

    }

    @Test
    void saveAndUpdateUser() {

    }

    @Test
    void deleteUser() {
    }

    @Test
    void matches() {
        boolean matchesResult = userService.matches("admin","12345");
        assertThat(matchesResult).isTrue();
    }
}
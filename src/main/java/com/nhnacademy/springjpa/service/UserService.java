package com.nhnacademy.springjpa.service;

import com.nhnacademy.springjpa.domain.UserDto;
import com.nhnacademy.springjpa.domain.UserNotDetail;
import com.nhnacademy.springjpa.domain.UserRegisterRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    // 아이디 중복 체크
    boolean existsUserByUserId(String id);
    UserDto getUserByUserId(String id);
    List<UserNotDetail> getUsers(Pageable pageable);
    // 등록 수정
    void saveAndUpdateUser(UserRegisterRequest userRegisterRequest);

    // 삭제
    void deleteUser(String id);

    // 아이디 비번 일치한지 확인
    boolean matches(String id, String password);

}

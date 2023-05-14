package com.nhnacademy.springjpa.service;

import com.nhnacademy.springjpa.domain.UserDto;
import com.nhnacademy.springjpa.domain.UserNotDetail;
import com.nhnacademy.springjpa.domain.UserRegisterRequest;
import com.nhnacademy.springjpa.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;


import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public boolean existsUserByUserId(String userId) {
        return userRepository.existsByUserId(userId);
    }

    @Override
    public UserDto getUserByUserId(String userId) {
        return userRepository.findByUserId(userId);
    }

    @Override
    public List<UserNotDetail> getUsers(Pageable pageable) {
        return userRepository.getAllBy(pageable).getContent();
    }

    @Override
    public void saveAndUpdateUser(UserRegisterRequest userRegisterRequest) {
        // TODO 저장 업뎃
    }

    @Override
    public void deleteUser(String userId) {
        userRepository.deleteByUserId(userId);
    }

    @Override
    public boolean matches(String id, String password) {
        return userRepository.existsByUserIdAndPassword(id,password);
    }

}

package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.domain.UserDto;
import com.nhnacademy.springjpa.domain.UserNotDetail;
import com.nhnacademy.springjpa.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    UserDto findByUserId(String id);
    boolean existsByUserId(String id);
    boolean existsByUserIdAndPassword(String id, String password);
    Page<UserNotDetail> getAllBy(Pageable pageable);
    void deleteByUserId(String userId);


}

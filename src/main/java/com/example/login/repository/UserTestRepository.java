package com.example.login.repository;


import com.example.login.entity.UserEntity;
import com.example.login.entity.WorkMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserTestRepository extends JpaRepository<UserEntity, Integer> {

    Boolean existsByUsername(String username);

    //username을 받아 DB 테이블에서 회원을 조회하는 메소드 작성
    UserEntity findByUsername(String username);
}

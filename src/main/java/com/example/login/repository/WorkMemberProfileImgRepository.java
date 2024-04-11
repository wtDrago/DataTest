package com.example.login.repository;

import com.example.login.entity.WorkMember;
import com.example.login.entity.WorkMemberProfileImg;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkMemberProfileImgRepository extends JpaRepository<WorkMemberProfileImg, Integer> {
    List<WorkMemberProfileImg> findByState(int state);
}

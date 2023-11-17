package com.example.login.repository;


import com.example.login.entity.WorkMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<WorkMember, Integer> {
}

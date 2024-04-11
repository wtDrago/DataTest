package com.example.login.repository;

import com.example.login.entity.WorkTeam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkTeamRepository extends JpaRepository<WorkTeam, Integer> {
    List<WorkTeam> findByState(int state);
}

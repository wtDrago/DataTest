package com.example.login.repository;

import com.example.login.entity.WorkDataLog;
import com.example.login.entity.WorkTodayWork;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkDataLogRepository extends JpaRepository<WorkDataLog, Integer> {
}

package com.example.login.repository;

import com.example.login.entity.WorkTodayWork;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamWorkCountRepository extends JpaRepository<WorkTodayWork, Integer> {
    List<WorkTodayWork> findByCompanyNoAndEmailAndWorkDate(int companyNo, String email, String getTodayDate);
}

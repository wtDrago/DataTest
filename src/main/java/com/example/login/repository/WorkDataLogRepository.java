package com.example.login.repository;

import com.example.login.dto.WorkDataLogDto;
import com.example.login.entity.WorkDataLog;
import com.example.login.entity.WorkTodayWork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface WorkDataLogRepository extends JpaRepository<WorkDataLog, Integer> {
//    List<WorkDataLog> findByState(int state);

    @Query("SELECT w FROM WorkDataLog w WHERE w.state = :state AND w.email = :email AND DATE(w.workDate) = CURRENT_DATE")
    List<WorkDataLog> findByStateAndWorkDateAndEmail(@Param("state") int state, @Param("email") String email);
}

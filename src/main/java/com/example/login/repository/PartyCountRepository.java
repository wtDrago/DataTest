package com.example.login.repository;


import com.example.login.entity.WorkTodayWorkProject;
import com.example.login.entity.WorkTodayWorkProjectUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartyCountRepository extends JpaRepository<WorkTodayWorkProject, Integer> {
    List<WorkTodayWorkProject> findByCompanyNoAndEmailAndState(Long companyNo, String email, Integer state);
}

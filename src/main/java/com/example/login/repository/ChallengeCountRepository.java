package com.example.login.repository;


import com.example.login.entity.WorkChallenges;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChallengeCountRepository extends JpaRepository<WorkChallenges, Integer> {
    List<WorkChallenges> findByCompanyNoAndEmailAndStateAndCoachingChkAndViewFlagAndTempFlagAndTemplate(Long companyNo, String email, Integer state, Integer coachingChk, Integer viewFlag, Integer tempFlag, Integer template);
}

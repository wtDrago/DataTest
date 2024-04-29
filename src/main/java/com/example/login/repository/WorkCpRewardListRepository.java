package com.example.login.repository;

import com.example.login.entity.WorkCpRewardList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkCpRewardListRepository extends JpaRepository<WorkCpRewardList, Long> {
//    List<WorkCpRewardList> findByStateAndEmailAndWorkDateBetween(int state, String email, String firstDateOfMonth, String lastDateOfMonth);

    @Query("SELECT CAST(SUM(w.type1)AS INTEGER), CAST(SUM(w.type2) AS INTEGER), " +
        "CAST(SUM(w.type3) AS INTEGER), CAST(SUM(w.type4) AS INTEGER), " +
        "CAST(SUM(w.type5) AS INTEGER), CAST(SUM(w.type6) AS INTEGER), " +
        "w.email, w.name " +
        "FROM WorkCpRewardList w " +
        "WHERE w.state = ?1 AND w.email = ?2 AND w.workDate BETWEEN ?3 AND ?4 " +
        "GROUP BY w.email, w.name")
    List<Object[]> sumTypeByStateAndEmailAndDate(int state, String email, String firstDateOfMonth, String lastDateOfMonth);

}

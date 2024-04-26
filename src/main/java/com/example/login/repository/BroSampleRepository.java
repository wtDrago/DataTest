package com.example.login.repository;


import com.example.login.entity.BroSample;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface BroSampleRepository extends JpaRepository<BroSample, Integer> {
    List<BroSample> findByStateAndTitleContaining(int state, String search);

    List<BroSample> findByStateAndIdx(int state, int idx);

    @Query("SELECT bs FROM BroSample bs WHERE bs.idx > :idx AND bs.state = :state ORDER BY bs.idx ASC")
    List<BroSample> findClosestNextByIdxAndState(@Param("idx") int idx, int state,Pageable pageable);

    @Query("SELECT bs FROM BroSample bs WHERE bs.idx < :idx AND bs.state = :state ORDER BY bs.idx DESC")
    List<BroSample> findClosestPreviousByIdxAndState(@Param("idx") int idx, int state, Pageable pageable);
}

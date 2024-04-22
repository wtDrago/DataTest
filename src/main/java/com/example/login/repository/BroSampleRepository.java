package com.example.login.repository;


import com.example.login.entity.BroSample;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BroSampleRepository extends JpaRepository<BroSample, Integer> {
    List<BroSample> findByState(int state);
}

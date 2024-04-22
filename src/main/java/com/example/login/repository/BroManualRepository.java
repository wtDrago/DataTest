package com.example.login.repository;


import com.example.login.entity.BroManual;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BroManualRepository extends JpaRepository<BroManual, Integer> {
    List<BroManual> findByStateAndService(int state, String service);
}

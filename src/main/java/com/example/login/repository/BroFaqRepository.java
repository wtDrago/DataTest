package com.example.login.repository;


import com.example.login.entity.BroFaq;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BroFaqRepository extends JpaRepository<BroFaq, Integer> {
//    List<BroFaq> findByState(int state);
//    Page<BroFaq> findByState(int state, Pageable pageable);
    Page<BroFaq> findByStateAndTitleContaining(int state, String search, Pageable pageable);
}

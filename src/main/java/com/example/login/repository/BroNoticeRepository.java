package com.example.login.repository;


import com.example.login.entity.BroNotice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BroNoticeRepository extends JpaRepository<BroNotice, Integer> {
//    List<BroNotice> findByState(int state);
    Page<BroNotice> findByState(int stat, Pageable pageable);
}

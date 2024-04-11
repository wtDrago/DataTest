package com.example.login.repository;

import com.example.login.entity.WorkCompany;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkCompanyRepository extends JpaRepository<WorkCompany, Integer> {
    List<WorkCompany> findByState(int state);
}

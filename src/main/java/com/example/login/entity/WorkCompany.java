package com.example.login.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "work_company")
public class WorkCompany {

    @Id
    private Integer idx;

    private Integer state;
    private String email;
    private String name;
    private String company;
    @Column(name = "company_num", nullable = false)
    private String companyNum;
    private String logo;
    private String code;
    private Integer comCoin;
    @Column(columnDefinition = "TEXT")
    private String memo;
    private String people;
    @Column(name = "payment_type", nullable = false)
    private String paymentType;
    @Column(name = "pay_stime", nullable = false)
    private String payStime;
    @Column(name = "pay_rtime", nullable = false)
    private String payRtime;
    @Column(name = "pay_etime", nullable = false)
    private String payEtime;
    @Column(name = "editdate", nullable = false)
    private LocalDateTime editData;
    @Column(name = "regdate", nullable = false)
    private LocalDateTime regData;
    private Integer penalty;
    @Column(name = "penalty_in", nullable = false)
    private Integer penaltyIn;
    @Column(name = "penalty_work", nullable = false)
    private Integer penaltyWork;
    @Column(name = "penalty_out", nullable = false)
    private Integer penaltyOut;
    @Column(name = "penalty_challenge", nullable = false)
    private Integer penaltyChallenge;
    @Column(name = "intime", nullable = false)
    private LocalDateTime inTime;
    @Column(name = "outtime", nullable = false)
    private LocalDateTime outTime;



}

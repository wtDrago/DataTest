package com.example.login.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "work_cp_reward_list")
public class WorkCpRewardList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private Integer state;
    private String email;
    private String name;
    private Integer companyno;
    private Long workIdx;
    private Long linkIdx;
    private String service;
    private String act;
    private Integer type1;
    private Integer type2;
    private Integer type3;
    private Integer type4;
    private Integer type5;
    private Integer type6;
    private String memo;
    private String ip;
    private String workDate;
    private LocalDateTime editDate;
    private LocalDateTime regDate;

}
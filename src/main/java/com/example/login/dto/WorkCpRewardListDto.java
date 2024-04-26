package com.example.login.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class WorkCpRewardListDto {
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

    public WorkCpRewardListDto(Long idx, String email, String name){
        this.idx = idx;
        this.email = email;
        this.name = name;

    }
}

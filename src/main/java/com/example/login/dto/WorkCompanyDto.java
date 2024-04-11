package com.example.login.dto;


import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class WorkCompanyDto {
    private Integer idx;

    private Integer state;
    private String email;
    private String name;
    private String company;
    private String companyNum;
    private String logo;
    private String code;
    private Integer comCoin;
    private String memo;
    private String people;
    private String paymentType;
    private String payStime;
    private String payRtime;
    private String payEtime;
    private Integer penalty;
    private Integer penaltyIn;
    private Integer penaltyWork;
    private Integer penaltyOut;
    private Integer penaltyChallenge;
    private LocalDateTime inTime;
    private LocalDateTime outTime;

    public WorkCompanyDto(Integer idx,Integer state,String email,String name,
                          String company,String companyNum,String logo,String code,Integer comCoin,
                          String memo,String people,String paymentType,String payStime,String payRtime,
                          String payEtime,Integer penalty,Integer penaltyIn,Integer penaltyWork,
                          Integer penaltyOut,Integer penaltyChallenge,LocalDateTime inTime,LocalDateTime outTime) {
        this.idx = idx;
        this.state = state;
        this.email = email;
        this.name = name;
        this.company = company;
        this.companyNum = companyNum;
        this.logo = logo;
        this.code = code;
        this.comCoin = comCoin;
        this.memo = memo;
        this.people = people;
        this.paymentType = paymentType;
        this.payStime = payStime;
        this.payRtime = payRtime;
        this.payEtime = payEtime;
        this.penalty = penalty;
        this.penaltyIn = penaltyIn;
        this.penaltyWork = penaltyWork;
        this.penaltyOut = penaltyOut;
        this.penaltyChallenge = penaltyChallenge;
        this.inTime = inTime;
        this.outTime = outTime;

    }
}

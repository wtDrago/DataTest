package com.example.login.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class WorkTodayWorkProjectDto {
    private Long idx;
    private int state;
    private int companyNo;
    private int partFlag;
    private int sort;
    private String email;
    private String name;
    private String part;
    private String title;
    private String ip;
    private Date editDate;
    private Date regDate;
    private String endDate;
    private Long comCoinPro;
    private Long partyLink;
    private int pageCount;

    public WorkTodayWorkProjectDto(){

    }
}

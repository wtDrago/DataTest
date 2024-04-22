package com.example.login.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class WorkDataLogDto {
    private int idx;
    private byte state;
    private int code;
    private int workIdx;
    private int linkIdx;
    private byte companyNo;
    private String email;
    private String name;
    private String sendEmail;
    private String sendName;
    private int coin;
    private String memo;
    private int workCount;
    private String workFlag;
    private String kindFlag;
    private byte readFlag;
    private byte typeFlag;
    private String ip;
    private String workDate;
    private Date editDate;
    private Date regDate;
    private Date readDate;

    public WorkDataLogDto(int idx, byte state, int code, int workIdx, int linkIdx,
                          byte companyNo, String email, String name, String sendEmail,
                          String sendName, int coin, String memo, int workCount, String workFlag,
                          String kindFlag, byte readFlag, byte typeFlag, String ip, String workDate,
                          Date editDate, Date regDate, Date readDate){

        this.idx = idx;
        this.state = state;
        this.code = code;
        this.workIdx = workIdx;
        this.linkIdx = linkIdx;
        this.companyNo = companyNo;
        this.email = email;
        this.name = name;
        this.sendEmail = sendEmail;
        this.sendName = sendName;
        this.coin = coin;
        this.memo = memo;
        this.workCount = workCount;
        this.workFlag = workFlag;
        this.kindFlag = kindFlag;
        this.readFlag = readFlag;
        this.typeFlag = typeFlag;
        this.ip = ip;
        this.workDate = workDate;
        this.editDate = editDate;
        this.regDate = regDate;
        this.readDate = readDate;
    }
}

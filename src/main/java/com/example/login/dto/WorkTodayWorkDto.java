package com.example.login.dto;


import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class WorkTodayWorkDto {
    private int idx;
    private byte state;
    private int companyNo;
    private byte highLevel;
    private byte dayFlag;
    private byte workFlag;
    private short partFlag;
    private byte typeFlag;
    private byte repeatFlag;
    private byte fileFlag;
    private byte readFlag;
    private long repeatWorkIdx;
    private int sort;
    private byte memoView;
    private byte contentsView;
    private int changeDate;
    private byte decideFlag;
    private byte secretFlag;
    private byte noticeFlag;
    private byte shareFlag;
    private int workIdx;
    private String email;
    private String name;
    private String part;
    private String title;
    private String contents;
    private String contents1;
    private String reqDate;
    private String workStartTime;
    private String workEndTime;
    private String memo;
    private String ip;
    private String workDate;
    private Date readDate;
    private Date editDate;
    private Date regDate;
    private int partyLink;
    private int partyIdx;
    private int alarmFlag;
    private Date alarmDate;
    public WorkTodayWorkDto(int idx, byte state, int companyNo, byte highLevel, byte dayFlag, byte workFlag, short partFlag,
                            byte typeFlag, byte repeatFlag, byte fileFlag, byte readFlag, long repeatWorkIdx, int sort,
                            byte memoView, byte contentsView, int changeDate, byte decideFlag, byte secretFlag, byte noticeFlag,
                            byte shareFlag, int workIdx, String email, String name, String part, String title, String contents,
                            String contents1, String reqDate, String workStartTime, String workEndTime, String memo, String ip,
                            String workDate, Date readDate, Date editDate, Date regDate, int partyLink, int partyIdx,
                            int alarmFlag, Date alarmDate){
        this.idx = idx;
        this.state = state;
        this.companyNo = companyNo;
        this.highLevel = highLevel;
        this.dayFlag = dayFlag;
        this.workFlag = workFlag;
        this.partFlag = partFlag;
        this.typeFlag = typeFlag;
        this.repeatFlag = repeatFlag;
        this.fileFlag = fileFlag;
        this.readFlag = readFlag;
        this.repeatWorkIdx = repeatWorkIdx;
        this.sort = sort;
        this.memoView = memoView;
        this.contentsView = contentsView;
        this.changeDate = changeDate;
        this.decideFlag = decideFlag;
        this.secretFlag = secretFlag;
        this.noticeFlag = noticeFlag;
        this.shareFlag = shareFlag;
        this.workIdx = workIdx;
        this.email = email;
        this.name = name;
        this.part = part;
        this.title = title;
        this.contents = contents;
        this.contents1 = contents1;
        this.reqDate = reqDate;
        this.workStartTime = workStartTime;
        this.workEndTime = workEndTime;
        this.memo = memo;
        this.ip = ip;
        this.workDate = workDate;
        this.readDate = readDate;
        this.editDate = editDate;
        this.regDate = regDate;
        this.partyLink = partyLink;
        this.partyIdx = partyIdx;
        this.alarmFlag = alarmFlag;
        this.alarmDate = alarmDate;
    }
}

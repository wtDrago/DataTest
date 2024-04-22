package com.example.login.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.Date;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "work_todaywork")
public class WorkTodayWork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    private int idx;

    @Column(name = "state")
    private byte state;

    @Column(name = "companyno")
    private int companyNo;

    @Column(name = "highlevel")
    private byte highLevel;

    @Column(name = "day_flag")
    private byte dayFlag;

    @Column(name = "work_flag")
    private byte workFlag;

    @Column(name = "part_flag")
    private short partFlag;

    @Column(name = "type_flag")
    private byte typeFlag;

    @Column(name = "repeat_flag")
    private byte repeatFlag;

    @Column(name = "file_flag")
    private byte fileFlag;

    @Column(name = "read_flag")
    private byte readFlag;

    @Column(name = "repeat_work_idx")
    private long repeatWorkIdx;

    @Column(name = "sort")
    private int sort;

    @Column(name = "memo_view")
    private byte memoView;

    @Column(name = "contents_view")
    private byte contentsView;

    @Column(name = "change_date")
    private int changeDate;

    @Column(name = "decide_flag")
    private byte decideFlag;

    @Column(name = "secret_flag")
    private byte secretFlag;

    @Column(name = "notice_flag")
    private byte noticeFlag;

    @Column(name = "share_flag")
    private byte shareFlag;

    @Column(name = "work_idx")
    private int workIdx;

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "part")
    private String part;

    @Column(name = "title")
    private String title;

    @Column(name = "contents")
    private String contents;

    @Column(name = "contents1")
    private String contents1;

    @Column(name = "req_date")
    private String reqDate;

    @Column(name = "work_stime")
    private String workStartTime;

    @Column(name = "work_etime")
    private String workEndTime;

    @Column(name = "memo")
    private String memo;

    @Column(name = "ip")
    private String ip;

    @Column(name = "workdate")
    private String workDate;

    @Column(name = "readdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date readDate;

    @Column(name = "editdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date editDate;

    @Column(name = "regdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date regDate;

    @Column(name = "party_link")
    private int partyLink;

    @Column(name = "party_idx")
    private int partyIdx;

    @Column(name = "alram_flag")
    private int alarmFlag;

    @Column(name = "alram_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date alarmDate;



}

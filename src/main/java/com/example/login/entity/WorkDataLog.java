package com.example.login.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "work_data_log")
public class WorkDataLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    private int idx;

    @Column(name = "state")
    private byte state;

    @Column(name = "code")
    private int code;

    @Column(name = "work_idx")
    private int workIdx;

    @Column(name = "link_idx")
    private int linkIdx;

    @Column(name = "companyno")
    private byte companyNo;

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "send_email")
    private String sendEmail;

    @Column(name = "send_name")
    private String sendName;

    @Column(name = "coin")
    private int coin;

    @Column(name = "memo")
    private String memo;

    @Column(name = "work_cnt")
    private Integer workCnt;

    @Column(name = "work_flag")
    private String workFlag;

    @Column(name = "kind_flag")
    private String kindFlag;

    @Column(name = "read_flag")
    private byte readFlag;

    @Column(name = "type_flag")
    private byte typeFlag;

    @Column(name = "ip")
    private String ip;

    @Column(name = "workdate")
    private String workDate;

    @Column(name = "editdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date editDate;

    @Column(name = "regdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date regDate;

    @Column(name = "readdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date readDate;



}

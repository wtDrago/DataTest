package com.example.login.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Getter
@Entity
@Table(name = "work_todaywork_project_user")
public class WorkTodayWorkProjectUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(name = "state")
    private int state;

    private Long projectIdx;

    @Column(name = "companyno")
    private int companyNo;

    @Column(name = "part_flag")
    private int partFlag;

    @Column(name = "sort")
    private Long sort;

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "part")
    private String part;

    @Column(name = "ip")
    private String ip;

    @Column(name = "editdate")
    private Date editDate;

    @Column(name = "regdate")
    private Date regDate;

    @Column(name = "party_link")
    private Long partyLink;

    @Column(name = "party_read_flag")
    private int partyReadFlag;

    @Column(name = "party_read_date")
    private Date partyReadDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_idx", referencedColumnName = "idx")
    private WorkTodayWorkProject workTodayWorkProject;
}

package com.example.login.entity;


import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
@Entity
@Table(name = "work_todaywork_project")
public class WorkTodayWorkProject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(name = "state")
    private int state;

    @Column(name = "companyno")
    private int companyNo;

    @Column(name = "part_flag")
    private int partFlag;

    @Column(name = "sort")
    private Integer sort;

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "part")
    private String part;

    @Column(name = "title")
    private String title;

    @Column(name = "ip")
    private String ip;

    @Column(name = "editdate")
    private Date editDate;

    @Column(name = "regdate")
    private Date regDate;

    @Column(name = "enddate")
    private String endDate;

    @Column(name = "com_coin_pro")
    private Long comCoinPro;

    @Column(name = "party_link")
    private Long partyLink;

    @Column(name = "page_count")
    private int pageCount;

    @OneToMany(mappedBy = "workTodayWorkProject")
    private List<WorkTodayWorkProjectUser> workTodayWorkProjectUsers;
}

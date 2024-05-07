package com.example.login.entity;


import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Entity
@Table(name = "work_challenges")
public class WorkChallenges {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private Integer state;
    @Column(name = "attend_type")
    private Integer attendType;
    private Integer cate;
    private Long companyNo;
    private String email;
    private String name;
    private Long coin;
    private String title;
    private String sDate;
    private String eDate;
    private Integer template;
    private Integer attend;
    @Column(name= "day_type")
    private Integer dayType;
    @Column(name= "holiday_chk")
    private Integer holidayChk;
    @Column(name= "attend_chk")
    private Integer attendChk;
    @Column(name= "coin_maxchk")
    private Integer coinMaxChk;
    @Column(name= "coin_not")
    private Integer coinNot;
    @Column(name= "coaching_chk")
    private Integer coachingChk;
    private Integer week;
    private Long pageView;
    private Integer suggestion;
    private Integer outputChk;
    @Column(name = "temp_flag")
    private Integer tempFlag;
    @Column(name = "type_flag")
    private Integer typeFlag;
    @Column(name = "view_flag")
    private Integer viewFlag;
    @Column(name = "files_idx")
    private Long filesIdx;
    @Column(name = "files_name")
    private String filesName;
    private String keyword;
    private String action2;
    private String action3;
    private String action4;
    private String action5;
    private String ip;
    private LocalDateTime editDate;
    private LocalDateTime regDate;
    @Column(name = "total_max_coin")
    private Long totalMaxCoin;
    @Column(name = "limit_count")
    private Integer limitCount;


    @OneToMany(mappedBy = "workChallenges", fetch = FetchType.LAZY)
    private List<WorkChallengesUer> workChallengesUers;

}

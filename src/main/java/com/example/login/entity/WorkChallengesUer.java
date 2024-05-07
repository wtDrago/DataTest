package com.example.login.entity;


import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Entity
@Table(name = "work_challenges_user")
public class WorkChallengesUer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;


    private Long challengesIdx;

    private Integer state;
    private Long companyNo;
    private String email;
    private String name;
    private String ip;
    private LocalDateTime editDate;
    private LocalDateTime regDate;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "challenges_idx", referencedColumnName = "idx")
    private WorkChallenges workChallenges;
}

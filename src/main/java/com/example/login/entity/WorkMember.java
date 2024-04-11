package com.example.login.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "work_member")
public class WorkMember {

    @Id
    private Integer idx;

    private Integer state;
    private String email;
    private String name;
    @Column(name = "password", nullable = false)
    private String passWord;
    @Column(name = "highlevel", nullable = false)
    private Integer highLevel;
    private String company;
    @Column(name = "companyno", nullable = false)
    private Integer companyNo;
    private String part;
    @Column(name = "partno", nullable = false)
    private Integer partNo;
    private Integer gender;
    private Integer profileType;
    private Integer profileImgIdx;
    @Column(name = "live_1", nullable = false)
    private Integer live1;
    @Column(name = "live_2", nullable = false)
    private Integer live2;
    @Column(name = "live_3", nullable = false)
    private Integer live3;
    @Column(name = "live_4", nullable = false)
    private Integer live4;
    private Integer grade;
    private Integer coin;
    @Column(name = "comcoin", nullable = false)
    private Integer comCoin;
    @Column(name = "birthday", nullable = false)
    private String birthDay;
    @Column(nullable = false)
    private String addr1;
    @Column(nullable = false)
    private String addr2;
    @Column(name = "zipcode", nullable = false)
    private String zipCode;
    @Column(nullable = false)
    private String phone;
    private String ip;

    @Column(columnDefinition = "TEXT")
    private String memo;
    private Integer loginCount;
    @Column(name = "live_1_regdate", nullable = false)
    private LocalDateTime live1RegData;
    @Column(name = "live_2_regdate", nullable = false)
    private LocalDateTime live2RegData;
    @Column(name = "live_3_regdate", nullable = false)
    private LocalDateTime live3RegData;
    @Column(name = "live_4_regdate", nullable = false)
    private LocalDateTime live4RegData;
    private LocalDateTime loginDate;
    @Column(name = "editdate", nullable = false)
    private LocalDateTime editData;
    @Column(name = "regdate", nullable = false)
    private LocalDateTime regData;
    private Integer sendMailCnt;
    @Column(nullable = false)
    private String senderEmail;
    @Column(nullable = false)
    private String senderName;
    @Column(nullable = false)
    private String receiveEmail;
    @Column(nullable = false)
    private String receiveName;
    @Column(nullable = false)
    private String senderIp;
    @Column(nullable = false)
    private String receiveIp;
    @Column(nullable = false)
    private LocalDateTime mailChkDate;
    @Column(name = "mail_send_regdate", nullable = false)
    private LocalDateTime mailSendRegDate;
    @Column(name = "t_flag")
    private Integer tFlag;
    private Integer challAuth;
    private Integer adminAuth;
    private Integer coinAuth;
    private Integer allAuth;
    @Column(name = "week_incount", nullable = false)
    private Integer weekInCount;
    private Integer penaltyState;
}

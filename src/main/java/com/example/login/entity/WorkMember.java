package com.example.login.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

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
    @Column(name = "profile_type", nullable = false)
    private Integer profileType;
    @Column(name = "profile_img_idx", nullable = false)
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
    @Column(name = "login_count")
    private Integer loginCount;
    @Column(name = "live_1_regdate", nullable = false)
    private LocalDateTime live1RegData;
    @Column(name = "live_2_regdate", nullable = false)
    private LocalDateTime live2RegData;
    @Column(name = "live_3_regdate", nullable = false)
    private LocalDateTime live3RegData;
    @Column(name = "live_4_regdate", nullable = false)
    private LocalDateTime live4RegData;
    @Column(name = "login_date")
    private LocalDateTime loginDate;
    @Column(name = "editdate", nullable = false)
    private LocalDateTime editData;
    @Column(name = "regdate", nullable = false)
    private LocalDateTime regData;
    @Column(name = "send_mail_cnt")
    private Integer sendMailCnt;
    @Column(name = "sender_email", nullable = false)
    private String senderEmail;
    @Column(name = "sender_name", nullable = false)
    private String senderName;
    @Column(name = "receive_email", nullable = false)
    private String receiveEmail;
    @Column(name = "receive_name", nullable = false)
    private String receiveName;
    @Column(name = "sender_ip", nullable = false)
    private String senderIp;
    @Column(name = "receive_ip", nullable = false)
    private String receiveIp;
    @Column(name = "mail_chk_date", nullable = false)
    private LocalDateTime mailChkDate;
    @Column(name = "mail_send_regdate", nullable = false)
    private LocalDateTime mailSendRegDate;
    @Column(name = "t_flag")
    private Integer tFlag;
    @Column(name = "chall_auth")
    private Integer challAuth;
    @Column(name = "admin_auth")
    private Integer adminAuth;
    @Column(name = "coin_auth")
    private Integer coinAuth;
    @Column(name = "all_auth")
    private Integer allAuth;
    @Column(name = "week_incount", nullable = false)
    private Integer weekInCount;
    @Column(name = "penalty_state", nullable = false)
    private Integer penaltyState;

    @OneToMany(mappedBy = "workMember", fetch = FetchType.LAZY)
    private List<WorkMemberProfileImg> profileImages;
}

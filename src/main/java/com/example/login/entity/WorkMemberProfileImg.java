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
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "work_member_profile_img")
public class WorkMemberProfileImg {
    @Id
    private Integer idx;
    private Integer state;
    @Column(name = "mem_idx", nullable = false)
    private Integer memIdx;
    @Column(name = "companyno", nullable = false)
    private Integer companyNo;
    @Column(name = "resize", nullable = false)
    private Integer reSize;
    private Integer email;
    @Column(name = "file_path", nullable = false)
    private String filePath;
    @Column(name = "file_name", nullable = false)
    private String fileName;
    @Column(name = "file_size", nullable = false)
    private Integer fileSize;
    @Column(name = "file_ori_path", nullable = false)
    private String fileOriPath;
    @Column(name = "file_ori_name", nullable = false)
    private String fileOriName;
    @Column(name = "file_real_name", nullable = false)
    private String fileRealName;
    @Column(name = "file_type", nullable = false)
    private String fileType;
    @Column(name = "type_flag", nullable = false)
    private Integer typeFlag;
    private String ip;
    @Column(name = "editdate", nullable = false)
    private LocalDateTime editDate;
    @Column(name = "regdate", nullable = false)
    private LocalDateTime regDate;


}

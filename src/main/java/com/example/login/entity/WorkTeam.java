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

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "work_team")
public class WorkTeam {
    @Id
    private Integer idx;
    private Integer state;
    @Column(name = "companyno", nullable = false)
    private Integer companyNo;
    @Column(name = "partname", nullable = false)
    private String partName;
    @Column(columnDefinition = "TEXT")
    private String memo;
    private String ip;
    @Column(name = "regdate", nullable = false)
    private LocalDateTime regDate;
    @Column(name = "editdate", nullable = false)
    private LocalDateTime editDate;
}

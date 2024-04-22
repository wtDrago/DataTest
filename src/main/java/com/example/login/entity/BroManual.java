package com.example.login.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bro_manual")
public class BroManual {

    @Id
    private Integer idx;

    private Integer state;
    private String service;
    private String email;
    @Column(name = "companyno", nullable = false)
    private Integer companyNo;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String contents;
    @Column(name = "editdate", nullable = false)
    private Date editData;
    @Column(name = "regdate", nullable = false)
    private Date regData;
    @Column(name = "page_count")
    private Integer pageCount;

}

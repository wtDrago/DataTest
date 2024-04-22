package com.example.login.dto;


import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class BroFaqDto {
    private int idx;

    private int state;
    private String email;
    private int companyNo;
    private String title;
    private String contents;
    private Date editDate;
    private Date regDate;
    private int pageCount;

    public BroFaqDto(int idx, int state, String email, int companyNo, String title, String contents,
                     Date editDate, Date regDate, int pageCount) {
        this.idx = idx;
        this.state = state;
        this.email = email;
        this.companyNo = companyNo;
        this.title = title;
        this.contents = contents;
        this.editDate = editDate;
        this.regDate = regDate;
        this.pageCount = pageCount;
        }
    }

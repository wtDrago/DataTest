package com.example.login.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TeamWorkCountDto {
    private String email;
    private int work;
    private int noWork;
//    private int comment;
    private int report;
    private int request;
    private int share;
    private int challenge;
    private int party;
    public TeamWorkCountDto(String email, int work, int noWork, int report, int request, int share, int challenge, int party){
        this.email = email;
        this.work = work;
        this.noWork = noWork;
        this.report = report;
        this.request = request;
        this.share = share;
        this.challenge = challenge;
        this.party = party;
    }


}

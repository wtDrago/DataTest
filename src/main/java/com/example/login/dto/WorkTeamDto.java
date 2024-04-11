package com.example.login.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkTeamDto {
    private Integer idx;
    private Integer state;
    private Integer companyNo;
    private String partName;
    private String memo;
    private String ip;

    public WorkTeamDto(Integer idx, Integer state,  Integer companyNo, String partName, String memo, String ip) {
        this.idx = idx;
        this.state = state;
        this.companyNo = companyNo;
        this.partName = partName;
        this.memo = memo;
        this.ip = ip;
    }
}

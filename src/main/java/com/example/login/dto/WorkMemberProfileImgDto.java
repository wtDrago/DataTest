package com.example.login.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WorkMemberProfileImgDto {
    private Integer idx;
    private Integer state;
    private Integer memIdx;
    private Integer companyNo;
    private Integer reSize;
    private Integer email;
    private String filePath;
    private String fileName;
    private Integer fileSize;
    private String fileType;
    private Integer typeFlag;
    private String ip;

    public WorkMemberProfileImgDto(Integer idx, Integer state, Integer memIdx, Integer companyNo, Integer reSize, Integer email,
                                   String filePath, String fileName, String fileType, Integer typeFlag, String ip){
        this.idx = idx;
        this.state = state;
        this.memIdx = memIdx;
        this.companyNo = companyNo;
        this.reSize = reSize;
        this.email = email;
        this.filePath = filePath;
        this.fileName = fileName;
        this.fileType = fileType;
        this.typeFlag = typeFlag;
        this.ip = ip;
    }
}

package com.example.login.dto;


import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;

@Getter
@Setter
public class WorkMemberDto {
    private Integer idx;
    private Integer state;
    private String email;
    private String name;
    private String password;
    private String company;
    private String part;
    private Integer profileType;
//    private Integer grade;
    private Integer coin;
//    private String birthDay;
//    private String addr1;
//    private String addr2;
//    private String zipCode;
//    private String phone;
    private String filePath; // 프로필 이미지 파일 경로
    private String fileName; // 프로필 이미지 파일 이름

    public WorkMemberDto(Integer idx, Integer state, String email, String name, String password, String company, String part,
                         Integer profileType, Integer coin) {
        this.idx = idx;
        this.state = state;
        this.email = email;
        this.name = name;
        this.password = password;
        this.company = company;
        this.part = part;
        this.profileType = profileType;
//        this.grade = grade;
        this.coin = coin;
//        this.birthDay = birthDay;
//        this.addr1 = addr1;
//        this.addr2 = addr2;
//        this.zipCode = zipCode;
//        this.phone = phone;
    }
    // filePath와 fileName의 Setter 메서드를 추가합니다.
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}

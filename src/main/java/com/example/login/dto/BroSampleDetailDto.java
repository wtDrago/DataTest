package com.example.login.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BroSampleDetailDto {
    private int idx;

    private String service;
    private String title;
    private String contents;
    private Date regDate;

    public BroSampleDetailDto(int idx, String service, String title, String contents,
                              Date regDate) {
        this.idx = idx;
        this.service = serviceText(service);
        this.title = title;
        this.contents = contents;
        this.regDate = regDate;
        }


        //['work'=>'업무','challenge'=>'챌린지','party'=>'파티','insight'=>'인사이트','live'=>'라이브','reward'=>'리워드'];
        private String serviceText(String service) {
            return switch (service) {
                case "work" -> "업무";
                case "challenge" -> "챌린지";
                case "party" -> "파티";
                case "insight" -> "인사이트";
                case "live" -> "라이브";
                case "reward" -> "리워드";
                // 다른 경우에 대한 처리도 필요할 수 있습니다.
                default -> service; // 기본적으로는 원래 문자열을 반환합니다.
            };
        }
    }

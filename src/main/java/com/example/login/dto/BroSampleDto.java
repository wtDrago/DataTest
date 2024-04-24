package com.example.login.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BroSampleDto {
    private int idx;

    private String category;
    private String service;
    private String title;
    private Date regDate;

    public BroSampleDto(int idx, Integer category, String service, String title,
                        Date regDate) {
        this.idx = idx;
        this.category = categoryText(category);
        this.service = service;
        this.title = title;
        this.regDate = regDate;
        }

        //['0'=>'미분류','1'=>'업무','2'=>'교육','3'=>'생활/문화','4'=>'건강','5'=>'행사'];
        private String categoryText(Integer category) {
            // 숫자를 문자열로 변환하여 반환하는 메서드
            return switch (category) {
                case 0 -> "미분류";
                case 1 -> "업무";
                case 2 -> "교육";
                case 3 -> "생활/문화";
                case 4 -> "건강";
                case 5 -> "행사";
                default -> ""; // 다른 경우에 대한 처리
            };
        }
    }

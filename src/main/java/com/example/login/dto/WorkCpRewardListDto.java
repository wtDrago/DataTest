package com.example.login.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class WorkCpRewardListDto {
    // Ability points
    private String type1;
    private double abilityPoint1;
    private String type2;
    private double abilityPoint2;
    private String type3;
    private double abilityPoint3;
    private String type4;
    private double abilityPoint4;
    private String type5;
    private double abilityPoint5;
    private String type6;
    private double abilityPoint6;
    private Integer totalType;
    public WorkCpRewardListDto(String type1, double abilityPoint1, String type2, double abilityPoint2,
                               String type3, double abilityPoint3, String type4, double abilityPoint4,
                               String type5, double abilityPoint5, String type6, double abilityPoint6,
                               Integer totalType) {
        this.type1 = type1;
        this.abilityPoint1 = abilityPoint1;
        this.type2 = type2;
        this.abilityPoint2 = abilityPoint2;
        this.type3 = type3;
        this.abilityPoint3 = abilityPoint3;
        this.type4 = type4;
        this.abilityPoint4 = abilityPoint4;
        this.type5 = type5;
        this.abilityPoint5 = abilityPoint5;
        this.type6 = type6;
        this.abilityPoint6 = abilityPoint6;
        this.totalType = totalType;
    }
}
package com.example.login.service;


import com.example.login.dto.*;
import com.example.login.entity.*;
import com.example.login.repository.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class WorkMemberService {
    private final UserRepository userRepository;
    private final WorkTeamRepository workTeamRepository;
    private final WorkMemberProfileImgRepository workMemberProfileImgRepository;
    private final WorkDataLogRepository workDataLogRepository;
    private final WorkCpRewardListRepository workCpRewardListRepository;

    public List<WorkMemberDto> getAllUserDto() {
        List<WorkMember> users = userRepository.findByState(0);

        return users.stream()
                // 맵안의 스트림에서 각각의 데이터를 처리하기위해 member를 사용
                .map(member -> {
                    WorkMemberDto dto = convertToDto(member);
                    List<WorkMemberProfileImg> profileImages = member.getProfileImages();
                    if (profileImages != null && !profileImages.isEmpty()) {
                        // 여러 개의 이미지 중 원하는 데이터를 가져와서 dto에 추가
                        WorkMemberProfileImg profileImg = profileImages.get(0);
                        dto.setFileName(profileImg.getFileName());
                        dto.setFilePath(profileImg.getFilePath());
                    }
                    return dto;
                })
                .collect(Collectors.toList());
    }
    //회원 Dto
    private WorkMemberDto convertToDto(WorkMember user) {
         return new WorkMemberDto(
                user.getIdx(),
                user.getState(),
                user.getEmail(),
                user.getName(),
                user.getPassWord(),
                user.getCompany(),
                user.getPart(),
                user.getProfileType(),
//                user.getGrade(),
                user.getCoin()
//                user.getBirthDay(),
//                user.getAddr1(),
//                user.getAddr2(),
//                user.getZipCode(),
//                user.getPhone()
                // Add other fields as needed
        );

    }


    public List<WorkTeamDto> getAllTeamDto() {
        List<WorkTeam> team = workTeamRepository.findByState(0);
        return team.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
    //팀 Dto
    private WorkTeamDto convertToDto(WorkTeam team) {
        return new WorkTeamDto(
                team.getIdx(),
                team.getState(),
                team.getCompanyNo(),
                team.getPartName(),
                team.getMemo(),
                team.getIp()
        );
    }

    public List<WorkMemberProfileImgDto> getAllUserProfileDto() {
        List<WorkMemberProfileImg> userProfile = workMemberProfileImgRepository.findByState(0);
        return userProfile.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
    //팀 Dto
    private WorkMemberProfileImgDto convertToDto(WorkMemberProfileImg workMemberProfileImg) {
        return new WorkMemberProfileImgDto(
                workMemberProfileImg.getIdx(),
                workMemberProfileImg.getState(),
                workMemberProfileImg.getMemIdx(),
                workMemberProfileImg.getCompanyNo(),
                workMemberProfileImg.getReSize(),
                workMemberProfileImg.getEmail(),
                workMemberProfileImg.getFilePath(),
                workMemberProfileImg.getFileName(),
                workMemberProfileImg.getFileType(),
                workMemberProfileImg.getTypeFlag(),
                workMemberProfileImg.getIp()
        );
    }

    // 메인페이지 타임라인
    public List<WorkDataLogDto> getAllTeamTimeline(String email) {

        List<WorkDataLog> timeLine = workDataLogRepository.findByStateAndWorkDateAndEmail(0, email);
        return timeLine.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
    //팀 Dto
    private WorkDataLogDto convertToDto(WorkDataLog workDataLog) {
        return new WorkDataLogDto(
                workDataLog.getIdx(),
                workDataLog.getCode(),
                workDataLog.getWorkIdx(),
                workDataLog.getLinkIdx(),
                workDataLog.getCompanyNo(),
                workDataLog.getEmail(),
                workDataLog.getName(),
                workDataLog.getSendEmail(),
                workDataLog.getSendName(),
                workDataLog.getCoin(),
                workDataLog.getMemo(),
                workDataLog.getWorkDate()
        );
    }

    // 메인페이지 능력
    public List<WorkCpRewardListDto> getAllTeamAbility(String email) {

        List<Object[]> sums = workCpRewardListRepository.sumTypeByStateAndEmailAndDate(0, email, getFirstDateOfMonth(), getLastDateOfMonth());

        int[] maxValues = {96, 88, 116, 171, 110, 149};

        List<WorkCpRewardListDto> dtos = new ArrayList<>();
        WorkCpRewardListDto dto = null;
        for (Object[] sum : sums) {
            // 각 항목 추출
            Integer[] sumTypes = new Integer[6];
            //각 항목 합계 저장
            Integer[] sumTypeResult = new Integer[6];
            sumTypes[0] = (Integer) sum[0];
            sumTypes[1] = (Integer) sum[1];
            sumTypes[2] = (Integer) sum[2];
            sumTypes[3] = (Integer) sum[3];
            sumTypes[4] = (Integer) sum[4];
            sumTypes[5] = (Integer) sum[5];

            int totalType = 0;
            String[] avility = new String[6];
            for (int i = 0; i < sumTypes.length; i++) {
                // Adjust sumType if it exceeds max value
                // 랭크점수
                totalType += sumTypes[i];

                if (sumTypes[i] > maxValues[i]) {
                    sumTypes[i] = maxValues[i];
                }
                sumTypeResult[i] =  Math.round(((float) sumTypes[i] / maxValues[i]) * 100);


                if(sumTypeResult[i] >= 71 && sumTypeResult[i] <= 100){
                    avility[i]  = "S";
                }else if(sumTypeResult[i] >= 51 && sumTypeResult[i] <= 70){
                    avility[i] = "A";
                }else if(sumTypeResult[i] >= 31 && sumTypeResult[i] <= 50){
                    avility[i] = "B";
                }else if(sumTypeResult[i] >= 11 && sumTypeResult[i] <= 30){
                    avility[i] = "C";
                }else if(sumTypeResult[i] >= 5 && sumTypeResult[i] <= 10){
                    avility[i] = "D";
                }else{
                    avility[i] = "E";
                }
            }

            //소수점 계산(소수점 랭크 점수)
            double[] resultTypes = new double[6];
            for (int i = 0; i < resultTypes.length; i++) {
                resultTypes[i] = Math.round(((float) sumTypes[i] / maxValues[i]) * 5 * 10.0) / 10.0;
                System.out.println(sumTypes[i]);
            }

            dto = new WorkCpRewardListDto(avility[0], resultTypes[0], avility[1], resultTypes[1],
                    avility[2], resultTypes[2], avility[3], resultTypes[3],
                    avility[4], resultTypes[4], avility[5], resultTypes[5],
                    totalType);
            dtos.add(dto);
        }
        return dtos;
    }
    private String getFirstDateOfMonth() {
        LocalDate currentDate = LocalDate.now();
        LocalDate firstDateOfMonth = currentDate.withDayOfMonth(1);
        return firstDateOfMonth.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    private String getLastDateOfMonth() {
        LocalDate currentDate = LocalDate.now();
        LocalDate lastDateOfMonth = currentDate.withDayOfMonth(currentDate.lengthOfMonth());
        return lastDateOfMonth.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    //팀 Dto
//    private WorkCpRewardListDto convertToDto(WorkCpRewardList workCpRewardList) {
//        return new WorkCpRewardListDto(
//                workCpRewardList.getType1(),
//                workCpRewardList.getType2(),
//                workCpRewardList.getType3(),
//                workCpRewardList.getType4(),
//                workCpRewardList.getType5(),
//                workCpRewardList.getType6(),
//                workCpRewardList.getEmail(),
//                workCpRewardList.getName()
//        );
//    }
}

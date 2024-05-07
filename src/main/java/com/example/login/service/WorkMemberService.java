package com.example.login.service;


import com.example.login.dto.*;
import com.example.login.entity.*;
import com.example.login.repository.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
@RequiredArgsConstructor
public class WorkMemberService {
    private final UserRepository userRepository;
    private final WorkTeamRepository workTeamRepository;
    private final WorkMemberProfileImgRepository workMemberProfileImgRepository;
    private final WorkDataLogRepository workDataLogRepository;
    private final WorkCpRewardListRepository workCpRewardListRepository;
    private final TeamWorkCountRepository teamWorkCountRepository;
    private final ChallengeCountRepository challengeCountRepository;
    private final PartyCountRepository partyCountRepository;
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
        WorkCpRewardListDto dto;
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

    public List<TeamWorkCountDto> getAllTeamWorkCount(String email, Integer companyNo){
        List<WorkTodayWork> works = teamWorkCountRepository.findByCompanyNoAndEmailAndWorkDate(companyNo, email, getTodayDate());
        TeamWorkCountDto count = new TeamWorkCountDto(email, countWork(works), countNoWork(works), countReport(works), countRequest(works), countShare(works), countChallenge(email, Long.valueOf(companyNo)), countParty(email, Long.valueOf(companyNo)));

        count.setEmail(email);
        // 각 카운트를 계산하여 count 객체에 설정
        count.setWork(countWork(works));
        count.setNoWork(countNoWork(works));
        count.setReport(countReport(works));
        count.setRequest(countRequest(works));
        count.setShare(countShare(works));
        count.setChallenge(countChallenge(email, Long.valueOf(companyNo)));
        count.setParty(countParty(email, Long.valueOf(companyNo)));

        List<TeamWorkCountDto> countList = new ArrayList<>();
        countList.add(count);

        return countList;
    }
    private int countWork(List<WorkTodayWork> works){
        int count = 0;
        for (WorkTodayWork work : works) {
            if (work.getWorkFlag() == 2 && work.getShareFlag() == 0 && work.getNoticeFlag() == 0 && work.getState() != 9) {
                count++;
            }
        }
        return count;

    }
    private int countNoWork(List<WorkTodayWork> works){
        int count = 0;
        for (WorkTodayWork work : works) {
            if (work.getWorkFlag() == 2 && work.getShareFlag() == 0 && work.getNoticeFlag() == 0 && work.getState() == 0) {
                count++;
            }
        }
        return count;
    }
    private int countReport(List<WorkTodayWork> works){
        int count = 0;
        for (WorkTodayWork work : works) {
            if (work.getWorkFlag() == 1 && work.getWorkIdx() == null) {
                count++;
            }
        }
        return count;
    }
    private int countRequest(List<WorkTodayWork> works){
        int count = 0;
        for (WorkTodayWork work : works) {
            if (work.getWorkFlag() == 3 && work.getWorkIdx() == null) {
                count++;
            }
        }
        return count;
    }
    private int countShare(List<WorkTodayWork> works){
        int count = 0;
        for (WorkTodayWork work : works) {
            if (work.getShareFlag() == 1) {
                count++;
            }
        }
        return count;
    }
    
    // 챌린지 카운트
    private int countChallenge(String email, Long companyNo){

        List<WorkChallenges> challenges = challengeCountRepository.findByCompanyNoAndEmailAndStateAndCoachingChkAndViewFlagAndTempFlagAndTemplate(
                companyNo, email, 0,0,0,0,0);

        int count = 0;
        for (WorkChallenges challenge : challenges){

            // 문자열을 LocalDate로 변환
            LocalDate challengeDate = LocalDate.parse(challenge.getEDate());
            LocalDate todayDate = LocalDate.parse(getTodayDate());

            long daysDifference = ChronoUnit.DAYS.between(challengeDate,todayDate);
            if(daysDifference >= 0){
                count++;
            }
        }
        return count;
    }
    private int countParty(String email, Long companyNo){

        List<WorkTodayWorkProject> partys = partyCountRepository.findByCompanyNoAndEmailAndState(companyNo, email, 0);

        int count = 0;
        for (WorkTodayWorkProject party : partys){
                count++;
        }
        return count;
    }
    // 당일 날짜 구하기
    private String getTodayDate() {
        LocalDate currentDate = LocalDate.now();
        return currentDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
    // 해당 월의 첫 날 구하기
    private String getFirstDateOfMonth() {
        LocalDate currentDate = LocalDate.now();
        LocalDate firstDateOfMonth = currentDate.withDayOfMonth(1);
        return firstDateOfMonth.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
    // 해당 월의 마지막 날 구하기
    private String getLastDateOfMonth() {
        LocalDate currentDate = LocalDate.now();
        LocalDate lastDateOfMonth = currentDate.withDayOfMonth(currentDate.lengthOfMonth());
        return lastDateOfMonth.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
}

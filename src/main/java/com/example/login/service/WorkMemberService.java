package com.example.login.service;


import com.example.login.dto.WorkDataLogDto;
import com.example.login.dto.WorkMemberDto;
import com.example.login.dto.WorkMemberProfileImgDto;
import com.example.login.dto.WorkTeamDto;
import com.example.login.entity.WorkDataLog;
import com.example.login.entity.WorkMember;
import com.example.login.entity.WorkMemberProfileImg;
import com.example.login.entity.WorkTeam;
import com.example.login.repository.WorkDataLogRepository;
import com.example.login.repository.WorkMemberProfileImgRepository;
import com.example.login.repository.WorkTeamRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.login.repository.UserRepository;

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
                workDataLog.getState(),
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
                workDataLog.getWorkCnt(),
                workDataLog.getWorkFlag(),
                workDataLog.getKindFlag(),
                workDataLog.getReadFlag(),
                workDataLog.getTypeFlag(),
                workDataLog.getIp(),
                workDataLog.getWorkDate(),
                workDataLog.getEditDate(),
                workDataLog.getRegDate(),
                workDataLog.getReadDate()
        );
    }
}

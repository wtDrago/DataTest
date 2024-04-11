package com.example.login.service;


import com.example.login.dto.WorkMemberDto;
import com.example.login.dto.WorkMemberProfileImgDto;
import com.example.login.dto.WorkTeamDto;
import com.example.login.entity.WorkMember;
import com.example.login.entity.WorkMemberProfileImg;
import com.example.login.entity.WorkTeam;
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

    public List<WorkMemberDto> getAllUserDto() {
        List<WorkMember> user = userRepository.findByState(0);
        return user.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
    //회원 Dto
    private WorkMemberDto convertToDto(WorkMember user) {
        return new WorkMemberDto(
                user.getIdx(),
                user.getState(),
                user.getEmail(),
                user.getName(),
                user.getCompany(),
                user.getPart(),
                user.getProfileType(),
                user.getGrade(),
                user.getCoin(),
                user.getBirthDay(),
                user.getAddr1(),
                user.getAddr2(),
                user.getZipCode(),
                user.getPhone()
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
}

package com.example.login.controller;


import com.example.login.dto.WorkMemberDto;
import com.example.login.dto.WorkMemberProfileImgDto;
import com.example.login.dto.WorkTeamDto;
import com.example.login.service.WorkMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class TeamController {

    // 서비스 가져오기
    private final WorkMemberService workMemberService;

    // 유저 정보 가져오기
    @GetMapping("/api/user")
    @ResponseBody
    public List<WorkMemberDto> fetchApiUser() {
        return workMemberService.getAllUserDto();
    }
    @GetMapping("/api/team")
    @ResponseBody
    public List<WorkTeamDto> fetchApiTeam() {
        return workMemberService.getAllTeamDto();
    }
    @GetMapping("/api/user-profile")
    @ResponseBody
    public List<WorkMemberProfileImgDto> fetchApiUserProfile() {
        return workMemberService.getAllUserProfileDto();
    }
}

package com.example.login.controller;


import com.example.login.entity.WorkMember;
import com.example.login.service.WorkMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class RewardyController {

    // 서비스 가져오기
    private final WorkMemberService workMemberService;

    // 유저 정보 가져오기
    @GetMapping("/api/user")
    @ResponseBody
    public List<WorkMember> fetchApiUser() {

        return workMemberService.getAllUser();
    }
}

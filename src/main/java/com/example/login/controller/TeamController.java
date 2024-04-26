package com.example.login.controller;


import com.example.login.dto.*;
import com.example.login.service.WorkMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@RequiredArgsConstructor
@Controller
@ResponseBody
public class TeamController {

    // 서비스 가져오기
    private final WorkMemberService workMemberService;

    // 유저 정보 가져오기
    @GetMapping("/team/user")

    public ResponseEntity<Map<String, Object>> fetchApiUser() {
        Map<String , Object> response = new LinkedHashMap<>();

        try {
            List<WorkMemberDto> users = workMemberService.getAllUserDto();
            response.put("result", "success");
            response.put("msg", "");
            response.put("data", users);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("result", "error");
            response.put("msg", e.getMessage());
            response.put("data", Collections.emptyList());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // 타임라인
    @GetMapping("/team/timeline")
    public ResponseEntity<Map<String, Object>> fetchTeamTimeline(
            @RequestParam(name="email", defaultValue = "") String email
    ) {

        Map<String , Object> response = new LinkedHashMap<>();

        try {
            List<WorkDataLogDto> timelines = workMemberService.getAllTeamTimeline(email);
            response.put("result", "success");
            response.put("msg", "");
            response.put("data", timelines);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("result", "error");
            response.put("msg", e.getMessage());
            response.put("data", Collections.emptyList());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

//    @GetMapping("/team/ability")
//    public ResponseEntity<Map<String, Object>> fetchTeamAbility(
//            @RequestParam(name="email", defaultValue = "") String email
//    ) {
//
//        Map<String , Object> response = new LinkedHashMap<>();
//
//        try {
//            List<WorkCpRewardListDto> abilitys = workMemberService.getAllTeamAbility(email);
//            response.put("result", "success");
//            response.put("msg", "");
//            response.put("data", abilitys);
//            return ResponseEntity.ok(response);
//        } catch (Exception e) {
//            response.put("result", "error");
//            response.put("msg", e.getMessage());
//            response.put("data", Collections.emptyList());
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
//        }
//    }
}

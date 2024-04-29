package com.example.login.controller;


import com.example.login.dto.*;
import com.example.login.service.BrochureService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@RequiredArgsConstructor
@Controller
public class BrochureController {

    // 서비스 가져오기
    private final BrochureService brochureService;

    // 브로슈어 자주묻는 질문
    @GetMapping("/api/bro-faq")
    public ResponseEntity<Map<String, Object>> fetchApiBroFaq(
            @RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "size", defaultValue = "5") int size,
            @RequestParam(name = "search", defaultValue = "") String search
    ) {
        // 윈하는 순서를 response 하려고 할때는 hasMap이 아닌 LinkedHashMap 사용
        Map<String, Object> response = new LinkedHashMap<>();
        try {
            // 페이지 번호를 0부터 시작하는 인덱스로 변환
            int startPage = page - 1;
            // Pageable 객체 생성
            Pageable pageable = PageRequest.of(startPage, size);
            Page<BroFaqDto> faqPage = brochureService.getAllBroFaqDto(pageable, search);

            // 페이지 정보 설정
            Map<String, Object> faqPageInfo = new HashMap<>();
            faqPageInfo.put("next_page", faqPage.hasNext() ? page + 1 : null);
            faqPageInfo.put("prev_page", (faqPage.hasPrevious()  && faqPage.getTotalPages() >= page)? page - 1 : null);
            faqPageInfo.put("totalPage", faqPage.getTotalPages());
            faqPageInfo.put("totalElements", faqPage.getTotalElements());

            // Response에 데이터 삽입
            Map<String, Object> data = new HashMap<>();
                data.put("List", faqPage.getContent());
                data.put("page", faqPageInfo);

            if(faqPage.getTotalPages() < page){
                response.put("result", "fail");
                response.put("msg", "게시물이 없습니다.");
            }else{
                response.put("result", "success");
                response.put("msg", "");
            }
            response.put("data", data);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("result", "error");
            response.put("msg", e.getMessage());
            response.put("data", Collections.emptyList());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // 브로슈어 메뉴얼
    @GetMapping("/api/bro-manual")
    public ResponseEntity<Map<String, Object>> fetchApiBroManual(
            @RequestParam(name = "service", defaultValue = "start") String service
    ) {
        Map<String, Object> response = new HashMap<>();
        try {
            List<BroManualDto> manuals = brochureService.getAllBroManualDto(service);
            response.put("result", "success");
            response.put("msg", manuals.isEmpty() ? "내용이 존재하지않습니다." : "");
            response.put("data", manuals);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("result", "error");
            response.put("msg", e.getMessage());
            response.put("data", Collections.emptyList());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
    // 브로슈어 공지사항
    @GetMapping("/api/bro-notice")
    public ResponseEntity<Map<String, Object>> fetchApiBroNotice(
            @RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "size", defaultValue = "5") int size
    ) {
        Map<String, Object> response = new HashMap<>();
        try {

            int startPage = page - 1;

            Pageable pageable = PageRequest.of(startPage, size);
            Page<BroNoticeDto> notices = brochureService.getAllBroNoticeDto(pageable);

            // 페이지 정보 설정
            Map<String, Object> noticePageInfo = new HashMap<>();
            noticePageInfo.put("next_page", notices.hasNext() ? page + 1 : null);
            noticePageInfo.put("prev_page", (notices.hasPrevious() && notices.getTotalPages() >= page) ? page - 1 : null);
            noticePageInfo.put("totalPage", notices.getTotalPages());
            noticePageInfo.put("totalElements", notices.getTotalElements());

            Map<String , Object> data = new HashMap<>();

            data.put("List", notices.getContent());
            data.put("Page", noticePageInfo);

            if(notices.getTotalPages() < page){
                response.put("result", "fail");
                response.put("msg", "게시물이 없습니다.");
            }else{
                response.put("result", "success");
                response.put("msg", "");
            }
            response.put("data", data);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("result", "error");
            response.put("msg", e.getMessage());
            response.put("data", Collections.emptyList());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
    // 브로슈어 활용사례(리스트)
    @GetMapping("/api/bro-sample-list")
    public ResponseEntity<Map<String, Object>> fetchApiBroSample(
            @RequestParam(name = "search", defaultValue = "") String search
    ) {
        Map<String, Object> response = new HashMap<>();
        try {
            List<BroSampleDto> samples = brochureService.getAllBroSampleDto(search);
            response.put("result", "success");
            response.put("msg", "");
            response.put("data", samples);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("result", "error");
            response.put("msg", e.getMessage());
            response.put("data", Collections.emptyList());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // 브로슈어 활용사례(디테일)
    @GetMapping("/api/bro-sample-detail")
    public ResponseEntity<Map<String, Object>> fetchApiBroSampleDetail(
            @RequestParam(name = "idx", defaultValue = "") int idx
    ) {
        Map<String, Object> response = new HashMap<>();

        try {
            Map<String, Object> dataMap = new LinkedHashMap<>();
            List<Map<String, Object>> listData = new ArrayList<>();
            List<Map<String, Object>> pageData = new ArrayList<>();
            List<BroSampleDetailDto> sampleDetails = brochureService.getAllBroSampleDetailDto(idx);

            for (BroSampleDetailDto detail : sampleDetails) {
                Map<String, Object> detailMap = new LinkedHashMap<>();

                if (detail.getIdx() == idx) {
                    listData.add(detailMap); // 쿼리스트링과 idx같으면 설정
                    detailMap.put("idx", detail.getIdx());
                    detailMap.put("title", detail.getTitle());
                    detailMap.put("service", detail.getService());
                    detailMap.put("contents", detail.getContents());
                } else {
                    pageData.add(detailMap); // 그 외의 경우에는 Page에 저장
                    detailMap.put("idx", detail.getIdx());
                    detailMap.put("title", detail.getTitle());
                    if(detail.getIdx() > idx){
                        detailMap.put("step", "next");
                    }else if(detail.getIdx() < idx){
                        detailMap.put("step", "prev");
                    }
                }
            }
            dataMap.put("List", listData);
            dataMap.put("Page", pageData);

            response.put("result", "success");
            response.put("msg", "");
            response.put("data", dataMap);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("result", "error");
            response.put("msg", e.getMessage());
            response.put("data", Collections.emptyList());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

}

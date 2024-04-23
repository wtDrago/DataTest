package com.example.login.service;


import com.example.login.dto.*;
import com.example.login.entity.*;
import com.example.login.repository.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class BrochureService {
    private final BroFaqRepository broFaqRepository;
    private final BroManualRepository broManualRepository;
    private final BroNoticeRepository broNoticeRepository;
    private final BroSampleRepository broSampleRepository;
    // 브로슈어 자주묻는질문
    // 생성자 초기화만 후 convertToDto를 통하여 메서드 초기화까지 하는 서비스
    public Page<BroFaqDto> getAllBroFaqDto(Pageable pageable, String search) {
        Page<BroFaq> broFaqPage =  broFaqRepository.findByStateAndTitleContaining(1, search,pageable);
        return broFaqPage.map(this::convertToDto);
    }

    private BroFaqDto convertToDto(BroFaq broFaq) {
        return new BroFaqDto(
                broFaq.getIdx(),
                broFaq.getState(),
                broFaq.getEmail(),
                broFaq.getCompanyNo(),
                broFaq.getTitle(),
                broFaq.getContents(),
                broFaq.getEditData(),
                broFaq.getRegData(),
                broFaq.getPageCount()
        );
    }

    // 브로슈어 공지사항
    public Page<BroNoticeDto> getAllBroNoticeDto(Pageable pageable) {
//        List<BroNotice> broNotice = broNoticeRepository.findByState(1);
        Page<BroNotice> broNotice = broNoticeRepository.findByState(1, pageable);
        return broNotice.map(this::convertToDto);
    }
    private BroNoticeDto convertToDto(BroNotice broNotice) {
        return new BroNoticeDto(
                broNotice.getIdx(),
                broNotice.getState(),
                broNotice.getEmail(),
                broNotice.getCompanyNo(),
                broNotice.getTitle(),
                broNotice.getContents(),
                broNotice.getEditData(),
                broNotice.getRegData(),
                broNotice.getPageCount()
        );
    }

    // 브로슈어 메뉴얼
    public List<BroManualDto> getAllBroManualDto(String service) {
        List<BroManual> broManual = broManualRepository.findByStateAndService(1, service);
        return broManual.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
    private BroManualDto convertToDto(BroManual broManual) {
        return new BroManualDto(
                broManual.getIdx(),
                broManual.getState(),
                broManual.getService(),
                broManual.getEmail(),
                broManual.getCompanyNo(),
                broManual.getTitle(),
                broManual.getContents(),
                broManual.getEditData(),
                broManual.getRegData(),
                broManual.getPageCount()
        );
    }


    // 브로슈어 활용사례
    public List<BroSampleDto> getAllBroSampleDto(String search) {
        List<BroSample> broSample = broSampleRepository.findByStateAndTitleContaining(1, search);
        return broSample.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
    private BroSampleDto convertToDto(BroSample broSample) {
        return new BroSampleDto(
                broSample.getIdx(),
                broSample.getState(),
                broSample.getCategory(),
                broSample.getService(),
                broSample.getEmail(),
                broSample.getCompanyNo(),
                broSample.getTitle(),
                broSample.getContents(),
                broSample.getEditData(),
                broSample.getRegData(),
                broSample.getPageCount()
        );
    }

}

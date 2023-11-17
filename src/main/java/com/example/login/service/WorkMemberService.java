package com.example.login.service;


import com.example.login.dto.WorkMemberDto;
import com.example.login.entity.WorkMember;
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

    public List<WorkMemberDto> getAllUserDto() {
        List<WorkMember> user = userRepository.findByState(0);
        return user.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

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
}

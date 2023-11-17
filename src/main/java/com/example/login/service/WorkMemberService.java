package com.example.login.service;


import com.example.login.entity.WorkMember;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.login.repository.UserRepository;

import java.util.Collections;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class WorkMemberService {
    private final UserRepository userRepository;

    public List<WorkMember> getAllUser(){
        return userRepository.findAll();
    }
}

package com.example.login.service;


import com.example.login.dto.JoinDto;
import com.example.login.entity.UserEntity;
import com.example.login.repository.UserTestRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JoinService {

    private final UserTestRepository userTestRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public JoinService(UserTestRepository userTestRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userTestRepository = userTestRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    public void joinProcess(JoinDto joinDto){

        String username = joinDto.getUsername();
        String password = joinDto.getPassword();

        Boolean isExist = userTestRepository.existsByUsername(username);

        if(isExist){
            return;
        }

        UserEntity data = new UserEntity();

        data.setUsername(username);
        data.setPassword(bCryptPasswordEncoder.encode(password));
        data.setRole("ROLE_ADMIN");

        userTestRepository.save(data);
    }
}

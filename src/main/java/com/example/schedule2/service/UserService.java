package com.example.schedule2.service;


import com.example.schedule2.dto.SignUpRequestDto;
import com.example.schedule2.dto.SignUpResponseDto;
import com.example.schedule2.dto.UserResponseDto;
import com.example.schedule2.entity.User;
import com.example.schedule2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public SignUpResponseDto signUp(String username, String password, String email ) {

        User user = new User(username, password,email);

        User savedUser = userRepository.save(user);

        return new SignUpResponseDto(savedUser.getId(),savedUser.getUserName());

    }

    public UserResponseDto findById(Long id) {

        Optional<User> optionalUser = userRepository.findById(id);

        if(optionalUser.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exitsts id : " + id);
        }

        User findUser = optionalUser.get();

        return new UserResponseDto(findUser.getUserName(),findUser.getEmail());
    }
}

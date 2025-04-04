package com.example.schedule2.controller;


import com.example.schedule2.dto.request.LoginRequestDto;
import com.example.schedule2.dto.request.SignUpRequestDto;
import com.example.schedule2.dto.request.UpdatePasswordRequestDto;
import com.example.schedule2.dto.response.SignUpResponseDto;
import com.example.schedule2.dto.response.UpdateUserRequestDto;
import com.example.schedule2.dto.response.UserResponseDto;
import com.example.schedule2.service.UserService;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 유저 생성 기능
    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseDto> signUp(@RequestBody SignUpRequestDto requestDto){

        SignUpResponseDto signUpResponseDto =
                userService.signUp(
                        requestDto.getUsername(),
                        requestDto.getPassword(),
                        requestDto.getEmail()
                );

        return new ResponseEntity<>(signUpResponseDto, HttpStatus.CREATED);
    }

    // 단일 유저 조회
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable Long id){
        UserResponseDto userResponseDto = userService.findById(id);

        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    // 비밀번호 수정
    @PatchMapping("/{id}/password")
    public ResponseEntity<Void> updatePassword(
            @PathVariable Long id,
            @RequestBody UpdatePasswordRequestDto requestDto
    ){

        userService.updatePassword(id, requestDto.getPrePassword(), requestDto.getNewPassword());

        return new ResponseEntity<>(HttpStatus.OK);
    }
    // 유저 삭제 기능
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        userService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    //유저 수정 기능
    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateUser(
            @PathVariable Long id,
            @RequestBody UpdateUserRequestDto requestDto
            ){

        userService.updateUser(id, requestDto.getUsername(),requestDto.getEmail());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 로그인 기능
    @PostMapping("/login")
    public ResponseEntity<UserResponseDto> login(
            @RequestBody LoginRequestDto requestDto, HttpServletRequest request)
    {
        UserResponseDto userResponseDto = userService.login(requestDto.getEmail(),requestDto.getPassword());

        // 세션 생성 및 유저정보 저장
        HttpSession session = request.getSession(true);
        session.setAttribute("user", userResponseDto);
        return ResponseEntity.ok(userResponseDto);
    }

}

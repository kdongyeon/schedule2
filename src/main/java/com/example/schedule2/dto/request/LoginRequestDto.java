package com.example.schedule2.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor // 모든 생성자 자동생성
public class LoginRequestDto {
    private String email;
    private String password;
}

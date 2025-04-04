package com.example.schedule2.dto.response;


import lombok.Getter;

@Getter
public class UserResponseDto {

    private final String username;
    private final String email;

    public UserResponseDto(Long id, String username, String email) {
        this.username = username;
        this.email = email;
    }


}

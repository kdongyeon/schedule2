package com.example.schedule2.dto;


import lombok.Getter;

@Getter
public class UpdatePasswordRequestDto {

    private final String prePassword;

    private final String newPassword;

    public UpdatePasswordRequestDto(String prePassword, String newPassword) {
        this.prePassword = prePassword;
        this.newPassword = newPassword;
    }
}

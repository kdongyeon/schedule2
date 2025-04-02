package com.example.schedule2.dto;

import lombok.Getter;

@Getter
public class CreateScheduleRequestDto {

    private final String title;
    private final String content;
    private final String username;

    public CreateScheduleRequestDto(String title, String content, String username) {
        this.title = title;
        this.content = content;
        this.username = username;
    }
}

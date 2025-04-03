package com.example.schedule2.dto.request;

import lombok.Getter;

@Getter
public class CreateScheduleRequestDto {

    private final String title;
    private final String content;
    private final String writerUser;

    public CreateScheduleRequestDto(String title, String content, String writerUser) {
        this.title = title;
        this.content = content;
        this.writerUser = writerUser;
    }
}

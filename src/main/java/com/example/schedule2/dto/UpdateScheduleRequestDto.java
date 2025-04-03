package com.example.schedule2.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateScheduleRequestDto {

    private String title;
    private String content;
    private String username;
}

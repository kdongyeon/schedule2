package com.example.schedule2.controller;

import com.example.schedule2.dto.CreateScheduleRequestDto;
import com.example.schedule2.dto.ScheduleResponseDto;
import com.example.schedule2.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<ScheduleResponseDto> save(@RequestBody CreateScheduleRequestDto requestDto) {


        ScheduleResponseDto scheduleResponseDto = scheduleService.save(requestDto.getTitle(), requestDto.getContent(), requestDto.getUsername());

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

package com.example.schedule2.controller;

import com.example.schedule2.dto.request.CreateScheduleRequestDto;
import com.example.schedule2.dto.response.ScheduleResponseDto;
import com.example.schedule2.dto.request.UpdateScheduleRequestDto;
import com.example.schedule2.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@Responsebody = 뷰로 반환되는 것이 아니라 http 응답 바디에 데이터를 넣어 반환
@RestController //@responsebody + @Controller
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    // 일정 생성 기능
    @PostMapping
    public ResponseEntity<ScheduleResponseDto> save(@RequestBody CreateScheduleRequestDto requestDto) {


        ScheduleResponseDto scheduleResponseDto = scheduleService.save(requestDto.getTitle(), requestDto.getContent(), requestDto.getWriterUser());

        // 반환은 Http 응답으로 표현 회원정보 요청을 처리하는 비즈니스 로직 수행 후 회원 정보를 응답으로 반환
        // ResponseEntity<>() : 응답 데이터와 함께 Http 상태 코드를 포함하여 반환
        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.CREATED);
    }
    //일정 전체 조회 기능
    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> findAll(){
        List<ScheduleResponseDto> scheduleResponseDtoList = scheduleService.findAll();

        return new ResponseEntity<>(scheduleResponseDtoList, HttpStatus.OK);
    }

    //일정 개인 조회 기능
    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> findById(@PathVariable Long id){

        ScheduleResponseDto scheduleResponseDto = scheduleService.findById(id);

        return new ResponseEntity<>(scheduleResponseDto,HttpStatus.OK);
    }
    // 일정 삭제 기능
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        scheduleService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    // 일정 수정 기능
    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateSchedule(
            @PathVariable Long id,
            @RequestBody UpdateScheduleRequestDto requestDto
    ){
        scheduleService.updateSchedule(id, requestDto.getTitle(),requestDto.getContent(),requestDto.getWriterUser());

        return new ResponseEntity<>(HttpStatus.OK);
    }

}

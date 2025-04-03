package com.example.schedule2.service;

import com.example.schedule2.dto.ScheduleResponseDto;

import com.example.schedule2.entity.Schedule;
import com.example.schedule2.entity.User;
import com.example.schedule2.repository.ScheduleRepository;
import com.example.schedule2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final UserRepository userRepository;
    private final ScheduleRepository scheduleRepository;


    // 일정 저장 기능
    public ScheduleResponseDto save(String title, String content, String userName) {

        User findUser = userRepository.findUserByUserNameOrElseThrow(userName);

        Schedule schedule = new Schedule(title, content);
        schedule.setUser(findUser);

        Schedule saved = scheduleRepository.save(schedule);

        return new ScheduleResponseDto(saved.getId(), saved.getTitle(), saved.getContent());
    }

    // 리스트에서 유저 전체조회
    public List<ScheduleResponseDto> findAll() {

        return scheduleRepository.findAll()
                .stream()
                .map(ScheduleResponseDto::toDto)
                .toList();

    }

    // 일정 단일 조회
    public ScheduleResponseDto findById(Long id) {

        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);

        return new ScheduleResponseDto(findSchedule.getId(),findSchedule.getTitle(),findSchedule.getContent());

    }

    // 일정 단일 삭제
    public void delete(Long id) {

        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);

        scheduleRepository.delete(findSchedule);
    }

    @Transactional
    // 일정 단일 수정
    public void updateSchedule(Long id, String title, String content, String writerUser) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found" + id));

        schedule.setTitle(title);
        schedule.setContent(content);
        schedule.setWriterUser(writerUser);

        scheduleRepository.save(schedule);
    }


}

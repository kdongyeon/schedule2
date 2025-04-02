package com.example.schedule2.service;

import com.example.schedule2.dto.ScheduleResponseDto;
import com.example.schedule2.dto.UserResponseDto;
import com.example.schedule2.entity.Schedule;
import com.example.schedule2.entity.User;
import com.example.schedule2.repository.ScheduleRepository;
import com.example.schedule2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final UserRepository userRepository;
    private final ScheduleRepository scheduleRepository;


    public ScheduleResponseDto save(String title, String content, String userName) {

        User findUser = userRepository.findUserByUserNameOrElseThrow(userName);

        Schedule schedule = new Schedule(title, content);
        schedule.setUser(findUser);

        Schedule saved = scheduleRepository.save(schedule);

        return new ScheduleResponseDto(saved.getId(), saved.getTitle(), saved.getContent());
    }
}

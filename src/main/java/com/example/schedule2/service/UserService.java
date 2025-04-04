package com.example.schedule2.service;



import com.example.schedule2.dto.response.SignUpResponseDto;
import com.example.schedule2.dto.response.UserResponseDto;
import com.example.schedule2.entity.User;
import com.example.schedule2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor //final 또는 @NonNull 필드만 포함하는 생성자 자동생성
public class UserService {

    private final UserRepository userRepository;

    // 회원가입 기능
    public SignUpResponseDto signUp(String username, String password, String email ) {

        User user = new User(username, password, email);

        User savedUser = userRepository.save(user);

        return new SignUpResponseDto(savedUser.getId(),savedUser.getUsername());

    }

    // 특정 유저 조회
    public UserResponseDto findById(Long id) {

        Optional<User> optionalUser = userRepository.findById(id);

        // 유저 없다면 에러 출력
        if(optionalUser.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exitsts id : " + id);
        }

        User findUser = optionalUser.get();

        return new UserResponseDto(findUser.getId(), findUser.getUsername(),findUser.getEmail());
    }

    //  비밀번호 수정
    @Transactional // runtimeException 또는 Error 발생시 롤백
    public void updatePassword(Long id, String prePassword, String newPassword) {

        User findUser = userRepository.findByIdOrElseThrow(id);

        if (!findUser.getPassword().equals(prePassword)){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다.");
        }

        findUser.updatePassword(newPassword);

    }
    // 삭제 기능
    public void delete(Long id) {
        User findUser = userRepository.findByIdOrElseThrow(id);
        userRepository.delete(findUser);

    }

    // 유저 수정기능
    @Transactional
    public void updateUser(Long id, String username, String email) {
        User user = userRepository.findById(id)
                        .orElseThrow(()->new RuntimeException("User not Found" + id));

        user.setUserName(username);
        user.setEmail(email);
        userRepository.save(user);

    }

    // 로그인 기능
    public UserResponseDto login(String email, String password) {
        User user = userRepository.findByEmail(email).orElse(null);

        //orElse(null) 유저가 존재하지 않으면 null 처리

        if (user == null || !user.getPassword().equals(password)) {
            return null;
        }

        return new UserResponseDto(user.getId(), user.getUsername(), user.getEmail());
    }
}

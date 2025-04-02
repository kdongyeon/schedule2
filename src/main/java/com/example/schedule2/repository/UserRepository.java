package com.example.schedule2.repository;

import com.example.schedule2.entity.User;
import com.example.schedule2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByUserName(String userName);

    default User findUserByUserNameOrElseThrow(String userName){
        return findUserByUserName(userName).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exit userName=" + userName));
    }

    default User findByIdOrElseThrow(Long id){
        return findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id =" + id));
    }
}

package com.example.schedule2.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User extends BaseEntity {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;


    public User() {
    }

    public User(String userName, String password, String email)  {
        this.userName = userName;
        this.password = password;
        this.email = email;

    }

    public void updatePassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return userName;
    }

}

package com.example.schedule2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "schedule")
public class Schedule extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "longtext")
    private String content;

    @Column(nullable = false)
    private String writerUser;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Schedule() {
    }

    public Schedule(String content, String title) {
        this.content = content;
        this.title = title;
    }
    public void updateSchedule(String title, String content, String writerUser){
        this.title = title;
        this.content = content;
        this.writerUser = writerUser;
    }




}

package com.example.examplefinal.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //姓名
    private String name;
    //职称
    private String position;
    //简介
    private String detail;
    //电话
    private String phone;
    //监考次数
    private int examNumber;
    @OneToMany(mappedBy = "teacher")
    private List<ExamTeacher> examTeachers;
    @OneToMany(mappedBy = "teacher")
    private List<MissionTeacher> missionTeachers;
    @OneToOne
    @JoinColumn(unique = true)
    private User user;
}

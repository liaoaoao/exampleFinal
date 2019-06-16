package com.example.examplefinal.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Mission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //任务名称
    private String name;
    //任务描述
    private String missionDetail;
    //截止时间
    @JsonFormat(locale="zh",timezone = "GMT+8",pattern="yyyy-MM-dd HH:mm")
    private LocalDateTime endTime;
    //任务状态
    private String missionState;
    @OneToMany(mappedBy = "mission")
    private List<MissionTeacher> missionTeachers;
}

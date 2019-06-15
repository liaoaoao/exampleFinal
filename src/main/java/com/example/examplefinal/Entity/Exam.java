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
public class Exam {
    public static enum  StateType{
        UNDISTRIBUTE,DISRIBUTE,FINISH
    };
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //考试地点
    private String examPosition;
    //课程名称
    private String cname;
    //开始时间
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;
    //结束时间
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;
    //分配状态
    private StateType stateType;
    @OneToMany(mappedBy = "exam")
    private List<ExamTeacher> examTeachers;
}

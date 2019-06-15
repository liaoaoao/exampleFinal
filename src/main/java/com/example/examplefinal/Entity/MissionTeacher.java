package com.example.examplefinal.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MissionTeacher {

    @Id
    private int id;
    //回复信息
    private String message;
    //完成时间
    private LocalDateTime receiveTime;
    //完成结果
    private String result;
    @ManyToOne
    private Mission mission;
    @ManyToOne
    private Teacher teacher;
}

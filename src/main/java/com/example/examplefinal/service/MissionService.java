package com.example.examplefinal.service;

import com.example.examplefinal.Entity.Mission;
import com.example.examplefinal.Entity.MissionTeacher;
import com.example.examplefinal.Entity.Teacher;
import com.example.examplefinal.Repository.MissionRepository;
import com.example.examplefinal.Repository.MissonTeacherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@Slf4j
@Transactional
public class MissionService {

    @Autowired
    private MissionRepository missionRepository;
    @Autowired
    private MissonTeacherRepository missonTeacherRepository;
    //获取期限时间
    public LocalDateTime getLocalTime(){
        LocalDateTime nowtime = LocalDateTime.now();
        return nowtime;
    }
    //获取数据库中的期限时间，比较
    public void getEndTime(MissionTeacher missionTeacher1,Teacher teacher,Mission mission,LocalDateTime localDateTime1){
        MissionTeacher missionTeacher = missonTeacherRepository.findMissionTeacher(teacher, mission);
        LocalDateTime localDateTime =mission .getEndTime();
        missionTeacher.setMission(missionTeacher1.getMission());
        if(localDateTime.isAfter(localDateTime1)){
            missionTeacher.setResult("InTime");
            missonTeacherRepository.save(missionTeacher);
            log.debug("在规定时间内完成");
        }else{
            missionTeacher.setResult("OutTime");
            missonTeacherRepository.save(missionTeacher);
            log.debug("未在规定时间完成");
        }
    }


}
package com.example.examplefinal.service;

import com.example.examplefinal.Entity.Mission;
import com.example.examplefinal.Entity.MissionTeacher;
import com.example.examplefinal.Entity.Teacher;
import com.example.examplefinal.Repository.MissionRepository;
import com.example.examplefinal.Repository.MissonTeacherRepository;
import com.example.examplefinal.Repository.TeacherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
@Transactional
public class MissionService {

    @Autowired
    private MissionRepository missionRepository;
    @Autowired
    private MissonTeacherRepository missonTeacherRepository;
    @Autowired
    private TeacherRepository teacherRepository;


    //获取期限时间
    public LocalDateTime getLocalTime(){
        LocalDateTime nowtime = LocalDateTime.now();
        return nowtime;
    }
    //写回复并提交数据，判断是否超时
    public void getEndTime(MissionTeacher missionTeacher1,LocalDateTime localDateTime1){
        //MissionTeacher missionTeacher = missonTeacherRepository.findMissionTeacher(teacher, mission);
        Teacher t = teacherRepository.findByName(missionTeacher1.getTeacher().getName());
        Mission m = missionRepository.findByName(missionTeacher1.getMission().getName());
        LocalDateTime localDateTime =m .getEndTime();
        int i =  missonTeacherRepository.writeMessage(missionTeacher1.getMessage(),t,m);
        if(i==0){
            log.debug("老师或者任务不存在，无法回复");
        }
        //if(localDateTime.isAfter(localDateTime1)){
            //missionTeacher.setResult("InTime");
            //missonTeacherRepository.save(missionTeacher);
            //log.debug("在规定时间内完成");
        //}else{
            //missionTeacher.setResult("OutTime");
            //missonTeacherRepository.save(missionTeacher);
            //log.debug("未在规定时间完成");
       // }
    }
    //获取某个老师的全部任务
    public void getMissionByTeacher(String name){
        List<Mission> missions = missonTeacherRepository.findMissionByTeacher(name);
        for (Mission mission:missions){
            log.debug("任务名："+mission.getName()+"   任务描述："+mission.getMissionDetail()+"   任务截止时间："+mission.getEndTime());
        }
    }
    //获取某个任务的全部老师
    public void getTeacherByMission(String name){
        List<MissionTeacher> missionTeachers = missonTeacherRepository.findTeacherByMission(name);
        for (MissionTeacher missionTeacher:missionTeachers){
            log.debug("老师名："+missionTeacher.getTeacher().getName()+"    回复内容"+missionTeacher.getMessage()+"    回复状态"+missionTeacher.getResult());
        }

    }

}
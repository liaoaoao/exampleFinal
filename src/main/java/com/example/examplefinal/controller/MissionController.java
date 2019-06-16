package com.example.examplefinal.controller;

import com.example.examplefinal.Entity.Mission;
import com.example.examplefinal.Entity.MissionTeacher;
import com.example.examplefinal.Entity.Teacher;
import com.example.examplefinal.service.AdminService;
import com.example.examplefinal.service.MissionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.channels.Pipe;
import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("/api")
public class MissionController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private MissionService missionService;

    //创建任务
    @PostMapping("/Admin/createMission")
    public void createMission(@RequestBody Mission mission){

    adminService.createMission(mission);
    }
    //关闭任务
    @PostMapping("/Admin/closeMission")
    public void closeMission(@RequestBody Mission mission){
        adminService.closeMission(mission.getName());
    }
    //修改任务
    @PostMapping("/Admin/updateMission")
    public void updateMission(@RequestBody Mission mission){
        adminService.updateMission(mission.getMissionDetail(),mission.getName());
    }
    //要求教师在指定截止时间内回复信息
    @PostMapping("/Admin/createMissionTeacher")
    public void deleteMission(@RequestBody MissionTeacher missionTeacher){
        adminService.createMissionTeacher(missionTeacher.getTeacher().getName(), missionTeacher.getMission().getName());
    }
    //检查老师是否按时回复
    @PostMapping("/check")
    public void check(@RequestBody MissionTeacher missionTeacher){
        LocalDateTime localDateTime = missionService.getLocalTime();
        missionService.getEndTime(missionTeacher,localDateTime);
    }
    //获取某个老师的全部任务
    @PostMapping("/User/getMission")
    public  void getMission(@RequestBody Teacher teacher){
        missionService.getMissionByTeacher(teacher.getName());
    }

    //获取某个任务的全部老师回复
    @PostMapping("/User/getTeacher")
    public  void getTeacher(@RequestBody Mission mission){
        missionService.getMissionByTeacher(mission.getName());
    }

    //写回复并判断是否超时
    @PostMapping("/User/writeMessage")
    public void writeMessage(@RequestBody MissionTeacher missionTeacher){
        missionService.getEndTime(missionTeacher,  null);
    }
}

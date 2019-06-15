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

    @PostMapping("/Admin/createMission")
    public void createMission(@RequestBody Mission mission){

    adminService.createMission(mission);
    }
    @PostMapping("/Admin/closeMission")
    public void closeMission(@RequestBody Mission mission){
        adminService.closeMission(mission.getName());
    }
    @PostMapping("/Admin/updateMission")
    public void updateMission(@RequestBody Mission mission){
        adminService.updateMission(mission.getName());
    }
    //要求教师在指定截止时间内回复信息
    @PostMapping("/Admin/createMissionTeacher")
    public void deleteMission(@RequestBody Teacher teacher, @RequestBody Mission mission){
        adminService.createMissionTeacher(teacher.getName(), mission.getName());
    }
    //检查老师是否按时回复
    @PostMapping("/check")
    public void check(@RequestBody MissionTeacher missionTeacher,@RequestBody Teacher teacher,@RequestBody Mission mission){
        LocalDateTime localDateTime = missionService.getLocalTime();
        missionService.getEndTime(missionTeacher, teacher, mission, localDateTime);
    }

}

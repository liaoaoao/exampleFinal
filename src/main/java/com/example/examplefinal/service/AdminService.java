package com.example.examplefinal.service;

import com.example.examplefinal.Entity.Mission;
import com.example.examplefinal.Entity.MissionTeacher;
import com.example.examplefinal.Entity.Teacher;
import com.example.examplefinal.Entity.User;
import com.example.examplefinal.Repository.MissionRepository;
import com.example.examplefinal.Repository.MissonTeacherRepository;
import com.example.examplefinal.Repository.TeacherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Slf4j
@Transactional
public class AdminService {
    @Autowired
    private MissionRepository missionRepository;
    @Autowired
    private MissonTeacherRepository missonTeacherRepository;
    @Autowired
    private TeacherRepository teacherRepository;

    public void createMission(Mission mission){
        missionRepository.save(mission);
    }

    public int updateMission(String name){
        return missionRepository.updateMission(name);
    }

    public int closeMission(String name){
        return missionRepository.closeMission(name);
    }

    public void createMissionTeacher(String teachername,String missionname){
        Teacher t = teacherRepository.findByName(teachername);
        Mission m = missionRepository.findByName(missionname);
        MissionTeacher missionTeacher = new MissionTeacher();
        missionTeacher.setTeacher(t);
        missionTeacher.setMission(m);
        missonTeacherRepository.save(missionTeacher);
    }

}

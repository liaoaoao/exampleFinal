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
        Mission m = missionRepository.findByName(mission.getName());
        if(m ==null) {
            missionRepository.save(mission);
        }else {
            log.debug("任务名已存在");
        }
    }

    public int updateMission(String detail,String name){
        if (missionRepository.updateMission(detail,name)!=0) {
            return missionRepository.updateMission(detail,name);
        }else {
            log.debug("任务不存在");
        }
        return -1;
    }

    public int closeMission(String name){
        if(missionRepository.closeMission(name)!=0) {
            return missionRepository.closeMission(name);
        }else {
            log.debug("任务不存在");
        }
        return -1;
    }

    public void createMissionTeacher(String teachername,String missionname){

        Teacher t = teacherRepository.findByName(teachername);
        Mission m = missionRepository.findByName(missionname);
        MissionTeacher missionTeacher = new MissionTeacher();
        if(t!=null&&m!=null) {
            missionTeacher.setTeacher(t);
            missionTeacher.setMission(m);
            missonTeacherRepository.save(missionTeacher);
        }else {
            log.debug("任务或教师不存在");
        }
    }

}

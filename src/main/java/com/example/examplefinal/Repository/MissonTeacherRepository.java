package com.example.examplefinal.Repository;

import com.example.examplefinal.Entity.Mission;
import com.example.examplefinal.Entity.MissionTeacher;
import com.example.examplefinal.Entity.Teacher;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MissonTeacherRepository  extends JpaRepository<MissionTeacher,Integer> {
    //查找指定老师指定任务
    @Query("select mt from MissionTeacher mt where mt.teacher = :teacher and mt.mission =:mission")
    MissionTeacher findMissionTeacher(@Param("teacher") Teacher teacher, @Param("mission") Mission misson);

    //写回复
    @Modifying
    @Query("UPDATE MissionTeacher mt SET mt.message = :message where mt.teacher=:teacher and mt.mission = :mission")
    Integer writeMessage(@Param("message") String message,@Param("teacher")Teacher teacher,@Param("mission") Mission mission);

    //查找某一老师的所有任务
    @Query("select mt.mission from  MissionTeacher mt where mt.teacher.name =:name")
    List<Mission> findMissionByTeacher(@Param("name")String name);

    //查找某个任务的所有老师的回复信息及其结果
    @Query("select mt from MissionTeacher mt where mt.mission.name = :name")
    List<MissionTeacher> findTeacherByMission(@Param("name") String name);

    //老师回复内容



}

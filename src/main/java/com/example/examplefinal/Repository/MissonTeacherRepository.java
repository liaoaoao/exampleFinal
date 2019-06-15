package com.example.examplefinal.Repository;

import com.example.examplefinal.Entity.Mission;
import com.example.examplefinal.Entity.MissionTeacher;
import com.example.examplefinal.Entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MissonTeacherRepository  extends JpaRepository<MissionTeacher,Integer> {
    //查找指定老师指定任务
    @Query("select mt from MissionTeacher mt where mt.teacher = :teacher and mt.mission =:mission")
    MissionTeacher findMissionTeacher(@Param("teacher") Teacher teacher, @Param("mission") Mission misson);


}

package com.example.examplefinal.Repository;

import com.example.examplefinal.Entity.Mission;
import com.example.examplefinal.Entity.MissionTeacher;
import com.example.examplefinal.Entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MissionRepository extends JpaRepository<Mission,Integer> {


    //管理员修改任务
    @Modifying
    @Query("UPDATE Mission t SET t.missionDetail = :missionDetail where t.missionState ='open'and t.name = :name")
    Integer updateMission(@Param("name")String name);

    //管理员关闭任务
    @Modifying
    @Query("UPDATE Mission t SET t.missionState='close' where  t.name = :name")
    Integer closeMission(@Param("name")String name);

    //根据姓名查询任务
    @Query("select m from Mission m where m.name=:name")
    Mission findByName(@Param("name") String name);

    //获取截至时间
    @Query("select m.endTime from Mission m where m.name = :name")
    LocalDateTime findTime(@Param("name") String name);


}

package com.example.examplefinal.Repository;

import com.example.examplefinal.Entity.Teacher;
import com.example.examplefinal.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
    //根据姓名查找老师
    @Query("select t from Teacher t where t.name=:name")
    Teacher findByName(@Param("name")String name);



    //修改老师住址
    //返回值为int类型，返回操作影响的行数
    @Transactional
    @Modifying
    @Query("UPDATE Teacher t SET t.position=:position ")
    Integer updateTeacherPosition(@Param("position") String position);

    //修改老师细节
    @Transactional
    @Modifying
    @Query("UPDATE Teacher t SET t.detail=:detail ")
    Integer updateTeacherDetail(@Param("detail") String detail);

    //修改老师姓名
    @Transactional
    @Modifying
    @Query("UPDATE Teacher t SET t.name=:name")
    Integer updateTeacherName( @Param("name") String name);

    //修改老师电话
    @Transactional
    @Modifying
    @Query("UPDATE Teacher t SET t.phone=:phone")
    Integer updateTeacherPhone(@Param("phone") String phone);


}

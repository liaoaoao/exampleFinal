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
public interface AdminRepository extends JpaRepository<Teacher,Integer> {
    //添加普通用户为管理员：power = admin
    //删除管理员：Power = user
    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.power = :power where u.id = :id")
    Integer  updateUserPower( @Param("power") String power,@Param("id") int id);
    //修改老师住址
    //返回值为int类型，返回操作影响的行数
    @Transactional
    @Modifying
    @Query("UPDATE Teacher t SET t.position=:position where t.id =:id")
    Integer updateTeacherPosition(@Param("id") int id, @Param("position") String position);

    //修改老师细节
    @Transactional
    @Modifying
    @Query("UPDATE Teacher t SET t.detail=:detail where t.id =:id")
    Integer updateTeacherDetail(@Param("id") int id, @Param("detail") String detail);

    //修改老师姓名
    @Transactional
    @Modifying
    @Query("UPDATE Teacher t SET t.name=:name where t.id =:id")
    Integer updateTeacherName(@Param("id") int id, @Param("name") String name);

    //修改老师电话
    @Transactional
    @Modifying
    @Query("UPDATE Teacher t SET t.phone=:phone where t.id =:id")
    Integer updateTeacherPhone(@Param("id") int id, @Param("phone") String phone);


}


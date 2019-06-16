package com.example.examplefinal.controller;

import com.example.examplefinal.Entity.Teacher;
import com.example.examplefinal.Entity.User;
import com.example.examplefinal.Repository.AdminRepository;
import com.example.examplefinal.Repository.TeacherRepository;
import com.example.examplefinal.Repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api")
public class TeacherController {
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    EntityManager em;
    //增加老师
    @PostMapping("/Admin/AddTeacher")
    public void getIndex2(@RequestBody Teacher teacher ){
        teacherRepository.save(teacher);
    }

    @PostMapping("/Admin/Adjust")
    public void adjustUser(@RequestBody User user, HttpServletRequest request){
        try {
            userRepository.findById(user.getId());
            request.setAttribute("user_id", user.getId());
            log.debug("用户id正确");
            int id = (int)request.getAttribute("user_id");
            System.out.println(id);
        }catch (Exception e){
            log.debug("用户id错误");
        }
    }
    //修改教师细节
    @PostMapping("/Admin/Update1")
    public void adminUpdateUser1(@RequestBody Teacher teacher, HttpServletRequest request){
        //int id = (int)request.getAttribute("user_id");
        //System.out.println(id);
        int i = adminRepository.updateTeacherDetail(teacher.getId(), teacher.getDetail());
        if(i!=0) {
            log.debug("添加成功");
        }else {
            log.debug("无此用户");
        }
    }
    //修改教师姓名
    @PostMapping("/Admin/Update2")
    public void adminUpdateUser2(@RequestBody Teacher teacher, HttpServletRequest request){
        //int id = (int)request.getAttribute("user_id");
        //System.out.println(id);
        int i = adminRepository.updateTeacherDetail(teacher.getId(), teacher.getName());
        if(i!=0) {
            log.debug("添加成功");
        }else {
            log.debug("无此用户");
        }
    }
    //修改教师电话
    @PostMapping("/Admin/Update3")
    public void adminUpdateUser3(@RequestBody Teacher teacher, HttpServletRequest request){
        //int id = (int)request.getAttribute("user_id");
        //System.out.println(id);
        int i = adminRepository.updateTeacherDetail(teacher.getId(), teacher.getPhone());
        if(i!=0) {
            log.debug("添加成功");
        }else {
            log.debug("无此用户");
        }
    }
    //修改教师住址
    @PostMapping("/Admin/Update4")
    public void adminUpdateUser4(@RequestBody Teacher teacher, HttpServletRequest request){
        //int id = (int)request.getAttribute("user_id");
        //System.out.println(id);
        int i = adminRepository.updateTeacherDetail(teacher.getId(), teacher.getPosition());
        if(i!=0) {
            log.debug("添加成功");
        }else {
            log.debug("无此用户");
        }
    }
    //教师操作——————————————————————————————————————————————
    //修改教师细节
    @PostMapping("/Teacher/Update1")
    public void updateUser1(@RequestBody Teacher teacher, HttpServletRequest request){
        //int id = (int)request.getAttribute("user_id");
        //System.out.println(id);
        int i = teacherRepository.updateTeacherDetail(teacher.getDetail());
        if(i!=0) {
            log.debug("添加成功");
        }else {
            log.debug("无此用户");
        }
    }
    //修改教师姓名
    @PostMapping("/Teacher/Update2")
    public void updateUser2(@RequestBody Teacher teacher, HttpServletRequest request){
        //int id = (int)request.getAttribute("user_id");
        //System.out.println(id);
        int i = teacherRepository.updateTeacherName(teacher.getName());
        if(i!=0) {
            log.debug("添加成功");
        }else {
            log.debug("无此用户");
        }
    }
    //修改教师电话
    @PostMapping("/Teacher/Update3")
    public void updateUser3(@RequestBody Teacher teacher, HttpServletRequest request){
        //int id = (int)request.getAttribute("user_id");
        //System.out.println(id);
        int i = teacherRepository.updateTeacherPhone( teacher.getPhone());
        if(i!=0) {
            log.debug("添加成功");
        }else {
            log.debug("无此用户");
        }
    }
    //修改教师住址
    @PostMapping("/Teacher/Update4")
    public void updateUser4(@RequestBody Teacher teacher, HttpServletRequest request){
        //int id = (int)request.getAttribute("user_id");
        //System.out.println(id);
        int i = teacherRepository.updateTeacherPosition( teacher.getPosition());
        if(i!=0) {
            log.debug("添加成功");
        }else {
            log.debug("无此用户");
        }
    }
}



package com.example.examplefinal.controller;

import com.example.examplefinal.Entity.Teacher;
import com.example.examplefinal.Entity.User;
import com.example.examplefinal.Repository.AdminRepository;
import com.example.examplefinal.Repository.UserRepository;
import com.example.examplefinal.component.EncryptorComponent;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api")
public class UserController {

    private Map<String, User> users = new HashMap();

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private EncryptorComponent encryptorComponent;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AdminRepository adminRepository;

    //注册请求
    @PostMapping("/register")
    public Map register(@RequestBody User user) {
        try {
            userRepository.findUserName(user.getUsername()).equals(null);
            log.debug("用户名已存在");
        } catch (Exception e) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            users.put(user.getUsername(), user);
            userRepository.save(user);
        }
        return Map.of("user", user);
    }

    //登录请求
    @PostMapping("/login")
    public void login(@RequestBody User user, HttpServletResponse response) {
        try {
            User u = userRepository.findUserName(user.getUsername());
            log.debug(u.getUsername());
        } catch (Exception E) {
            log.debug("错误");
        }

        Optional.ofNullable(userRepository.findUserName(user.getUsername()))
                .or(() -> {
                    throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "用户名错误");
                })
                .ifPresent(u -> {
                    if (!passwordEncoder.matches(user.getPassword(), u.getPassword())) {
                        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "密码错误");
                    }
                    log.debug("登录成功");
                    Map map = Map.of("name", u.getUsername());
                    // 生成加密token
                    String token = encryptorComponent.encrypt(map);
                    // 在header创建自定义的权限
                    response.setHeader("Authorization", token);
                    //创建管理权限
                    response.setHeader("Admin", u.getPower());
                });
    }

    //增加用户
    @PostMapping("/Admin/AddUser")
    public void getindex(@RequestBody User user) {
        userRepository.save(user);
        log.debug("添加成功");
    }
    //修改用户管理权限
    @PostMapping("/Admin/UpdateUserPower")
    public void updateUserPower(@RequestBody User user){
       int i =  adminRepository.updateUserPower(user.getPower(), user.getId());
       if(i!=0){
           log.debug("修改成功，当前权限为"+user.getPower());
       }else{
           log.debug("无此用户");
       }
    }

}
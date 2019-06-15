package com.example.examplefinal.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {
    //用户名
    @Id
    private int id;
    private String username;
    //密码
    private String password;
    //权限
    private String power;
    @OneToOne(mappedBy = "user")
    private Teacher teacher;

}

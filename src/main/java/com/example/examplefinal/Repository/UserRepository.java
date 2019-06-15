package com.example.examplefinal.Repository;

import com.example.examplefinal.Entity.ExamTeacher;
import com.example.examplefinal.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User,Integer> {

    //查用户名和密码
    @Query("SELECT u FROM User u WHERE u.username = :username AND u.password = :password")
    User findUser(@Param("username") String username,@Param("password") String password);

    //查用户名
    @Query("SELECT u FROM User u WHERE u.username = :username")
    User findUserName(@Param("username")String username);

}


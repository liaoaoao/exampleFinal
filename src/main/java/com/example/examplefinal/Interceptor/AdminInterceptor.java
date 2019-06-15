package com.example.examplefinal.Interceptor;

import lombok.Setter;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Component
@Slf4j
public class AdminInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        String s = request.getHeader("Admin");
        if(s.equals("user")){
            throw  new ResponseStatusException(HttpStatus.UNAUTHORIZED, "未登录！");
        }else {
            log.debug("您是管理员");
        }
        return true;
    }
}

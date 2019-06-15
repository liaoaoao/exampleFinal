package com.example.examplefinal;

import com.example.examplefinal.Interceptor.AdminInterceptor;
import com.example.examplefinal.Interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{

        @Autowired
        private LoginInterceptor loginInterceptor;
        @Autowired
        private AdminInterceptor adminInterceptor;

        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            /*
            registry.addInterceptor(loginInterceptor)
                    .addPathPatterns("/api/**")
                    .excludePathPatterns("/api/login")
                    .excludePathPatterns("/api/register");
            registry.addInterceptor(adminInterceptor)
                    .addPathPatterns("/api/**")
                    .excludePathPatterns("/api/login")
                    .excludePathPatterns("/api/register");
                    */
        }

}

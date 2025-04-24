package com.kijong.demo.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/* 설명.
*   CORS block을 해제하기 위한 설정
*/

// @Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")

//                .allowedOrigins("http://localhost:5173")                // 프론트엔드 포트 설정
                .allowedOrigins("http://localhost:30000")                // 프론트엔드 포트 설정
                .allowedMethods("GET", "POST", "PUT", "DELETE");        // 메소드 허용 설정
    }
}

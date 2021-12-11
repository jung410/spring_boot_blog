package com.min0.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 스프링이 com.min0.blog 패키지 이하를 스캔해서 특정 어노테이션이 붙어있는 클래스 파일들을 New해서 스프링 컨테이너에 관리해준다.
public class BlogControllerTest {

    @GetMapping("/test/hello")
    public String hello() {
        return "<h1>Hello Spring Boot!!</h1>";
    }
}

package com.example.springbootBoard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestPage {
    // git dev 생성 테스트
    // git dev 생성 테스트
    // git dev 생성 테스트
    @GetMapping("/")
    public String test() {
        return "test";
    }
}

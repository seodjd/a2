package com.example.firstproject2.api;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 일반 Controller는 View를 반환하지만 RestController는 JSON을 반환한다.
public class FirstApiController {

    @GetMapping("/api/hello")
    public String hello(){
        return "hello world!";  // 일반 Controller는 View.html을 반환하지만 RestController는 텍스트 또는 JSON을 반환한다.
    }

}

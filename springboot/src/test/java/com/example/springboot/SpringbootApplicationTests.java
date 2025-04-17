package com.example.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringbootApplicationTests {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplicationTests.class, args);
    }

    //健康检查的接口
    @GetMapping("/api/health")
    public String health() {
        return "SUCCESS";
    }
}
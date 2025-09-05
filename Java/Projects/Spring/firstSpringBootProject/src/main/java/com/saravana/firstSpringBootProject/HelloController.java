package com.saravana.firstSpringBootProject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@RestController
public class HelloController {
    @GetMapping("/")
    public String sayHello() {
        return "Hello, Spring Boot! " + ZonedDateTime.now();
    }
}

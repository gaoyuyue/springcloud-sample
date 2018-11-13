package io.github.gaoyuyue.producerservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @Value("${version}")
    private String version;

    @GetMapping("/version")
    public String version() {
        return version;
    }
}

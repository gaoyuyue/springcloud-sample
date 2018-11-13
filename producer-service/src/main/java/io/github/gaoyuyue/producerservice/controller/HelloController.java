package io.github.gaoyuyue.producerservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @Value("${helloworld}")
    private String helloworld;

    @GetMapping("/helloworld")
    public String helloworld() {
        return helloworld;
    }
}

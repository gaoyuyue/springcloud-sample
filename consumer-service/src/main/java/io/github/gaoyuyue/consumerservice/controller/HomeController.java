package io.github.gaoyuyue.consumerservice.controller;

import io.github.gaoyuyue.consumerservice.remote.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @Autowired
    private HelloRemote helloRemote;

    @GetMapping("/index")
    public String index() {
        return helloRemote.hello();
    }
}

package io.github.gaoyuyue.userservice.controller;

import io.github.gaoyuyue.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public Map<String, Object> getUserByUserName(@RequestParam String userName) {
        return userService.getSecurityUserByUserName(userName);
    }
}




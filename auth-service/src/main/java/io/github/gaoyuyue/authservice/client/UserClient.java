package io.github.gaoyuyue.authservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(value = "user-service")
public interface UserClient {
    @GetMapping("/user")
    Map<String, Object> getUserByUserName(@RequestParam("userName") String userName);
}

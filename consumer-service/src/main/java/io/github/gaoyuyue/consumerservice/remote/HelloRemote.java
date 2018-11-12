package io.github.gaoyuyue.consumerservice.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "producer-service", fallback = HelloRemoteHystrix.class)
public interface HelloRemote {
    @RequestMapping("/hello")
    String hello();
}

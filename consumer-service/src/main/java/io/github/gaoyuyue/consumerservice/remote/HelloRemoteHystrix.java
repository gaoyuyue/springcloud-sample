package io.github.gaoyuyue.consumerservice.remote;

import org.springframework.stereotype.Component;

@Component
public class HelloRemoteHystrix implements HelloRemote {
    @Override
    public String hello() {
        return "服务不可用";
    }
}

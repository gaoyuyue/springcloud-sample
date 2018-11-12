package io.github.gaoyuyue.producerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProducerService {
    public static void main(String[] args) {
        SpringApplication.run(ProducerService.class, args);
    }
}

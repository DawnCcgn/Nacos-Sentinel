package com.hpw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author gn
 * @date 2021/7/12 10:23
 */

@SpringBootApplication
public class ApplicationSentinelNacosConsumer {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationSentinelNacosConsumer.class);
    }

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}

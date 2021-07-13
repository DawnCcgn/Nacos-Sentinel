package com.hpw.consumer;

import com.hpw.openfeign.ConsumerServerOpenFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ServerConsumer4 {


    @Autowired

    private ConsumerServerOpenFeign consumerServerOpenFeign;
    @GetMapping("getServer4")
    public String getProviderMessage() {
        String nacosServer = consumerServerOpenFeign.getNacosServer();

        return nacosServer;
    }
}

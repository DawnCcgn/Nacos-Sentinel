package com.hpw.consumer;

import com.hpw.openfeign.ConsumerServerOpenFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController
public class ServerConsumer3 {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired

    private ConsumerServerOpenFeign consumerServerOpenFeign;

    //通过注解LoadBalance实现负载均衡
     @GetMapping("getServer3")
     public String getProviderMessage() {
         String nacosServer = consumerServerOpenFeign.getNacosServer();


//         关键点：将原有IP:端口替换为服务名，RestTemplate便会在通信前自动利用Ribbon查询可用provider-service实例列表
//        再根据负载均衡策略选择节点实例
        String result = restTemplate.getForObject("http://nacos-server/nacos", String.class);
         return "consumer-service获得数据:" + result;
    }
}

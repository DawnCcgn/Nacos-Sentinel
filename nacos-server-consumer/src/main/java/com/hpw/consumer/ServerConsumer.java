package com.hpw.consumer;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController
public class ServerConsumer {

    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping("getServer")
    public String getServer(){

        //1.根据服务名称取出该服务下的实例列表

        List<ServiceInstance> instances = discoveryClient.getInstances("nacos-server");

        ServiceInstance serviceInstance = instances.get(0);
        URI uri = serviceInstance.getUri();// ip和端口号
        // 2.使用本地负载均衡器 选择一个地址调用
        // 3. 使用httpclient调用接口
        String result = restTemplate.getForObject(uri + "/nacos", String.class);
        System.out.println(uri);
        return result;

    }
}

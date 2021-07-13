package com.hpw.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author gn
 * @date 2021/7/12 10:55
 */

@RestController
public class SentinelNacosServerConsumer {

    @Resource
    RestTemplate restTemplate;

    @GetMapping("getSentinelServer/{id}")
    public String getProviderMessage(@PathVariable Integer id) {

        String result = restTemplate.getForObject("http://sentinel-server/sentinel/" + id, String.class);
        return "consumer-service获得数据:" + result;
    }


    @GetMapping("getSentinelServer2/{id}")
    @SentinelResource(value = "getSentinel2",fallback = "exceptionHandler")
    public String getProviderMessage2(@PathVariable Integer id) {

        String result = restTemplate.getForObject("http://sentinel-server/sentinel2/" + id, String.class);
        return "consumer-service获得数据:" + result;
    }



    public static String flowHandler(@PathVariable Integer id){

        return "sentinelServer的限流处理" + "---------->" + "----->id: " + id ;
    }


    public static String exceptionHandler(@PathVariable Integer id, BlockException e){

        return "sentinelServer的降级处理" +"---------->" + "----->id: " + id;
    }

}

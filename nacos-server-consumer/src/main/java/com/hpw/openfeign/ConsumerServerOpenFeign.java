package com.hpw.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author gn
 * @date 2021/7/1 10:00
 */

@Component
@FeignClient(name = "nacos-server")
public interface ConsumerServerOpenFeign {


    @GetMapping("nacos")
    public String getNacosServer();
}

package com.hpw.controller;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Random;

/**
 * @author gn
 * @date 2021/7/12 10:29
 */

@Slf4j
@RestController
public class SentinelNacosServiceController3 {


    @Value("${server.port}")
    String port;

    @RequestMapping("degrade")
    @SentinelResource(value = "sentinel2",
            fallback = "exceptionHandler",
            blockHandler = "flowHandler"
    )
    public String circuitBreak2(){

        Random random = new Random();
        int  num = random.nextInt(2);

        int i = 1/num;
        log.info("circuitBreak 测试  异常比例----->" + num);
        return "熔断 ------异常比例----->" + num;
    }



    public  String flowHandler(BlockException e){

        log.error("sentinelServer的限流处理" +"---------->" + "port: " + port );
        return "sentinelServer的限流处理" + "---------->" + port;
    }

    public  String exceptionHandler(){
        log.error("sentinelServer的降级处理" +"---------->" + "port: " + port );
        return "sentinelServer的降级处理" +"---------->" + "port: " + port ;
    }
}

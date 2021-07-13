package com.hpw.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.hpw.hander.MyHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @author gn
 * @date 2021/7/13 14:46
 */

@Slf4j
@RestController
public class SentinlePullController {


    @RequestMapping("sentinelPullCc")
    @SentinelResource(value = "sentinelPull",
    blockHandlerClass = MyHandler.class,
    blockHandler = "sentinelPullFlow",
    fallbackClass = MyHandler.class,
    fallback = "sentinelPullException")
    public String sentinelPullTest(){

        Random random = new Random();
        int  num = random.nextInt(2);
        log.warn("num 为" + num);
        int i = 1/num;


        return "sentinel ----------->pull" + num;
    }

}

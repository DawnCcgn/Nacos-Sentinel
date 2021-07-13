package com.hpw.controller;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.hpw.myhandler.MyExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author gn
 * @date 2021/7/12 10:29
 */

@Slf4j
@RestController
public class SentinelNacosServiceController2 {

    public static HashMap<Integer,String> hashMap = new HashMap<>();

    static {

        hashMap.put(1,"aof");
        hashMap.put(2,"noc");
        hashMap.put(3,"zed");

    }

    @Value("${server.port}")
    String port;

    @RequestMapping("sentinel2/{id}")
    @SentinelResource(value = "sentinel3",
//    blockHandlerClass = MyExceptionHandler.class,
            blockHandler = "flowHandler",
//    fallbackClass = MyExceptionHandler.class,
            fallback = "exceptionHandler")
    public String sentinelServer(@PathVariable Integer id){


        String result = null;
        if (id == 1 || id == 2 || id == 3){
            result = hashMap.get(id);
        }else if (id == 6){

            int i = 1/0;
        }else {

            result = new NullPointerException("查不到该参数").toString();

        }

        log.error("输出为: "+  " ---------->由" + port + "提供服务");
        return "输出为: "+ " ---------->由" + port + "提供服务" ;
    }



    public  String flowHandler(Integer id,BlockException e){

        return "sentinelServer的限流处理" + "---------->" + port + "----->id: " + id ;
    }

    public  String exceptionHandler(Integer id){
        return "sentinelServer的降级处理" +"---------->" + "port: " + port + "----->id: " + id;
    }
}

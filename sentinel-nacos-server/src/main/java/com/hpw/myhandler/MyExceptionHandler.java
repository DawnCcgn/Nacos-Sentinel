package com.hpw.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author gn
 * @date 2021/7/8 16:59
 */

@Slf4j
public class MyExceptionHandler {

    @Value("${server.port}")
    static String port;

    public static   String flowHandler(Integer id,BlockException e){

        return "sentinelServer的限流处理" + "---------->" + port + "----->id: " + id ;
    }

    public static   String exceptionHandler(Integer id){
        return "sentinelServer的降级处理" +"---------->" + "port: " + port + "----->id: " + id;
    }

}

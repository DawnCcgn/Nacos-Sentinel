package hpw.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import hpw.service.SentinelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @author gn
 * @date 2021/7/6 14:48
 */

@Slf4j
@RestController
public class FlowControlController {

    @Resource
    SentinelService sentinelService;

    @GetMapping("/hello")
    @SentinelResource(value = "hello",
    blockHandler = "flowHandler",
    fallback = "exceptionHandler")
    public String sayHello(){
        int i = 1/0;
        return "Hello ----Zed";
    }

    @GetMapping("/hello2")
    public String sayHello2(){
        return "Hello ----Zed2";
    }

    @GetMapping("/hello3")
    public String sayHello3(){
        String service = sentinelService.getService();
        log.info(service + Thread.currentThread().getName() + "===hello3===");
        return service + Thread.currentThread().getName() + "===hello3===";

    }


    @GetMapping("/hello4")
    public String sayHello4(){
        String service = sentinelService.getService();
        return service + "===hello4===";
    }


    public String exceptionHandler(){

        log.error("处理异常");
        return "异常处理";
    }

    public String flowHandler(BlockException e){

        log.info("限流处理");
        return "限流处理";
    }



}

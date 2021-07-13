package hpw.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author gn
 * @date 2021/7/8 10:33
 */
@Slf4j
@RestController
public class CircuitBreakController {


    @RequestMapping("circuitBreak")
    @SentinelResource(value = "circuitBreak",
            fallback = "exceptionHandler",
            blockHandler = "flowHandler")
    public String circuitBreak(){

        Random random = new Random();
        int sleepTime = random.nextInt(70)* 10;


        try { TimeUnit.MILLISECONDS.sleep(sleepTime); } catch (InterruptedException e) { e.printStackTrace(); }
        log.info("circuitBreak 测试RT" + sleepTime);
        return "熔断 ------慢调用比例" + sleepTime;
    }

    @RequestMapping("circuitBreak2")
    @SentinelResource(value = "circuitBreak2",
            fallback = "exceptionHandler",
            blockHandler = "flowHandler")
    public String circuitBreak2(){

        Random random = new Random();
        int  num = random.nextInt(2);

        int i = 1/num;
        log.info("circuitBreak 测试  异常比例----->" + num);
        return "熔断 ------异常比例----->" + num;
    }


    @RequestMapping("circuitBreak3")
    @SentinelResource(value = "circuitBreak3",
            fallback = "exceptionHandler",
            blockHandler = "flowHandler")
    public String circuitBreak3(){

        Random random = new Random();
        int  num = random.nextInt(3);

        int i = 1/num;

        log.info("circuitBreak 测试  异常数----->" + num);
        return "熔断 ------异常数----->" + num;
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

package hpw.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import hpw.myhandler.MyExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gn
 * @date 2021/7/8 15:20
 */

@Slf4j
@RestController
public class HotController {



    @RequestMapping("hot")
    @SentinelResource(value = "hot",
            blockHandlerClass = MyExceptionHandler.class,
            blockHandler = "flowHandler")
    public String hot(@RequestParam(value = "s1",required = false) String s1,
                      @RequestParam(value =  "s2",required = false) String s2){

        return "热点规则--------->" + s1 + s2;
    }



    public String flowHandler(String s1, String s2, BlockException e){

        log.info(Thread.currentThread().getName());

        return "热点限流操作" +Thread.currentThread().getName();
    }
}

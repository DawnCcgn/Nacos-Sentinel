package hpw.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import hpw.myhandler.MyExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gn
 * @date 2021/7/8 17:00
 */

@RestController
public class MyHandlerController {


    @RequestMapping("handler")
    @SentinelResource(value = "handler",
            blockHandlerClass = MyExceptionHandler.class,
            blockHandler = "flowException2",
            fallbackClass = MyExceptionHandler.class,
            fallback = "exceptionHandler"
    )
    public String handlerTest(@RequestParam(value = "s") String s){

        return "自定义处理测试" +s;
    }
}

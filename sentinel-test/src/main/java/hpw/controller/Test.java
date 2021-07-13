package hpw.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author gn
 * @date 2021/7/9 10:36
 */

@Slf4j
@RestController
public class Test {


    /**
     * @description 演示默认的限流回调方法
     * @author gn
     * @params
     * @date  2021/7/9 11:18
     */
    @RequestMapping("test")
    public String test(){


        try {
            int i = 1/0;
        }catch (RuntimeException e){
            return "参数异常";
        }
        return "异常";
    }

    /**
     * @description 演示默认的/test2和test2资源的限流回调方法
     * @author gn
     * @params
     * @date  2021/7/9 11:18
     */
    @RequestMapping("test2")
    @SentinelResource(value = "test2",
            fallback = "exceptionHandler",
            blockHandler = "flowHandler")
    public String test2(){

        int i = 1/0;
        return "异常";
    }

    /**
     * @description 演示默认资源名和@SentinelResource注解标注资源名相同的限流回调方法
     * @author gn
     * @params
     * @date  2021/7/9 11:19
     */
    @RequestMapping("test3")
    @SentinelResource(value = "/test3",
            fallback = "exceptionHandler",
            blockHandler = "flowHandler"
    )
    public String test3(){

        int i = 1/0;
        return "异常";
    }

/**
 * @description 演示cpu占用超过设定阈值的限流
 * @author gn
 * @params
 * @date  2021/7/9 12:17
 */
    @RequestMapping("test4")
    @SentinelResource(value = "test4",
            fallback = "exceptionHandler",
            blockHandler = "flowHandler")
    public String test4(){

        int i = 0;
        while(true){
            HashMap<Object, Object> objectObjectHashMap = new HashMap<>(i + 1);
            objectObjectHashMap.put(i,i);
            i++;
        }
    }

/**
 * @description 演示发生异常时不调用默认的异常回调方法
 * @author gn
 * @params
 * @date  2021/7/9 12:19
 */
@RequestMapping("test5")
@SentinelResource(value = "test5",
        fallback = "exceptionHandler2",
        blockHandler = "flowHandler",
        exceptionsToIgnore = ArithmeticException.class)
public String test5(@RequestParam(value = "id") Integer id) {

    if (id == 1){
        return "输出" + id;
    }else if (id == 2){
        return  "输出" +  id;
    }else if (id == 3){
        throw new IllegalArgumentException("参数异常");
    }else{

        int i = 1/0;
        return "异常";
    }
}


    public String exceptionHandler(){

        log.error("处理异常");
        return "异常处理";
    }


    public String exceptionHandler2(Integer id){

        log.error("处理异常");
        return "异常处理";
    }

    public String flowHandler(BlockException e){

        log.warn("限流处理");
        return "限流处理";
    }

}

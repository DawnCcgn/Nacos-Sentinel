package hpw.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;

/**
 * @author gn
 * @date 2021/7/8 16:59
 */

@Slf4j
public class MyExceptionHandler {


    public static String flowHandler(String s1, String s2, BlockException e){

        log.info(Thread.currentThread().getName());

        return "热点限流操作" +Thread.currentThread().getName();
    }


    public static String flowException(String s,BlockException e){

        return "自定义的限流处理1" +s;
    }


    public static String flowException2(String s,BlockException e){

        return "自定义的限流处理2" +s;
    }


    public static  String exceptionHandler (String s){

        return  "自定义的降级处理";
    }
}

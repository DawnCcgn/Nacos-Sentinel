package com.hpw.hander;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @author gn
 * @date 2021/7/13 15:45
 */


public class MyHandler {


    //限流回调方法
    public static String sentinelPullFlow(BlockException e){

        return "sentinel ------>pull  限流处理";
    }
    //异常回调方法
    public static String sentinelPullException(){

        return "sentinel ---->pull  降级处理";
    }

}

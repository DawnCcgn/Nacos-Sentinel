package com.hpw.hander;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @author gn
 * @date 2021/7/13 15:45
 */


public class MyHandler {


    public static String sentinelPullFlow(BlockException e){

        return "sentinel ------>pull  限流处理";
    }

    public static String sentinelPullException(){

        return "sentinel ---->pull  降级处理";
    }

}

package com.hpw.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/**
 * @author gn
 * @date 2021/7/7 14:28
 */

@Service
public class OrderService {

    @SentinelResource("getOrder")
    public String getOrder(){

        return "order";
    }
}

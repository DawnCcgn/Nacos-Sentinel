package com.hpw.controller;

import com.hpw.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gn
 * @date 2021/7/7 14:29
 */

@RestController
public class TestController {

    @Autowired
    OrderService orderService;

    @RequestMapping("/test-a")
    public String getOrder(){

        orderService.getOrder();

        return "test-a";
    }


    @RequestMapping("/test-b")
    public String getOrder2(){

        orderService.getOrder();

        return "test-b";
    }
}

package com.hpw.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

@RestController

public class NacosServer {

    @Autowired
    HttpServletRequest httpServletRequest;

    @RequestMapping("nacos")
    public String nacosServer(){




        int localPort = httpServletRequest.getLocalPort();
        String localAddr = httpServletRequest.getLocalAddr();


//        try {
//            TimeUnit.SECONDS.sleep(3);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


        System.out.println("demadita");

        System.out.println(localAddr + ":"+ localPort+ "/" + "nacos-server");
        return  localAddr + ":"+ localPort+ "/" + "nacos-server" ;
    }

}

package com.hpw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author gn
 * @date 2021/6/24 11:25
 */


@SpringBootApplication
public class AppNacosConfigZ {
    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext = SpringApplication.run(AppNacosConfigZ.class, args);
//        String userName = applicationContext.getEnvironment().getProperty( "user.name" );
//        String userAge = applicationContext.getEnvironment().getProperty( "user.age" );
//        System.err.println( "用户名：" +userName+ "; 年龄：" +userAge);

    }

}

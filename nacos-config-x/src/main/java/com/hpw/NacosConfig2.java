package com.hpw;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;


import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.Executor;


public class NacosConfig2 {


    public static void main(String[] args) throws NacosException {

        String serverAddr = "192.168.80.195:8848";
        String dataId = "nacos-config.yaml";
        String dataId2 = "nacos-config-dev.yaml";

        String group = "DEFAULT_GROUP";
        Properties properties = new Properties();
        properties.put("serverAddr",serverAddr);

        ConfigService configService = NacosFactory.createConfigService(properties);
        //readTimeout  是读取配置的超时时间
        String config = configService.getConfig(dataId, group, 1000);
        String config2 = configService.getConfig(dataId2, group, 1000);

        System.out.println(config);
        System.out.println(config2);


        //添加Listener,作用和@RefreshScope一样
        configService.addListener(dataId, group, new Listener() {
            @Override
            public Executor getExecutor() {
                return null;
            }

            @Override
            public void receiveConfigInfo(String s) {
                System.out.println(s);
            }
        });

        configService.addListener(dataId2, group, new Listener() {
            @Override
            public Executor getExecutor() {
                return null;
            }

            @Override
            public void receiveConfigInfo(String s2) {
                System.out.println(s2);
            }
        });

        try {
            System.in.read();//
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

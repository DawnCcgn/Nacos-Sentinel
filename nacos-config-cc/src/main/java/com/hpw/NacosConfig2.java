package com.hpw;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.Executor;

@Slf4j
public class NacosConfig2 {


    public static void main(String[] args) throws NacosException {

        String serverAddr = "192.168.80.195:8848";
        String dataId = "nacos-config.yaml";

        String group = "DEFAULT_GROUP";


        Properties properties = new Properties();
        properties.put("serverAddr",serverAddr);
        ConfigService configService = NacosFactory.createConfigService(properties);
        String config = configService.getConfig(dataId, group, 3000);
        //添加Listener,作用和@RefreshScope
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

        try {
            System.in.read();//
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(config);

    }
}

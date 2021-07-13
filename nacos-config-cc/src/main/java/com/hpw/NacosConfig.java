package com.hpw;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RefreshScope    //这个注解可以动态更新配置文件
public class NacosConfig {

    @Value("${topic:}")
    private String topic;
    @Value("${name:}")
    private String name;
    @Value("${what:}")
    private String what;
    @Value("${why:}")
    private String why;


    @GetMapping("getConfig")
    public String getAll(){
        return "<html><p>" +
                "" +topic +
                "</br>" + name +
                "</br>" + what +
                "</br>" + why +
                "</br>";

    }
}

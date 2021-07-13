package com.hpw.consumer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;




@RestController
public class ServerConsumer2 {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

//通过代码实现ribbon的负载均衡
    @GetMapping("getServer2")
     public String getProviderMessage() {
        //loadBalancerClient.choose()方法会从 Nacos 获取 provider-service 所有可用实例，
        //并按负载均衡策略从中选择一个可用实例，封装为 ServiceInstance（服务实例）对象
        //结合现有环境既是从192.168.80.195:8083、192.168.80.195:8084、192.168.80.195:8085三个实例中选择一个包装为ServiceInstance
        ServiceInstance serviceInstance = loadBalancerClient.choose("nacos-server");
        //获取服务实例的 IP 地址
        String host = serviceInstance.getHost();
        //获取服务实例的端口
        int port = serviceInstance.getPort();
        //在日志中打印服务实例信息
        //通过 RestTemplate 对象的 getForObject() 方法向指定 URL 发送请求，并接收响应。
        //getForObject()方法有两个参数：
        //1. 具体发送的 URL，结合当前环境发送地址为：http://192.168.80.195:8084/nacos-server
        //2. String.class说明 URL 返回的是纯字符串，如果第二参数是实体类， RestTemplate 会自动进行反序列化，为实体属性赋值
        String result = restTemplate.getForObject("http://" + host + ":" + port + "/nacos", String.class);
        //输出响应内容
        //向浏览器返回响应
        System.out.println("本次调用由nacos-service的" + host + ":" + port + "/"  + result);
        return "本次调用由nacos-service的" + host + ":" + port + " 实例节点负责处理"  + result;
     }

}

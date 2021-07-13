package com.hpw.config;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.ribbon.NacosServer;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.Server;

import javax.annotation.Resource;

/**
 * @author gn
 * @date 2021/6/28 17:05
 */



public class NacosWeightLoadBalancerRule extends AbstractLoadBalancerRule {
        @Override
        public void initWithNiwsConfig(IClientConfig clientConfig) {}

        @Resource
        private NacosDiscoveryProperties nacosDiscoveryProperties;

        @Override
        public Server choose(Object key) {
            // 1.获取服务的名称
            BaseLoadBalancer loadBalancer = (BaseLoadBalancer) this.getLoadBalancer();
            String serverName = loadBalancer.getName();
            // 2.此时Nacos Client会自动实现基于权重的负载均衡算法
            NamingService namingService = nacosDiscoveryProperties.namingServiceInstance();


            try {
                Instance instance = namingService.selectOneHealthyInstance(serverName);
                return new NacosServer(instance);
            } catch (NacosException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

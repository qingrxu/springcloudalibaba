package com.ideapro.order.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MyRule extends AbstractLoadBalancerRule {
    @Override
    //初始化配置
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object o) {

        ILoadBalancer iLoadBalancer = this.getLoadBalancer();
        //获得当前请求的实例
        List<Server> reachableServers = iLoadBalancer.getReachableServers();

        int i = ThreadLocalRandom.current().nextInt(reachableServers.size());

        Server server = reachableServers.get(i);

        System.out.println(i);
        return server;
    }
}

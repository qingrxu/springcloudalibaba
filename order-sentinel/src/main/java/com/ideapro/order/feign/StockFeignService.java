package com.ideapro.order.feign;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 通过动态代理实现
 *name 指定调用rest接口对应的服务名
 *path 指定rest接口所在StockController指定的@RequestMapping的值
 */

@FeignClient(name = "stock-service",path = "/stock")
public interface StockFeignService {

    @RequestMapping("/reduct")
    public String reduct();
}

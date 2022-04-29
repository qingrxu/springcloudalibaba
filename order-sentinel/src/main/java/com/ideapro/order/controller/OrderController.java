package com.ideapro.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ideapro.order.feign.StockFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    StockFeignService stockFeignService;

    @RequestMapping("/add")
    @SentinelResource(value = "add",blockHandler = "addBlockHandler")
    public String add(){
        System.out.println("add Success");

        //String msg = restTemplate.getForObject("http://localhost:8011/stock/reduct",String.class);
        //restTemplate方式调用
        //String msg = restTemplate.getForObject("http://stock-service/stock/reduct",String.class);
        //openfeigns方式电泳
        String msg = stockFeignService.reduct();
        return "Hello " + msg;
    }

    public String addBlockHandler(BlockException e){
        return "限流";
    }
}

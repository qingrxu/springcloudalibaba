package com.ideapro.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/add")
    public String add(){
        System.out.println("add Success");
        String msg = restTemplate.getForObject("http://localhost:8011/stock/reduct",String.class);
        return "Hello " + msg;
    }
}

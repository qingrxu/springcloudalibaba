package com.ideapro.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/stock")
public class StockController {


    @Value("${server.port}")
    String port;

    @RequestMapping("/reduct")
    public String reduct(){
        System.out.println("reduct Success");
        return "reduct Success" + port;
    }
}

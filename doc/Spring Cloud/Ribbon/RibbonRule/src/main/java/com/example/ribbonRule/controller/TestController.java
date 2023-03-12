package com.example.ribbonRule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class TestController {
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    SimpleDateFormat sdf=new SimpleDateFormat("yyy-MM-dd hh:mm:ss");

    @GetMapping("/test")
    public String test() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("myProvider");
       return serviceInstance.getHost() + ":" + serviceInstance.getPort() +
               " " + sdf.format(new Date());
    }
}

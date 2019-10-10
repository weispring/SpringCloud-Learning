package com.didispace.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ComputeService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(//此方法必须在一个类里面
    commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000"),
        @HystrixProperty(name = "execution.timeout.enabled", value = "true")},fallbackMethod = "addServiceFallback")
    public String addService() {
        //execution.timeout.enabled 为true超时才会进入方法 addServiceFallback
        return restTemplate.getForEntity("http://compute-service/add?a=10&b=20", String.class).getBody();
    }

    //实现负载均衡 http://compute-service/add?a=10&b=20,通过服务名选择服务


    public String addServiceFallback() {
        return "error";
    }

}

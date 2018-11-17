package com.didispace.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "compute-service",url = "http://localhost:3333",fallback = ComputeClientHystrix.class)
public interface ComputeClient {

    /**
     * url首选，先调用，发生错误，才会找注册中心
     *
     * fallback freign熔断机制
     * @param a
     * @param b
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/add")
    Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);

}
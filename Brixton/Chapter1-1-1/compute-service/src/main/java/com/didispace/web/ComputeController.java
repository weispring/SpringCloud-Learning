package com.didispace.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.util.Map;

@RestController
public class ComputeController {

    private final Logger logger = Logger.getLogger(getClass());

    //服务发现，获取可以发现的服务
    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    public Integer add(@RequestParam Integer a, @RequestParam Integer b) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
       /* if (true){
            throw new RuntimeException("测试fallback ");
        }*/
        ServiceInstance instance = client.getLocalServiceInstance();
        URI url = instance.getUri();
        Map<String,String> map = instance.getMetadata();
        Integer r = a + b;
        logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + url.toString()+ ", result:" + r);
        return r;
    }

}
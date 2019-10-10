package com.didispace.web;

import com.didispace.service.ComputeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    ComputeClient computeClient;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer add() {
        /*if (true){
            throw new RuntimeException("测试fallback ");//此处异常不会触发fallback
        }*/
        return computeClient.add(10, 20);
    }

}
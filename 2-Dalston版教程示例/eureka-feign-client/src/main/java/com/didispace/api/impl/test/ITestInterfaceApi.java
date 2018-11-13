package com.didispace.api.impl.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther: lixianchun
 * @Date: 2018/11/13 10:20
 * @Description:
 */
public interface ITestInterfaceApi {

    @GetMapping("/test/hello")
    String sayHello(@RequestParam(value = "name") String name);
}

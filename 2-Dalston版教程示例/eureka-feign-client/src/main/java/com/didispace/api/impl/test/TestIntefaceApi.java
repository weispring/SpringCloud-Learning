package com.didispace.api.impl.test;

import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: lixianchun
 * @Date: 2018/11/13 10:21
 * @Description:
 */
@RestController
public class TestIntefaceApi implements ITestInterfaceApi {
    @Override
    public String sayHello(String name) {
        return "哈哈哈："+name;
    }
}

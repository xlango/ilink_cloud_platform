package com.qianli.ilink.cloud_platform.messagecenter.web;


import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "测试用例",tags = {"hello controller"})
public class HelloController {

    @Value("${server.port}")
    private int port;
    @RequestMapping("hello")
    public String hello() throws Exception {
        return "hello:port = " + port;
    }

    @RequestMapping(value = "hello1",method = RequestMethod.POST)
    public String hello1(String name,String pwd){
        return "name:"+name+"pwd:"+pwd;
    }
}

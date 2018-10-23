//package com.qianli.ilink.cloud_platform.messagecenter.web;
//
//
//import io.swagger.annotations.Api;
//import org.apache.commons.lang.StringUtils;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@Api(value = "测试用例",tags = {"hello controller"})
//public class HelloController {
//
//    @Value("${server.port}")
//    private int port;
//    @RequestMapping("hello")
//    public String hello(String name) throws Exception {
//        if (StringUtils.isEmpty(name))
//            throw new Exception();
//        return "hello " + name + ":port = " + port;
//    }
//
//}

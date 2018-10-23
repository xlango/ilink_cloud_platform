//package com.qianli.ilink.cloud_platform.messagecenter.core.config;
//
//
//import com.qianli.ilink.cloud_platform.commons.core.utils.SwaggerUtils;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@Configuration
//@EnableSwagger2
//public class Swagger2Config {
//
//    @Bean
//    public Docket createSwagger2(){
//        return SwaggerUtils.createSwagger2("com.qianli.ilink.cloud_platform.messagecenter.web");
//    }
//
//}
// TODO: 2018/8/19 swagger2无法搞定protolbuf的数据入參,有bug！！！导致死循环

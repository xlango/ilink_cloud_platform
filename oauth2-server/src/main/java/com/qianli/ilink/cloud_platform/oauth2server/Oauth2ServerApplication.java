package com.qianli.ilink.cloud_platform.oauth2server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@Slf4j
@SpringBootApplication
public class Oauth2ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2ServerApplication.class, args);
    }

}

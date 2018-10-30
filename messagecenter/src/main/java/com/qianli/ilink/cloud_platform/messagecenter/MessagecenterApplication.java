package com.qianli.ilink.cloud_platform.messagecenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.qianli.ilink.cloud_platform")
public class MessagecenterApplication {
	public static void main(String[] args) {
		SpringApplication.run(MessagecenterApplication.class, args);
	}
}

package com.qianli.ilink.cloud_platform.messagecenterudp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.qianli.ilink.cloud_platform")
public class MessagecenterUdpApplication {
	public static void main(String[] args) {
		SpringApplication.run(MessagecenterUdpApplication.class, args);
	}
}

package com.qianli.ilink.cloud_platform.messagecenter.core.config;


import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Configuration;

@EnableDiscoveryClient
@Configuration
@RibbonClients
public class EurekaClientConfig {
}

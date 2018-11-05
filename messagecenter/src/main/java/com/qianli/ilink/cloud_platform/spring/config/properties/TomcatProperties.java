package com.qianli.ilink.cloud_platform.spring.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ConfigurationProperties(prefix = "spring.server")
@Component
public class TomcatProperties {

    Integer port = 8080;
    String contextPath;
    String acceptorThreadCount;
    String minSpareThreads;
    String maxSpareThreads;
    String maxThreads;
    String acceptCount;
    String maxConnections;
    String processorCache;
    String protocol;
    String compression;
    String compressionMinSize;
    String compressableMimeType;
    String connectionTimeout;
    boolean enableLookUp;

}

package com.qianli.ilink.cloud_platform.messagecenter.core.config.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "async.threadpool")
@Component
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AsyncThreadPoolProperties {
    private int corePoolSize;
    private int maxPoolSize;
    private int queueCapacity;
    private int keepAliveSeconds;
}

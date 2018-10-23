package com.qianli.ilink.cloud_platform.messagecenterudp.spring;

import com.qianli.ilink.cloud_platform.messagecenterudp.spring.properties.AsyncThreadPoolProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.Assert;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author kangjuaner
 */
@Configuration
@EnableAsync
@Slf4j
public class AsyncConfig  {

    @Autowired
    private AsyncThreadPoolProperties asyncThreadPoolProperties;

    @Bean
    public Executor messageExecutor() {
        Assert.notNull(asyncThreadPoolProperties,"asyncThreadPoolProperties is null...");
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(asyncThreadPoolProperties.getCorePoolSize());
        executor.setMaxPoolSize(asyncThreadPoolProperties.getMaxPoolSize());
        //队列最大长度 默认为Integer.MAX_VALUE 太大了阻塞容易瘫
        executor.setQueueCapacity(asyncThreadPoolProperties.getQueueCapacity());
        //线程维护时间 默认360
        executor.setKeepAliveSeconds(asyncThreadPoolProperties.getKeepAliveSeconds());
        executor.setThreadNamePrefix("messageExecutor");
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }

}

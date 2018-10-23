package com.qianli.ilink.cloud_platform.messagecenter.core.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.qianli.ilink.cloud_platform.messagecenter.core.config.properties.AsyncThreadPoolProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.Assert;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author kangjuaner
 */
@Configuration
@EnableScheduling
@EnableAsync
@Slf4j
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Autowired
    private AsyncThreadPoolProperties asyncThreadPoolProperties;


    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        //全局关闭fast_json循环引用检测 提升序列化性能
        JSON.DEFAULT_GENERATE_FEATURE |= SerializerFeature.DisableCircularReferenceDetect.getMask();
        //配置Spring MVC 通过fast_json来进行请求和相应的序列化和反序列化
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat, SerializerFeature.QuoteFieldNames);
        fastJsonConfig.setFeatures(Feature.AllowArbitraryCommas, Feature.AllowUnQuotedFieldNames, Feature.DisableCircularReferenceDetect);
        fastConverter.setFastJsonConfig(fastJsonConfig);
        List<MediaType> supportedMediaTypes = new ArrayList<>();
        supportedMediaTypes.add(MediaType.TEXT_HTML);
        supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        supportedMediaTypes.add(MediaType.APPLICATION_JSON);
        fastConverter.setSupportedMediaTypes(supportedMediaTypes);
        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(Charset.forName("utf-8"));
        ProtobufHttpMessageConverter protobufHttpMessageConverter = new ProtobufHttpMessageConverter();
        converters.add(stringHttpMessageConverter);
        converters.add(fastConverter);
        converters.add(protobufHttpMessageConverter);
    }




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

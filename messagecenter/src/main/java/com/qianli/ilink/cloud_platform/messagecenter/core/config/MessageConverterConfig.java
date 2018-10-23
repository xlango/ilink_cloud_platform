package com.qianli.ilink.cloud_platform.messagecenter.core.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * $Author:ZhouChao
 * $Description: 将springboot 默认json框架更改为fastjson,默认框架如嵌套集合会出现序列化异常
 * $Date:Create on 10:06 2018/5/14
 * $Modified By:
 *
 */
@Configuration
public class MessageConverterConfig {

    // TODO: 2018/8/18 放置在webMvcConfig 

//    /**
//     * 配置FastJson为Spring Boot默认JSON解析框架
//     * @return  HttpMessageConverters
//     */
//    @Bean
//    @SuppressWarnings("all")
//    public HttpMessageConverters fastJsonHttpMessageConverters() {
//
//        // 1.定义一个converters转换消息的对象
//        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
//        // 2.添加fastjson的配置信息，比如: 是否需要格式化返回的json数据
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
//        // 3.在converter中添加配置信息
//        fastConverter.setFastJsonConfig(fastJsonConfig);
//        // 4.将converter赋值给HttpMessageConverter
//        HttpMessageConverter<?> converter = fastConverter;
//
//        List<MediaType> supportedMediaTypes = new ArrayList<>();
//        supportedMediaTypes.add(MediaType.APPLICATION_JSON);
//        supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
//        supportedMediaTypes.add(MediaType.APPLICATION_ATOM_XML);
//        supportedMediaTypes.add(MediaType.APPLICATION_FORM_URLENCODED);
//        supportedMediaTypes.add(MediaType.APPLICATION_OCTET_STREAM);
//        supportedMediaTypes.add(MediaType.APPLICATION_PDF);
//        supportedMediaTypes.add(MediaType.APPLICATION_RSS_XML);
//        supportedMediaTypes.add(MediaType.APPLICATION_XHTML_XML);
//        supportedMediaTypes.add(MediaType.APPLICATION_XML);
//        supportedMediaTypes.add(MediaType.IMAGE_GIF);
//        supportedMediaTypes.add(MediaType.IMAGE_JPEG);
//        supportedMediaTypes.add(MediaType.IMAGE_PNG);
//        supportedMediaTypes.add(MediaType.TEXT_EVENT_STREAM);
//        supportedMediaTypes.add(MediaType.TEXT_HTML);
//        supportedMediaTypes.add(MediaType.TEXT_MARKDOWN);
//        supportedMediaTypes.add(MediaType.TEXT_PLAIN);
//        supportedMediaTypes.add(MediaType.TEXT_XML);
//        fastConverter.setSupportedMediaTypes(supportedMediaTypes);
//       
//        // 5.返回HttpMessageConverters对象
//        return new HttpMessageConverters(converter);
//    }
//
//    /**
//     * 添加protobufHttpMessageConverter
//     */
//    @Bean
//    public ProtobufHttpMessageConverter protobufHttpMessageConverter() {
//        return new ProtobufHttpMessageConverter();
//    }

}

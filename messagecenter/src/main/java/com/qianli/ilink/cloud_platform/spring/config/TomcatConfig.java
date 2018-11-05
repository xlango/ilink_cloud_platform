package com.qianli.ilink.cloud_platform.spring.config;

import com.qianli.ilink.cloud_platform.spring.config.properties.TomcatProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;


import java.nio.charset.Charset;

@Slf4j
@Configuration
public class TomcatConfig {

    @Autowired
    private TomcatProperties tomcatProperties;

    @Bean
    public ServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        if(!StringUtils.isEmpty(tomcatProperties.getContextPath())){
            tomcat.setContextPath(tomcatProperties.getContextPath());
        }
        tomcat.setPort(tomcatProperties.getPort());
        tomcat.setUriEncoding(Charset.forName("utf-8"));
        tomcat.addConnectorCustomizers(new KaraTomcatConnectorCustomizer());
        return tomcat;
    }



    public class KaraTomcatConnectorCustomizer implements TomcatConnectorCustomizer {

        public KaraTomcatConnectorCustomizer() {
        }

        @Override
        public void customize(Connector connector) {
            if(!StringUtils.isEmpty(tomcatProperties.getConnectionTimeout())){
                connector.setAttribute("connectionTimeout", tomcatProperties.getConnectionTimeout());
            }
            /**
             * 与cpu核数一致
             */
            connector.setAttribute("acceptorThreadCount", tomcatProperties.getAcceptorThreadCount());

            /**
             * 最小备用线程数，tomcat启动时的初始化的线程数。
             */
            connector.setAttribute("minSpareThreads", tomcatProperties.getMinSpareThreads());

            /**
             * 如果空闲状态的线程数多于设置的数目，则将这些线程中止，减少这个池中的线程总数。
             */
            connector.setAttribute("maxSpareThreads", tomcatProperties.getMaxSpareThreads());
            /**
             * 最大并发數 太大也没用 cpu全去忙活线程切换了。800
             */
            connector.setAttribute("maxThreads", tomcatProperties.getMaxThreads());
            /**
             * 需要慎重对待，如果请求量不是很大，通常tomcat默认的100也ok，但若访问量较大的情况，建议这个值设置的大一些，比如1024或更大。1024
             */
            connector.setAttribute("acceptCount",tomcatProperties.getAcceptCount());
            /**
             * 最大连接数,默认值10000
             */
            connector.setAttribute("maxConnections", tomcatProperties.getMaxConnections());
            /**
             * 使用nio
             */
            connector.setAttribute("protocol", tomcatProperties.getProtocol());
            /**
             * processorCache属性默认值是200，如果不做限制的话可以设置为-1，这样cache的上限将是最大连接数maxConnections的大小。
             * 绝大部分应用没有特别高的访问量，通常并不需要调整processorCache参数，但对于网关或代理一类的应用（尤其是使用servlet3的情况）这个地方可以设置的大一些，比如调到1000或者-1。
             */
            connector.setAttribute("processorCache", tomcatProperties.getProcessorCache());
            /**
             *打开压缩功能
             */
            if(!StringUtils.isEmpty(tomcatProperties.getCompression())){
                connector.setAttribute("compression", tomcatProperties.getCompression());
            }
            /**
             *  启用压缩的输出内容大小，这里面默认为2KB 2048
             */
            if(!StringUtils.isEmpty(tomcatProperties.getCompressionMinSize())){
                connector.setAttribute("compressionMinSize", tomcatProperties.getCompressionMinSize());
            }

            /**
             * 压缩类型: text/html,text/xml,text/javascript,text/css,text/plain
             */
            if(!StringUtils.isEmpty(tomcatProperties.getCompressableMimeType())){
                connector.setAttribute("compressableMimeType", tomcatProperties.getCompressableMimeType());
            }

            /**
             * 这个功效和Apache中的HostnameLookups一样，设为关闭。
             */
            connector.setEnableLookups(tomcatProperties.isEnableLookUp());
        }
    }

}

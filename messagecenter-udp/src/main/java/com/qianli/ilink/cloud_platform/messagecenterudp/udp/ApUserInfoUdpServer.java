package com.qianli.ilink.cloud_platform.messagecenterudp.udp;


import com.qianli.ilink.cloud_platform.messagecenterudp.spring.properties.UdpPortProperties;
import com.qianli.ilink.cloud_platform.messagecenterudp.udp.handler.ApUserInfoMessageHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author kangjuaner
 */
@Slf4j
@Component
public class ApUserInfoUdpServer {

    @Autowired
    private UdpPortProperties udpPortConfig;

    @Autowired
    private ApUserInfoMessageHandler apUserInfoMessageHandler;

    private ChannelFuture channelFuture;

    private EventLoopGroup group = new NioEventLoopGroup();


    @PostConstruct
    public void initServer() {
        log.info("init apUserInfoConfig udp server at port:{}",udpPortConfig.getApUserInfoServerPort());
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioDatagramChannel.class)
                    .option(ChannelOption.SO_BROADCAST, true)
//                    .option(ChannelOption.RCVBUF_ALLOCATOR, new FixedRecvByteBufAllocator(65535))
                    .handler(apUserInfoMessageHandler);
            channelFuture = bootstrap.bind(udpPortConfig.getApUserInfoServerPort()).sync();
            log.info("init apUserInfoConfig udp server success");
        } catch (InterruptedException e) {
            log.error("ApUserInfoUdpServer InterruptedException,",e);
        } finally {
            Runtime.getRuntime().addShutdownHook(new Thread(this::shutdown));
        }
    }

    @PreDestroy
    public void shutdown() {
        if (channelFuture != null && channelFuture.channel().isOpen()) {
            channelFuture.channel().close().syncUninterruptibly();
        }
        if (group != null) {
            group.shutdownGracefully();
        }
        log.info("ApUserInfoUdpServer udp server stop");
    }

}

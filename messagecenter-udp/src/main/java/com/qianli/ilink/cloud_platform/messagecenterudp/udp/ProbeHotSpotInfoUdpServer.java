package com.qianli.ilink.cloud_platform.messagecenterudp.udp;

import com.qianli.ilink.cloud_platform.messagecenter.spring.properties.UdpPortProperties;
import com.qianli.ilink.cloud_platform.messagecenterudp.udp.handler.ProbeHotSpotInfoHandler;
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

@Slf4j
@Component
public class ProbeHotSpotInfoUdpServer {

    @Autowired
    private UdpPortProperties udpPortConfig;

    @Autowired
    private ProbeHotSpotInfoHandler probeHotSpotInfoHandler;

    private ChannelFuture channelFuture;

    private EventLoopGroup group = new NioEventLoopGroup();


    @PostConstruct
    public void initServer() {
        log.info("init probeConfig udp server at port:{}",udpPortConfig.getProbeHotspotInfo());
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioDatagramChannel.class)
                    .option(ChannelOption.SO_BROADCAST, true)
//                    .option(ChannelOption.RCVBUF_ALLOCATOR, new FixedRecvByteBufAllocator(65535))
                    .handler(probeHotSpotInfoHandler);
            channelFuture = bootstrap.bind(udpPortConfig.getProbeHotspotInfo()).sync();
            log.info("init probeConfig udp server success");
        } catch (InterruptedException e) {
            log.error("ProbeHotspotInfoUdpServer InterruptedException,",e);
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
        log.info("ProbeHotspotInfoUdpServer udp server stop");
    }

}

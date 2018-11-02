package com.qianli.ilink.cloud_platform.messagecenterudp.udp.handler;

import com.qianli.ilink.cloud_platform.messagecenterudp.enums.MessageType;
import com.qianli.ilink.cloud_platform.messagecenterudp.service.MessageSender;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@ChannelHandler.Sharable
@Component
public class TestHandler extends SimpleChannelInboundHandler<DatagramPacket> {

    @Autowired
    private MessageSender messageSender;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket msg){
        log.debug("抛出消息进入");
        ByteBuf content = msg.copy().content();
        if(content == null){
            return;
        }
        System.out.println("该监听端口数据被抛出================");
       // messageSender.send(MessageType.PROBE_MESSAGE.getValue(),content);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}

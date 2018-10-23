package com.qianli.ilink.cloud_platform.messagecenterudp.service;


import io.netty.buffer.ByteBuf;

public interface MessageSender {

    void send(String messageType, ByteBuf content);
}

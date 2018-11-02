package com.qianli.ilink.cloud_platform.messagecenterudp.service.impl;

import com.alibaba.fastjson.JSON;
import com.google.protobuf.InvalidProtocolBufferException;
import com.googlecode.protobuf.format.JsonFormat;
import com.qianli.ilink.cloud_platform.messagecenterudp.enums.MessageType;
import com.qianli.ilink.cloud_platform.messagecenterudp.mq.kafka.KafkaMessageSender;
import com.qianli.ilink.cloud_platform.messagecenterudp.pojo.dto.ProbeMessageProto;
import com.qianli.ilink.cloud_platform.messagecenter.spring.properties.KafkaProducerProperties;
import com.qianli.ilink.cloud_platform.messagecenterudp.pojo.dto.ApUserInfoProto;
import com.qianli.ilink.cloud_platform.messagecenterudp.pojo.dto.Message;
import com.qianli.ilink.cloud_platform.messagecenterudp.pojo.dto.UserInternetLogProto;
import com.qianli.ilink.cloud_platform.messagecenterudp.service.MessageSender;
import com.qianli.ilink.cloud_platform.messagecenterudp.utils.IdGenerater;
import io.netty.buffer.ByteBuf;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessageSenderImpl implements MessageSender {

    @Autowired
    private KafkaMessageSender kafkaMessageSender;

    @Autowired
    private KafkaProducerProperties kafkaConfig;

    @Async(value = "messageExecutor")
    @Override
    public void send(String messageType, ByteBuf content) {
        Message message = null;
        byte[] req = new byte[ content.readableBytes()];
        content.readBytes(req);
        try {
            if(MessageType.AP_USER_INFO.getValue().equals(messageType)){
                ApUserInfoProto.APUserInfo apUserInfo = ApUserInfoProto.APUserInfo.parseFrom(req);
                message = Message.builder().type(MessageType.AP_USER_INFO.getValue()).body(new JsonFormat().printToString(apUserInfo)).build();
            }else if(MessageType.USER_INTERNET_LOG.getValue().equals(messageType)){
                UserInternetLogProto.TotalUserInternetLog totalUserInternetLog = UserInternetLogProto.TotalUserInternetLog.parseFrom(req);
                message = Message.builder().type(MessageType.USER_INTERNET_LOG.getValue()).body(new JsonFormat().printToString(totalUserInternetLog)).build();
            }else if(MessageType.PROBE_HOTSPOT_INFO.getValue().equals(messageType)){
                ProbeMessageProto.ProbeHotspotInfo probeHotspotInfo= ProbeMessageProto.ProbeHotspotInfo.parseFrom(req);
                message = Message.builder().type(MessageType.PROBE_HOTSPOT_INFO.getValue()).body(new JsonFormat().printToString(probeHotspotInfo)).build();
            }else if(MessageType.PROBE_AP_LOCATION_INFO.getValue().equals(messageType)){
                ProbeMessageProto.ProbeAPLocationInfo probeAPLocationInfo=ProbeMessageProto.ProbeAPLocationInfo.parseFrom(req);
                message = Message.builder().type(MessageType.PROBE_AP_LOCATION_INFO.getValue()).body(new JsonFormat().printToString(probeAPLocationInfo)).build();
            }else if(MessageType.PROBE_MESSAGE.getValue().equals(messageType)){
                ProbeMessageProto.Probe_Message probeMessage=ProbeMessageProto.Probe_Message.parseFrom(req);
                message = Message.builder().type(MessageType.PROBE_MESSAGE.getValue()).body(new JsonFormat().printToString(probeMessage)).build();
            }
        } catch (InvalidProtocolBufferException e) {
            log.error("gpb parse error...",e);
            return;
        }
        if(message == null){
            return;
        }
        log.debug("报文：{}",message);
        System.out.println(JSON.toJSONString(message));
        kafkaMessageSender.execute(kafkaConfig.getMessageTopic(),IdGenerater.kafkaKey(), JSON.toJSONString(message));
    }


}

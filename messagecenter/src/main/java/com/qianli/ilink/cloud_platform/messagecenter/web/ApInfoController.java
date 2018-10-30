package com.qianli.ilink.cloud_platform.messagecenter.web;

import com.alibaba.fastjson.JSONObject;
import com.googlecode.protobuf.format.JsonFormat;
import com.qianli.ilink.cloud_platform.messagecenter.enums.MessageEnum;
import com.qianli.ilink.cloud_platform.messagecenter.pojo.BaseInfo;
import com.qianli.ilink.cloud_platform.messagecenter.pojo.dto.*;
import com.qianli.ilink.cloud_platform.messagecenter.service.MessageSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ApInfoController {

    @Autowired
    private MessageSender messageSender;

    @RequestMapping(value = "/apbaseinfo", method = RequestMethod.POST,consumes = "application/x-protobuf")
    public void apBaseInfoReceive(@RequestBody ApBaseInfoProto.ApBaseInfo apBaseInfo) {
        if(apBaseInfo == null){
            log.info("api apbaseinfo request protobuf body is null...");
            return;
        }

        messageSender.send(Message.builder().type(MessageEnum.AP_BASE_INFO.getMsg()).body(new JsonFormat().printToString(apBaseInfo)).build());
    }

    @RequestMapping(value = "/apstatusinfo", method = RequestMethod.POST,consumes = "application/x-protobuf")
    public void apStatusInfoReceive(@RequestBody ApStatusInfoProto.ApStatusInfo apStatusInfo) {
        if(apStatusInfo == null){
            log.info("api apstatusinfo request protobuf body is null...");
            return;
        }
        messageSender.send(Message.builder().type(MessageEnum.AP_STATUS_INFO.getMsg()).body(new JsonFormat().printToString(apStatusInfo)).build());
    }

    @RequestMapping(value = "/aponlinestainfo", method = RequestMethod.POST,consumes = "application/x-protobuf")
    public void apOnlineStaInfoReceive(@RequestBody ApOnlineStaInfoProto.TotalApOnlineStaInfo totalApOnlineStaInfo) {
        if(totalApOnlineStaInfo == null){
            log.info("api aponlinestainfo request protobuf body is null...");
            return;
        }
        messageSender.send(Message.builder().type(MessageEnum.AP_ONLINE_STA_INFO.getMsg()).body(new JsonFormat().printToString(totalApOnlineStaInfo)).build());
    }

    @RequestMapping(value = "/apofflinestainfo", method = RequestMethod.POST,consumes = "application/x-protobuf")
    public void apOfflineStaInfoReceive(@RequestBody ApOfflineStaInfoProto.TotalApOfflineStaInfo totalApOfflineStaInfo) {
        if(totalApOfflineStaInfo == null){
            log.info("api apofflinestainfo request protobuf body is null...");
            return;
        }
        messageSender.send(Message.builder().type(MessageEnum.AP_OFFLINE_STA_INFO.getMsg()).body(new JsonFormat().printToString(totalApOfflineStaInfo)).build());
    }


    @RequestMapping(value = "/baseinfo", method = RequestMethod.POST,consumes = "application/json")
    public String baseInfoReceive(@RequestBody BaseInfo baseInfo) {
        if(baseInfo == null){
            log.info("api apofflinestainfo request json body is null...");
            return "";
        }

        System.out.println(JSONObject.toJSONString(baseInfo));
        messageSender.send(Message.builder().type(MessageEnum.BASE_INFO.getMsg()).body(JSONObject.toJSONString(baseInfo)).build());
        return "{\"errcode\": \"0\",\"data\": {\"opcode\": \"0\",\"cloudServerIp\": \"192.168.10.252\",\"cloudServerPort\": \"20010\",\"cloudMgmtAddr\": \"http://192.168.10.252:80\",\"gatewayIp\": \"\",\"gatewayPort\": \"\",\"imageUpGrade\": {\"proto\": \"ftp\",\"serverip\": \"xx.xx.xx.xx\",\"usrname\": \"xx\",\"password\": \"xx\",\"path\": “ xx”,“file”: “xx”,“url”: \"http://xxxxx//xxx/url/apimage/ilinkos-2.0.0.1\",“version”: “xxxxxxxxxx”}}}";
    }

}

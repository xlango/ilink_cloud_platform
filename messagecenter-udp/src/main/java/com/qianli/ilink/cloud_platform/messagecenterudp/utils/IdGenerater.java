package com.qianli.ilink.cloud_platform.messagecenterudp.utils;

import java.util.UUID;

public class IdGenerater {

    //32位id
    public static String kafkaKey(){
        return System.currentTimeMillis()+ UUID.randomUUID().toString().substring(0,18);
    }

}

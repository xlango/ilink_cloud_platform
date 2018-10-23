package com.qianli.ilink.cloud_platform.messagecenter.enums;

import com.qianli.ilink.cloud_platform.commons.core.enums.BaseEnum;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum MessageEnum implements BaseEnum{

    AP_BASE_INFO(0,"AP_BASE_INFO","apbaseinfo"),
    AP_STATUS_INFO(1,"AP_STATUS_INFO","apstatusinfo"),
    AP_ONLINE_STA_INFO(2,"AP_ONLINE_STA_INFO","aponlinestainfo"),
    AP_OFFLINE_STA_INFO(3,"AP_OFFLINE_STA_INFO","apofflinestainfo"),;

    private int code;
    private String msg;
    private String details;

    MessageEnum(int code, String msg, String details) {
        this.code = code;
        this.msg = msg;
        this.details = details;
    }
}

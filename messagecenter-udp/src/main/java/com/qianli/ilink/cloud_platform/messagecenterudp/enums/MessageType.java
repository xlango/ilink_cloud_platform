package com.qianli.ilink.cloud_platform.messagecenterudp.enums;

public enum MessageType implements Behaviour{

    AP_BASE_INFO("AP_BASE_INFO","apbaseinfo"),
    AP_STATUS_INFO("AP_STATUS_INFO","apstatusinfo"),
    AP_ONLINE_STA_INFO("AP_ONLINE_STA_INFO","aponlinestainfo"),
    AP_OFFLINE_STA_INFO("AP_OFFLINE_STA_INFO","apofflinestainfo"),
    USER_INTERNET_LOG("USER_INTERNET_LOG","userinternetlog"),
    AP_USER_INFO("AP_USER_INFO","apuserinfo"),;

    private String value;
    private String desc;

    private MessageType(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return this.value + " is " + this.desc;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public String getDesc() {
        return this.desc;
    }
}

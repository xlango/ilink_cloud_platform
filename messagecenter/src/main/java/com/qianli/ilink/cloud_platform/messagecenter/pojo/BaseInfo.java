package com.qianli.ilink.cloud_platform.messagecenter.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseInfo {

    String MAC;
    String accessToken;
    String configVersion;
    String SN;
    String model;
    String hwVersion;
    String masterImageVersion;
    String backupImageVersion;
    String masterUbootVersion;
    String backupUbootVersion;
    String n2nStatus;
    String upTime;
    String gwStatus;
    String rebootCause;
    String childDeviceNum;
    String internetIp;
}

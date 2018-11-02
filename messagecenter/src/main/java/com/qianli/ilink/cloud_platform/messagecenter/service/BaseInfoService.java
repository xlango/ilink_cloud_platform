package com.qianli.ilink.cloud_platform.messagecenter.service;

import com.qianli.ilink.cloud_platform.messagecenter.pojo.BaseInfo;

public interface BaseInfoService {

    void insert(BaseInfo baseInfo);

    void updateByMac(BaseInfo baseInfo);

    void insertOrUpdate(BaseInfo baseInfo);
}

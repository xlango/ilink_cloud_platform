package com.qianli.ilink.cloud_platform.messagecenter.service.impl;

import com.qianli.ilink.cloud_platform.messagecenter.mapper.BaseInfoMapper;
import com.qianli.ilink.cloud_platform.messagecenter.pojo.BaseInfo;
import com.qianli.ilink.cloud_platform.messagecenter.service.BaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BaseInfoServiceImpl implements BaseInfoService {

    @Autowired
    private BaseInfoMapper baseInfoMapper;

    @Override
    public void insert(BaseInfo baseInfo) {
        baseInfoMapper.insert(baseInfo);
    }

    @Override
    public void updateByMac(BaseInfo baseInfo) {
        baseInfoMapper.updateByMac(baseInfo);
    }

    @Override
    public void insertOrUpdate(BaseInfo baseInfo) {
        baseInfoMapper.insertOrUpdate(baseInfo);
    }
}

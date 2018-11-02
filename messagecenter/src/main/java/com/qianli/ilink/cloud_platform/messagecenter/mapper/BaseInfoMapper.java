package com.qianli.ilink.cloud_platform.messagecenter.mapper;

import com.qianli.ilink.cloud_platform.messagecenter.pojo.BaseInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;


@Mapper
@Component
public interface BaseInfoMapper {

    void insert(BaseInfo baseInfo);

    void updateByMac(BaseInfo baseInfo);

    void insertOrUpdate(BaseInfo baseInfo);
}

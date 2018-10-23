package com.qianli.ilink.cloud_platform.commons.core.enums;


/**
 * 枚举顶层接口,所有自定义枚举类型需实现该接口
 */
public interface BaseEnum{

    int getCode();

    String getMsg();

    String getDetails();

}

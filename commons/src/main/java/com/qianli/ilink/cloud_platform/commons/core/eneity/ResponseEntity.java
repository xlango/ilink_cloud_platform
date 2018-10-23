package com.qianli.ilink.cloud_platform.commons.core.eneity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 实用工具类
 * @see {@link com.qianli.ilink.cloud_platform.commons.core.utils.ResponseEntityUtils}
 * 生成对应实体
 */
@Data
@Accessors(chain = true)
public class ResponseEntity implements BaseEntity{

    private static final long serialVersionUID = 6207164949397687726L;

    private Object data;

    private Integer code;

    private String msg;

    private String details;

    private ResponseEntity(){}

    public static ResponseEntity empty(){
        return new ResponseEntity();
    }

}

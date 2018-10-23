package com.qianli.ilink.cloud_platform.commons.core.utils;

import com.qianli.ilink.cloud_platform.commons.core.eneity.ResponseEntity;
import com.qianli.ilink.cloud_platform.commons.core.enums.ResultEnum;

public class ResponseEntityUtils {

    public static ResponseEntity buildSuccess(Object data) {
        return build(ResultEnum.SUCCESS,data);
    }

    public static ResponseEntity buildSuccess() {
        return build(ResultEnum.SUCCESS);
    }

    public static ResponseEntity build(ResultEnum resultEnum,Object data) {
        return empty().setCode(resultEnum.getCode()).setMsg(resultEnum.getMsg())
                .setDetails(resultEnum.getDetails()).setData(data);
    }

    public static ResponseEntity build(ResultEnum resultEnum) {
        return build(resultEnum,null);
    }

    public static ResponseEntity empty() {

        return ResponseEntity.empty();
    }

}

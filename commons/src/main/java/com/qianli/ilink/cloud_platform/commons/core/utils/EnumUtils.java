package com.qianli.ilink.cloud_platform.commons.core.utils;

import com.qianli.ilink.cloud_platform.commons.core.enums.BaseEnum;


public class EnumUtils {

    public static <E extends BaseEnum> BaseEnum codeToEnum(int code, E... enums) {
        E e = null;
        for (E e1 : enums) {
            Object eCode = e1.getCode();
            if (eCode.equals(code)) {
                e = e1;
                break;
            }
        }
        return e;
    }
}

package com.qianli.ilink.cloud_platform.commons.core.enums;

public enum ResultEnum implements BaseEnum{

    SUCCESS(0, "ok", "成功"),
    SYSTEM_ERROR(-1, "system_error", "系统内部错误"),
    AUTHORITY_AUTHENTICATION_ERROR(-2, "authority_authentication_error", "用户权限不足或权限错误"),
    NO_LOGIN_ERROR(-3, "no_login_error", "用户未登录"),
    ILLEGAL_ARGUMENT_ERROR(-4,"illegal_argument_error","非法参数错误"),


    UNKNOWN_ERROR(-999, "unknown_error", "未知错误");

    private int code;
    private String msg;
    private String details;

    ResultEnum(int code, String msg, String details) {
        this.code = code;
        this.msg = msg;
        this.details = details;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public String getDetails(){
        return details;
    }

}

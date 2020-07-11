package com.bgamq.springboot.util;

public enum  ResultCode {
    SUCCESS(200, "Success!"),

    FAIL(400, "Failure!"),

    NO_PERMISSION(403, "Need Authorities!"),//没有权限
    LOGIN_NO(402, "Need Login!"),//未登录
    LOGIN_FAIL(401, "Login Failure!"),//登录失败
    LOGIN_SUCCESS(200, "Login Success!"),//登录成功
    LOGOUT_SUCCESS(200, "Logout Success!"),//退出登录
    SESSION_EXPIRES(101, "Session Expires!"),//会话到期
    SESSION_EXPIRES_OTHER_LOGIN(101, "Session Expires!Other users login！"),
    ;//会话到期,其他用户登录

    private int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}

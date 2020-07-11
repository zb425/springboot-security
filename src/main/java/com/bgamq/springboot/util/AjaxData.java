package com.bgamq.springboot.util;



import java.io.Serializable;


public class AjaxData implements Serializable {


    private  int code;
    private  String msg;
    private  Object data;

    public AjaxData() {

    }

    public AjaxData(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public AjaxData(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static  AjaxData success(){
        return new AjaxData(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMsg(),null);
    }

    public static  AjaxData success(Object data){
        return new AjaxData(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMsg(),data);
    }

    public static AjaxData fail(){
        return new AjaxData(ResultCode.FAIL.getCode(),ResultCode.FAIL.getMsg(),null);
    }

    public static  AjaxData NO_PERMISSION(){
        return  new AjaxData(ResultCode.NO_PERMISSION.getCode(),ResultCode.NO_PERMISSION.getMsg(),null);
    }

    public static  AjaxData LOGIN_NO(){
        return  new AjaxData(ResultCode.LOGIN_NO.getCode(),ResultCode.LOGIN_NO.getMsg(),null);

    }

    public static  AjaxData LOGIN_FAIL(){
        return  new AjaxData(ResultCode.LOGIN_FAIL.getCode(),ResultCode.LOGIN_FAIL.getMsg(),null);
    }

    public static AjaxData LOGIN_SUCCESS(){
        return  new AjaxData(ResultCode.LOGIN_SUCCESS.getCode(),ResultCode.LOGIN_SUCCESS.getMsg(),null);
    }

    public static  AjaxData LOGOUT_SUCCESS(){
        return  new AjaxData(ResultCode.LOGOUT_SUCCESS.getCode(),ResultCode.LOGOUT_SUCCESS.getMsg(),null);
    }

    public static  AjaxData SESSION_EXPIRES(){
        return new AjaxData(ResultCode.SESSION_EXPIRES.getCode(),ResultCode.SESSION_EXPIRES.getMsg(),null);
    }

    public static  AjaxData SESSION_EXPIRES_OTHER_LOGIN(){
        return  new AjaxData(ResultCode.SESSION_EXPIRES_OTHER_LOGIN.getCode(),ResultCode.SESSION_EXPIRES_OTHER_LOGIN.getMsg(),null);

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "AjaxData{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}

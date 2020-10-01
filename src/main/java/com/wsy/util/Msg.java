package com.wsy.util;

/**
 * @author: wsy
 * Date: 2020/9/29
 * Time: 20:36
 * Description: No Description
 */
public class Msg {
    private Boolean status;

    private String info;

    private Object data;

    public Msg(Boolean status, String info, Object data) {
        this.status = status;
        this.info = info;
        this.data = data;
    }

    public static Msg ok() {
        return ok(null, null);
    }

    public static Msg ok(String info) {
        return ok(info, null);
    }

    public static Msg ok(String info, Object data) {
        return new Msg(true, info, data);
    }

    public static Msg error(String info) {
        return error(info, null);
    }

    public static Msg error(String info, Object data) {
        return new Msg(false, info, data);
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

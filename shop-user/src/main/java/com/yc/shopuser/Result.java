package com.yc.shopuser;

import java.io.Serializable;

/**
 * @program: shop-index
 * @description:
 * @author: 作者
 * @create: 2021-05-09 09:26
 */
public class Result implements Serializable {


    private static final long serialVersionUID = -4471523227528608825L;

    private int code;
    private String msg;
    private Object obj;

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public Result(int code, String msg, Object obj) {
        this.code = code;
        this.msg = msg;
        this.obj = obj;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getObj() {
        return obj;
    }
}

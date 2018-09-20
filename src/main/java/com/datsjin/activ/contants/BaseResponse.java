package com.datsjin.activ.contants;

import java.io.Serializable;

public class BaseResponse<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    public String code;
    public String msg;
    public T data;

    public BaseResponse() {
    }

    public BaseResponse(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public BaseResponse(ResponseEnum responseEnum, T data) {
        this.code = responseEnum.getCode();
        this.msg = responseEnum.getMsg();
        this.data = data;
    }

    public BaseResponse(T data) {
        this.code = ResponseEnum.SUCCESS.getCode();
        this.msg = ResponseEnum.SUCCESS.getMsg();
        this.data = data;
    }
}

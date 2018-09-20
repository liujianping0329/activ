package com.datsjin.activ.exception;

import com.datsjin.activ.contants.ResponseEnum;

public class DatsjinException extends Exception {

    private static final long serialVersionUID = -5997015471659213563L;
    private String code;
    private String msg;
    private ResponseEnum response;

    public DatsjinException(ResponseEnum response) {
        super(response.getMsg());
        this.code = response.getCode();
        this.msg = response.getMsg();
        this.response = response;
    }

    public DatsjinException(ResponseEnum response, Throwable e) {
        super(e);
        this.code = response.getCode();
        this.msg = response.getMsg();
        this.response = response;
    }

    public DatsjinException(ResponseEnum response, String extData) {
        super(response.getMsg());
        this.code = response.getCode();
        this.msg = response.getMsg() + "," + extData;
        this.response = response;
    }

    public DatsjinException(String errMsg) {
        this.code = ResponseEnum.ERROR.getCode();
        this.msg = errMsg;
        this.response = null;
    }

    public ResponseEnum getResponse() {
        return this.response;
    }

    public void setResponse(ResponseEnum response) {
        this.response = response;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}

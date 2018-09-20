package com.datsjin.activ.exception;

import com.datsjin.activ.contants.BaseResponse;
import com.datsjin.activ.contants.ResponseEnum;
import com.datsjin.activ.exception.DatsjinException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
public class WebExceptionHandler {

    private static final Log logger = LogFactory.getLog(WebExceptionHandler.class);

    @ExceptionHandler(DatsjinException.class)
    @ResponseBody
    //    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public BaseResponse handleIfwException(HttpServletResponse response, DatsjinException e) {
        ResponseEnum r = e.getResponse();
        HttpStatus s = null;
        if (r != null) {
            s = r.getStatus();
        }
        if (s != null) {
            response.setStatus(s.value());
        } else {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
        }
        response.setStatus(HttpStatus.OK.value()); // 前端要求所有请求返回200，返回状态取json数据
        return new BaseResponse(e.getCode(), e.getMsg(), null);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BaseResponse handleException(Exception e) {
        Map<String, String> map = new HashMap<>();
        map.put("class", e.getClass().getName());
        map.put("message", e.getMessage());
        logger.error(e.getMessage(), e);
        return new BaseResponse(ResponseEnum.ERROR.getCode(), e.getMessage(), map);
    }
}

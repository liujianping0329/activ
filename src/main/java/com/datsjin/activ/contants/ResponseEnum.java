package com.datsjin.activ.contants;

import org.springframework.http.HttpStatus;

public enum ResponseEnum {
    SUCCESS("10000", HttpStatus.OK, "成功"),
    ERROR("99999", HttpStatus.BAD_REQUEST, "错误"),
    AUTH_ERROR("20000", HttpStatus.UNAUTHORIZED, "权限错误"),
    AUTH_ACCOUNT_INVALID("20100", HttpStatus.UNAUTHORIZED, "账号不存在"),
    AUTH_PASSWORD_INVALID("20200", HttpStatus.UNAUTHORIZED, "密码错误"),
    AUTH_TOKEN_INVALID("20300", HttpStatus.UNAUTHORIZED, "token无效"),
    AUTH_PERMISSION_DENY("20400", HttpStatus.UNAUTHORIZED, "没有权限"),
    AUTH_PERMISSION_LACK("20500", HttpStatus.UNAUTHORIZED, "权限不足"),
    AUTH_OBJECT_UNACCESSABLE("20600", HttpStatus.UNAUTHORIZED, "对象无法访问"),
    AUTH_ACCOUNT_EXISTS("20700", HttpStatus.UNAUTHORIZED, "手机号已经被注册了"),
    AUTH_DATA_ILLEGAL("20800", HttpStatus.UNAUTHORIZED, "用户数据非法"),
    AUTH_SESSION_TIMEOUT("20900", HttpStatus.UNAUTHORIZED, "会话超时了，请重新登录"),
    AUTH_SESSION_INVALID("21000", HttpStatus.UNAUTHORIZED, "会话无效，请重新登录"),
    AUTH_OLD_PASSWORD_INVALID("21100", HttpStatus.UNAUTHORIZED, "原始密码错误"),
    AUTH_LOGINNAME_EXISTS("21200", HttpStatus.UNAUTHORIZED, "用户名已经被注册"),
    AUTH_EMAIL_EXISTS("21300", HttpStatus.UNAUTHORIZED, "邮箱已经被注册"),
    AUTH_WEIXIN_EXISTS("21400", HttpStatus.UNAUTHORIZED, "该微信已绑定其他账号"),
    AUTH_QQ_EXISTS("21500", HttpStatus.UNAUTHORIZED, "该QQ已绑定其他账号"),
    AUTH_WEIBO_EXISTS("21600", HttpStatus.UNAUTHORIZED, "该微博已绑定其他账号"),
    CODE_WEIXIN_EXISTS("21700", HttpStatus.UNAUTHORIZED, "该微信码已失效，请重新扫描"),
    USER_ACCOUNT_FREEZE("21800", HttpStatus.UNAUTHORIZED, "账号已被冻结,请不要重复操作"),
    USER_ACCOUNT_THAW("21900", HttpStatus.UNAUTHORIZED, "账号已解冻,请不要重复操作"),
    UPDATE_USERCERT_ERROR("22000", HttpStatus.UNAUTHORIZED, "用户未认证，无法操作"),
    REQUEST_ERROR("30000", HttpStatus.BAD_REQUEST, "请求错误"),
    REQUEST_PARAM_INVALID("30100", HttpStatus.BAD_REQUEST, "请求参数不合法"),
    REQUEST_PARAM_NULL("30200", HttpStatus.BAD_REQUEST, "参数不能为空值"),
    REQUEST_URL_INVALID("30300", HttpStatus.BAD_REQUEST, "匹配不到合适的URL，可能是GET/POST请求方式或者URL路径不正确"),
    REQUEST_DUPLICATE("30400", HttpStatus.BAD_REQUEST, "表单提交错误！可能是由于您连续提交了同一表单（例如，双击了提交按钮）或访问了过期表单页面。"),
    REQUEST_SIGN_INVALID("30500", HttpStatus.BAD_REQUEST, "验签出错"),
    REQUEST_ACCOUNT_INVALID("30600", HttpStatus.BAD_REQUEST, "未指派人"),
    DATA_ERROR("40000", HttpStatus.BAD_REQUEST, "数据错误"),
    DATA_ARITHMETIC_EXCEPTION("40100", HttpStatus.BAD_REQUEST, "数学运算异常！"),
    DATA_SQL_EXCEPTION("40200", HttpStatus.BAD_REQUEST, "操作数据库异常！"),
    DATA_SECURITY_EXCEPTION("40300", HttpStatus.BAD_REQUEST, "违背安全原则异常！"),
    DATA_NO_SUCH_ELEMENT("40400", HttpStatus.BAD_REQUEST, "找不到对象"),
    DATA_ELEMENT_ALREADY_EXISTS("40500", HttpStatus.BAD_REQUEST, "对象已经存在了"),
    SYSTEM_ERROR("50000", HttpStatus.BAD_REQUEST, "系统错误"),
    SYSTEM_TODO_FUNCTION_EXCEPTION("50100", HttpStatus.BAD_REQUEST, "不可使用未完成的功能方法"),
    SYSTEM_IO_EXCEPTION("50200", HttpStatus.BAD_REQUEST, "IO异常！"),
    SYSTEM_JVM_INTERNAL_ERROR("50300", HttpStatus.BAD_REQUEST, "Java虚拟机发生了内部错误"),
    SYSTEM_CONNECT_TIMEOUT("50400", HttpStatus.BAD_REQUEST, "连接到数据库异常"),
    SYSTEM_METHOD_NOT_FOUND("50500", HttpStatus.BAD_REQUEST, "方法末找到异常！"),
    SYSTEM_CLASS_CAST_EXCEPTION("50600", HttpStatus.BAD_REQUEST, "类型强制转换错误！"),
    SYSTEM_ILLEGAL_ARGUMENT_EXCEPTION("50700", HttpStatus.BAD_REQUEST, "方法的参数错误！"),
    SYSTEM_ARRAY_INDEX_OUTOFBOUND("50800", HttpStatus.BAD_REQUEST, "数组下标越界!"),
    SYSTEM_NULL_POINT_EXCEPTION("50900", HttpStatus.BAD_REQUEST, "发生了空指针异常"),
    SYSTEM_CLASS_NOT_FOUND("51000", HttpStatus.BAD_REQUEST, "程序某个类找不到"),
    SYSTEM_BUSINESS_ERROR("51200", HttpStatus.BAD_REQUEST, "业务逻辑异常"),
    PHONE_MESSAGE_INVALID("60000", HttpStatus.BAD_REQUEST, "短信验证码已失效!"),
    PHONE_MESSAGE_ERROR("60100", HttpStatus.BAD_REQUEST, "短信验证码错误!"),
    EMAIL_MESSAGE_INVALID("60200", HttpStatus.BAD_REQUEST, "邮箱验证码已失效!"),
    EMAIL_MESSAGE_ERROR("60300", HttpStatus.BAD_REQUEST, "邮箱验证码错误!"),
    EMAIL_FORMAT_ERROR("60300", HttpStatus.BAD_REQUEST, "邮箱格式错误!"),
    SMS_SEND_ERROR("60400", HttpStatus.UNAUTHORIZED, "短信发送失败"),
    EMAIL_SEND_ERROR("60500", HttpStatus.UNAUTHORIZED, "邮件发送失败"),
    IMG_NULL_EXCEPTION("70000", HttpStatus.BAD_REQUEST, "图片不能为空"),
    IMG_SIZE_ERROR("70100", HttpStatus.BAD_REQUEST, "图片太大"),
    IMG_TYPE_ERROR("70200", HttpStatus.BAD_REQUEST, "图片格式不正确"),
    IMG_GENERATE_ERROR("70300", HttpStatus.BAD_REQUEST, "base64编码生成图片失败"),
    FILE_SIZE_ERROR("70400", HttpStatus.BAD_REQUEST, "文件太大"),
    FILE_FORMAT_ERROR("70500", HttpStatus.BAD_REQUEST, "文件格式错误"),
    EXCEL_FORMAT_ERROR("80000", HttpStatus.BAD_REQUEST, "Excel格式错误,请从新下载模板"),
    EXCEL_DATA_ERROR("80100", HttpStatus.BAD_REQUEST, "Excel内容填写有误"),
    WECHAT_ACCESSFORM_EMPTY("90000", HttpStatus.UNAUTHORIZED, "微信授权登录失败,授权accessTokenForm为空"),
    WECHAT_CODE_EMPTY("90100", HttpStatus.UNAUTHORIZED, "微信授权登录失败,授权code为空!"),
    WECHAT_PAYMENT_FAILURE("90200", HttpStatus.UNAUTHORIZED, "发起支付失败!");

    private String code;
    private HttpStatus status;
    private String msg;

    private ResponseEnum(String code, HttpStatus status, String msg) {
        this.code = code;
        this.status = status;
        this.msg = msg;
    }

    public String getCode() {
        return this.code;
    }

    public HttpStatus getStatus() {
        return this.status;
    }

    public String getMsg() {
        return this.msg;
    }
}

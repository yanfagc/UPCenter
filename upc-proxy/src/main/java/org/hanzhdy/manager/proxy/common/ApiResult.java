package org.hanzhdy.manager.proxy.common;

/**
 * Api Result
 * Created by H.CAAHN on 2017/12/9.
 */
public class ApiResult {
    public static final ApiResult SUCCESS = new ApiResult(100, "操作成功！", true);
    
    public static final ApiResult FAILED_ARGS_EMPTY = new ApiResult(-900, "请求处理失败，必填参数不允许为空！", true);
    
    public static final ApiResult EXCEPTION = new ApiResult(-999, "操作异常，请联系管理员！", true);
    
    private int code;
    
    private String msg;
    
    private Object body;
    
    private final boolean immutable;
    
    public ApiResult appendBody(Object body) {
        ApiResult apiResult = this.immutable ? new ApiResult(this.code, this.msg, false) : this;
        apiResult.body = body;
        return apiResult;
    }
    
    public ApiResult appendMsg(String msg) {
        if (this.immutable) {
            return new ApiResult(this.code, msg, this.body, false);
        }
        this.msg = msg;
        return this;
    }
    
    private ApiResult(int code, String msg, boolean immutable) {
        this(code, msg, null, immutable);
    }
    
    private ApiResult(int code, String msg, Object body, boolean immutable) {
        this.code = code;
        this.msg = msg;
        this.body = body;
        this.immutable = immutable;
    }
    
    public int getCode() {
        return code;
    }
    
    public String getMsg() {
        return msg;
    }
    
    public Object getBody() {
        return body;
    }
}

package org.hanzhdy.manager.support.constants.resp;

import java.lang.reflect.Field;

import org.hanzhdy.utils.resources.Resources;
import org.hanzhdy.web.throwable.BizStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description
 * @author H.CAAHN
 * @createtime 2017年4月13日 下午9:44:37
 */
public class RespResult {
    private static final String CODE_PREFIX = "biz.code.";
    
    private static final String MSG_PREFIX  = "biz.mesg.";
    
    private static final Logger logger      = LoggerFactory.getLogger(RespResult.class);
    
    private int                 code;
    
    private String              msg;
    
    private Object              body;
    
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
    
    public Object getBody() {
        return body;
    }
    
    public void setBody(Object body) {
        this.body = body;
    }
    
    public static final RespResult create(BizStatus status) {
        return create(status.getCode(), status.getMsg(), null);
    }
    
    public static final RespResult create(BizStatus status, Object body) {
        return create(status.getCode(), status.getMsg(), body);
    }
    
    public static final RespResult create(int code, String msg) {
        return create(code, msg, null);
    }
    
    public static final RespResult create(int code, String msg, Object body) {
        RespResult result = new RespResult();
        result.code = code;
        result.msg = msg;
        result.body = body;
        return result;
    }
    
    public static void initRespCode(RespCode instance) throws Exception {
        Field[] fieldList = RespCode.class.getFields();
        for (Field field : fieldList) {
            String codeKey = CODE_PREFIX + field.getName();
            String msgKey = MSG_PREFIX + field.getName();
            
            String code = Resources.getI18nString(codeKey);
            String msg = Resources.getI18nString(msgKey);
            try {
                field.setAccessible(true);
                field.set(instance, new BizStatus(Integer.valueOf(code), msg));
            }
            catch (NumberFormatException ex) {
                logger.warn("不能将：{}转换为数值", code);
            }
            catch (Exception ex) {
                throw ex;
            }
        }
    }
}

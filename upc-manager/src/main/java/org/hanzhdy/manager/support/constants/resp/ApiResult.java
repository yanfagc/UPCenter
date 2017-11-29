package org.hanzhdy.manager.support.constants.resp;

import org.hanzhdy.utils.resources.Resources;
import org.hanzhdy.web.throwable.BizStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

/**
 * @description
 * @author H.CAAHN
 * @createtime 2017年4月13日 下午9:44:37
 */
public class ApiResult {
    /** 操作成功 */
    public static final BizStatus        SUCCESS                   = null;
    
    /** 登录超时，请重新登录 */
    public static final BizStatus        LOGIN_TIMEOUT             = null;
    
    /** 登录失败，用户名不允许为空 */
    public static final BizStatus        LOGIN_EMPTY_USERNAME      = null;
    
    /** 登录失败，密码不允许为空 */
    public static final BizStatus        LOGIN_EMPTY_PASSWORD      = null;
    
    /** 登录失败，图片验证码不允许为空 */
    public static final BizStatus        LOGIN_EMPTY_IMGTOKEN      = null;
    
    /** 登录失败，手机验证码不允许为空 */
    public static final BizStatus        LOGIN_EMPTY_MOBILETOKEN   = null;
    
    /** 登录失败，图片验证码错误 */
    public static final BizStatus        LOGIN_ILLEGAL_IMGTOKEN    = null;
    
    /** 登录失败，手机验证码错误 */
    public static final BizStatus        LOGIN_ILLEGAL_MOBILETOKEN = null;
    
    /** 登录失败，用户名或密码错误 */
    public static final BizStatus        LOGIN_ILLEGAL_USER_PWD    = null;
    
    /** 登录失败，用户被锁定 */
    public static final BizStatus        LOGIN_USER_LOCKED         = null;
    
    /** 登录失败，用户被冻结 */
    public static final BizStatus        LOGIN_USER_FROZEN         = null;
    
    /** 登录失败，登录次数过多 */
    public static final BizStatus        LOGIN_EXCESSIVE_ATTEMPTS = null;
    
    /** 密码修改失败，新密码不允许为空 */
    public static final BizStatus        UPDATE_PW_EMPTY_NEWPW    = null;
    
    /** 密码修改失败，数据记录不存在 */
    public static final BizStatus        UPDATE_PW_NORECORD       = null;
    
    /** 密码修改失败，当前密码输入错误 */
    public static final BizStatus        UPDATE_PW_ILLEGAL_OLDPW  = null;
    
    /** 密码修改失败，当前密码不符合要求 */
    public static final BizStatus        UPDATE_PW_ILLEGAL_RULE   = null;
    
    /** 密码修改失败，管理员密码输入错误 */
    public static final BizStatus        UPDATE_PW_ILLEGAL_ADMINPW= null;
    
    /** 数据保存失败，未找到记录 */
    public static final BizStatus        SAVE_NORECORD             = null;
    
    /** 数据保存失败，状态不合法 */
    public static final BizStatus        SAVE_ERROR_STATUS         = null;
    
    /** 数据保存失败，记录已存在 */
    public static final BizStatus        SAVE_DUPLICATE            = null;
    
    /** 文件上传失败，请稍候再试 */
    public static final BizStatus        UPLOAD_FAILURE            = null;
    
    /** 文件上传失败，服务配置错误 */
    public static final BizStatus        UPLOAD_ERROR_CONFIGURE    = null;
    
    /** 数据保存失败，主键数据为空 */
    public static final BizStatus        SAVE_PRIMARY_EMPTY        = null;
    
    /** 操作失败，错误的数据格式 */
    public static final BizStatus        ERROR_DATA_FORMAT         = null;
    
    /** 操作失败，服务器异常，请联系管理员 */
    public static final BizStatus        ERROR_EXCEPTION           = null;
    
    private static final String CODE_PREFIX = "biz.code.";
    
    private static final String MSG_PREFIX  = "biz.mesg.";
    
    private static final Logger logger      = LoggerFactory.getLogger(ApiResult.class);
    
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
    
    static {
        Class<ApiResult> clazz = ApiResult.class;
        Field[] fieldList = ApiResult.class.getFields();
        for (Field field : fieldList) {
            String codeKey = CODE_PREFIX + field.getName();
            String msgKey = MSG_PREFIX + field.getName();
        
            String code = Resources.getI18nString(codeKey);
            String msg = Resources.getI18nString(msgKey);
            try {
                field.setAccessible(true);
                field.set(clazz, new BizStatus(Integer.valueOf(code), msg));
            }
            catch (NumberFormatException ex) {
                logger.warn("不能将：{}转换为数值", code);
            }
            catch (Exception ex) {
                logger.error("无法设置返回值：" + code + ", " + msg, ex);
            }
        }
    }
    
    public static final ApiResult create(BizStatus status) {
        return create(status.getCode(), status.getMsg(), null);
    }
    
    public static final ApiResult create(BizStatus status, Object body) {
        return create(status.getCode(), status.getMsg(), body);
    }
    
    public static final ApiResult create(int code, String msg, Object body) {
        ApiResult result = new ApiResult();
        result.code = code;
        result.msg = msg;
        result.body = body;
        return result;
    }
}

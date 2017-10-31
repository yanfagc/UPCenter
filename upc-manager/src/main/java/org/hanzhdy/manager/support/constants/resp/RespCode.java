package org.hanzhdy.manager.support.constants.resp;

import org.hanzhdy.web.throwable.BizStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description
 * @author H.CAAHN
 * @createtime 2017年4月13日 下午7:17:11
 */
public class RespCode {
    /** 操作成功 */
    public final BizStatus        SUCCESS                   = null;

    /** 登录超时，请重新登录 */
    public final BizStatus        LOGIN_TIMEOUT             = null;

    /** 登录失败，用户名不允许为空 */
    public final BizStatus        LOGIN_EMPTY_USERNAME      = null;

    /** 登录失败，密码不允许为空 */
    public final BizStatus        LOGIN_EMPTY_PASSWORD      = null;

    /** 登录失败，图片验证码不允许为空 */
    public final BizStatus        LOGIN_EMPTY_IMGTOKEN      = null;

    /** 登录失败，手机验证码不允许为空 */
    public final BizStatus        LOGIN_EMPTY_MOBILETOKEN   = null;

    /** 登录失败，图片验证码错误 */
    public final BizStatus        LOGIN_ILLEGAL_IMGTOKEN    = null;

    /** 登录失败，手机验证码错误 */
    public final BizStatus        LOGIN_ILLEGAL_MOBILETOKEN = null;

    /** 登录失败，用户名或密码错误 */
    public final BizStatus        LOGIN_ILLEGAL_USER_PWD    = null;

    /** 登录失败，用户被锁定 */
    public final BizStatus        LOGIN_USER_LOCKED         = null;

    /** 登录失败，用户被冻结 */
    public final BizStatus        LOGIN_USER_FROZEN         = null;
    
    /** 登录失败，登录次数过多 */
    public final BizStatus        LOGIN_EXCESSIVE_ATTEMPTS = null;
    
    /** 密码修改失败，新密码不允许为空 */
    public final BizStatus        UPDATE_PW_EMPTY_NEWPW    = null;
    
    /** 密码修改失败，数据记录不存在 */
    public final BizStatus        UPDATE_PW_NORECORD       = null;
    
    /** 密码修改失败，当前密码输入错误 */
    public final BizStatus        UPDATE_PW_ILLEGAL_OLDPW  = null;
    
    /** 密码修改失败，当前密码不符合要求 */
    public final BizStatus        UPDATE_PW_ILLEGAL_RULE   = null;
    
    /** 密码修改失败，管理员密码输入错误 */
    public final BizStatus        UPDATE_PW_ILLEGAL_ADMINPW= null;
    
    /** 数据保存失败，未找到记录 */
    public final BizStatus        SAVE_NORECORD             = null;

    /** 数据保存失败，状态不合法 */
    public final BizStatus        SAVE_ERROR_STATUS         = null;

    /** 数据保存失败，记录已存在 */
    public final BizStatus        SAVE_DUPLICATE            = null;
    
    /** 文件上传失败，请稍候再试 */
    public final BizStatus        UPLOAD_FAILURE            = null;
    
    /** 文件上传失败，服务配置错误 */
    public final BizStatus        UPLOAD_ERROR_CONFIGURE    = null;
    
    /** 数据保存失败，主键数据为空 */
    public final BizStatus        SAVE_PRIMARY_EMPTY        = null;

    /** 操作失败，错误的数据格式 */
    public final BizStatus        ERROR_DATA_FORMAT         = null;

    /** 操作失败，服务器异常，请联系管理员 */
    public final BizStatus        ERROR_EXCEPTION           = null;
    
    private static final Logger   logger                    = LoggerFactory.getLogger(RespCode.class);
    
    private static final RespCode instance                  = new RespCode();
    
    private RespCode() {
        try {
            RespResult.initRespCode(this);
        }
        catch (Exception ex) {
            logger.error("加载系统返回码失败", ex);
        }
    }
    
    public static final RespCode getInstance() {
        return instance;
    }
    
}

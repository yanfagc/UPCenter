package org.hanzhdy.manager.support.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hanzhdy.manager.settings.engine.EngineContext;
import org.hanzhdy.manager.support.bean.SessionUser;
import org.hanzhdy.manager.support.constants.WebConstants;
import org.hanzhdy.manager.support.constants.resp.RespCode;
import org.hanzhdy.web.bean.DatatableResult;
import org.hanzhdy.web.controller.AbstractController;
import org.hanzhdy.web.throwable.BizStatus;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpServletRequest;

/**
 * @description 应用Controller
 * @author H.CAAHN
 * @createtime 2016年9月13日 下午10:32:03
 */
public class ApplicationController extends AbstractController {
    protected String                REDIRECT_404 = "/error/404";
    
    protected String                REDIRECT_403 = "/error/403";
    
    @Value("${system.code}")
    protected String                systemCode;
    
    protected static final RespCode respCode     = RespCode.getInstance();
    
    protected Object response(BizStatus status, Object data) {
        return super.response(String.valueOf(status.getCode()), data, status.getMsg());
    }
    
    protected void setSessionUser(HttpServletRequest request, SessionUser sessionUser) {
        Subject subject = SecurityUtils.getSubject();
        subject.getSession().setAttribute(WebConstants.SESSION_USER, sessionUser);
    }
    
    protected void removeSessionUser(HttpServletRequest request) {
//        HttpSession session = request.getSession();
//        session.removeAttribute(WebConstants.SESSION_USER);
        Subject subject = SecurityUtils.getSubject();
        subject.getSession().removeAttribute(WebConstants.SESSION_USER);
    }
    
    protected SessionUser getSessionUser(HttpServletRequest request) {
//        HttpSession session = request.getSession();
//        return (SessionUser)session.getAttribute(WebConstants.SESSION_USER);
        Subject subject = SecurityUtils.getSubject();
        return (SessionUser) subject.getSession().getAttribute(WebConstants.SESSION_USER);
    }
    
    protected void setSessionVal(HttpServletRequest request, String key, Object value) {
        Subject subject = SecurityUtils.getSubject();
        subject.getSession().setAttribute(key, value);
    }
    
    protected Object getSessionVal(HttpServletRequest request, String key) {
        Subject subject = SecurityUtils.getSubject();
        return subject.getSession().getAttribute(key);
    }
    
    protected EngineContext getEngineContext(HttpServletRequest request) {
        EngineContext context = new EngineContext(request);
        
        return context;
    }

    protected DatatableResult getEmptyDatatableResult() {
        DatatableResult datatableResult = new DatatableResult();
        datatableResult.setTotal(0);
        datatableResult.setAaData(new Object[0]);
        return datatableResult;
    }
}

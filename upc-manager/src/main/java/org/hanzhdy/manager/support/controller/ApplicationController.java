package org.hanzhdy.manager.support.controller;

import org.hanzhdy.manager.engine.EngineContext;
import org.hanzhdy.manager.support.bean.SessionUser;
import org.hanzhdy.manager.support.constants.WebConstants;
import org.hanzhdy.manager.support.constants.resp.RespCode;
import org.hanzhdy.web.controller.AbstractController;
import org.hanzhdy.web.throwable.BizStatus;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @description 应用Controller
 * @author H.CAAHN
 * @createtime 2016年9月13日 下午10:32:03
 */
public class ApplicationController extends AbstractController {
    protected String                REDIRECT_404 = "/error/404";
    
    @Value("${system.code}")
    protected String                systemCode;
    
    protected static final RespCode respCode     = RespCode.getInstance();
    
    protected Object response(BizStatus status, Object data) {
        return super.response(String.valueOf(status.getCode()), data, status.getMsg());
    }
    
    protected void setSessionUser(HttpServletRequest request, SessionUser sessionUser) {
        HttpSession session = request.getSession();
        session.setAttribute(WebConstants.SESSION_USER, sessionUser);
    }
    
    protected void removeSessionUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute(WebConstants.SESSION_USER);
    }
    
    protected SessionUser getSessionUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return (SessionUser)session.getAttribute(WebConstants.SESSION_USER);
    }
    
    protected EngineContext getEngineContext(HttpServletRequest request) {
        EngineContext context = new EngineContext(request);
        
        return context;
    }
}

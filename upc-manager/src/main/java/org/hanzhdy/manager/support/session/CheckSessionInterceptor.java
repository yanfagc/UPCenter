package org.hanzhdy.manager.support.session;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hanzhdy.manager.support.bean.SessionUser;
import org.hanzhdy.manager.support.constants.WebConstants;
import org.hanzhdy.manager.support.enums.LoginUserStatus;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * Created with IntelliJ IDEA. User: Administrator Date: 13-11-25 Time: 上午9:16
 * 检查用户是否登录.
 */
public class CheckSessionInterceptor extends HandlerInterceptorAdapter {
    
    /**
     * 检查客户是否已登录
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if (session == null) {
            return redirectLogin(request, response);
        }
        else {
            SessionUser user = (SessionUser) session.getAttribute(WebConstants.SESSION_USER);
            if (user == null) {
                return redirectLogin(request, response);
            }
            
            // 帐号被冻结或注销
            if (user.getStatus() != LoginUserStatus.N) {
                return redirectLogin(request, response);
            }
        }
        return true;
    }
    
    /**
     * 跳转登录页
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    public boolean redirectLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return redirectLogin(request, response, "/login");
    }
    
    /**
     * 跳转登录页
     * @param request
     * @param response
     * @param redirect
     * @return
     * @throws IOException
     */
    public boolean redirectLogin(HttpServletRequest request, HttpServletResponse response, String redirect)
            throws IOException {
        String str = request.getHeader("x-requested-with");
        // 如果是异步请求，则写入json信息，反之则跳转到登录页面
        if ("XMLHttpRequest".equalsIgnoreCase(str)) {
            String rsp = "{\"result\":\"not_login\"}";
            response.getOutputStream().write(rsp.getBytes());
        }
        else {
            response.sendRedirect(request.getContextPath() + redirect);
        }
        return false;
    }
}

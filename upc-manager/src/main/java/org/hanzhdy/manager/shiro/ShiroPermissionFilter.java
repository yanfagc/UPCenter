package org.hanzhdy.manager.shiro;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Shiro Permission Filter
 * Created by H.CAAHN on 2017/8/31.
 */
public class ShiroPermissionFilter extends AccessControlFilter {
    private static final Logger logger = LoggerFactory.getLogger(ShiroPermissionFilter.class);

    @Override
    public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws IOException {
        //先判断带参数的权限判断
        Subject subject = getSubject(request, response);
        if(mappedValue != null){
            String[] arra = (String[])mappedValue;
            for (String permission : arra) {
                if(subject.isPermitted(permission)){
                    return Boolean.TRUE;
                }
            }
        }
        HttpServletRequest httpRequest = ((HttpServletRequest)request);
        
//        String uri = httpRequest.getRequestURI();//获取URI
//        String basePath = httpRequest.getContextPath();//获取basePath
//        if(basePath.length() > 0 && uri != null && uri.startsWith(basePath)){
//            uri = uri.replace(basePath, "");
//        }
        
        String uri = httpRequest.getServletPath();
        
        if (subject.isPermitted(uri)){
            return Boolean.TRUE;
        }
        if (ShiroFilterUtils.isAjax(request)){
            Map<String,String> resultMap = new HashMap<String, String>();
            logger.debug("用户未登录，并且为ajax请求！");
            resultMap.put("login_status", "300");
            resultMap.put("message", "当前用户没有登录");//当前用户没有登录！
            ShiroFilterUtils.out(response, resultMap);
        }
        return Boolean.FALSE;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
        Subject subject = getSubject(request, response);
        if (null == subject.getPrincipal()) {//表示没有登录，重定向到登录页面
            saveRequest(request);
            WebUtils.issueRedirect(request, response, ShiroFilterUtils.LOGIN_URL);
        } else {
//            if (StringUtils.hasText(ShiroFilterUtils.UNAUTHORIZED)) {//如果有未授权页面跳转过去
//                WebUtils.issueRedirect(request, response, ShiroFilterUtils.UNAUTHORIZED);
//            } else {//否则返回401未授权状态码
//                WebUtils.toHttp(response).sendError(HttpServletResponse.SC_UNAUTHORIZED);
//            }
        }
        return Boolean.FALSE;
    }
}

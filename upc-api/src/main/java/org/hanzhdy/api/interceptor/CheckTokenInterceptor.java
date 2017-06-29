package org.hanzhdy.api.interceptor;

import org.apache.commons.lang.StringUtils;
import org.hanzhdy.api.cache.UserCache;
import org.hanzhdy.api.cache.UserCacheManager;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA. User: Administrator Date: 13-11-25 Time: 上午9:16
 * 检查用户是否登录.
 */
public class CheckTokenInterceptor extends HandlerInterceptorAdapter {
    protected UserCacheManager userCacheManager;

    protected String USER_TOKEN = "USER_TOKEN";
    
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
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod)handler;
            Method method = handlerMethod.getMethod();
            CheckToken annotation = method.getAnnotation(CheckToken.class);

            // 需要校验登录状态
            if (annotation != null && annotation.check()) {
                String token = getToken(request);
                if (token == null) {
                    return false;
                }

                // 检查登录cache是否存在
                UserCache cache = userCacheManager.getUserCache(token);
                if (token == null || cache.getUserId() == null) {
                    return false;
                }
            }

            return true;
        }
        return false;
    }

    protected String getToken(HttpServletRequest request) {
        String token = request.getHeader(USER_TOKEN);
        if (StringUtils.isBlank(token)) {
            token = request.getParameter(USER_TOKEN);
        }

        return token;
    }

    public void setUserCacheManager(UserCacheManager userCacheManager) {
        this.userCacheManager = userCacheManager;
    }
}

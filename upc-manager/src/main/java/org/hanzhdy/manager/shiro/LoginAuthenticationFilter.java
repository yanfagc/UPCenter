package org.hanzhdy.manager.shiro;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.hanzhdy.manager.support.constants.resp.RespCode;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 因为登录请求是通过ajax过来的，因此如果采用shiro自带的redirect功能，前端js中收到的是一段首页的html文本<br/>
 * 此时登录页面中的js因无法解析该段html，将提示登录失败。<br/>
 * 所以这里我们自定义为，如果是ajax，那么onLoginSuccess中return true，提交由controller处理
 * Created by H.CAAHN on 2017/9/29.
 */
public class LoginAuthenticationFilter extends FormAuthenticationFilter {
    private RespCode respCode = RespCode.getInstance();
    
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject,
                                     ServletRequest request, ServletResponse response) throws Exception {
        if (request instanceof HttpServletRequest) {
            String requestType = ((HttpServletRequest)request).getHeader("X-Requested-With");
            if (StringUtils.isNotBlank(requestType)) {
                return true;
            }
        }
        
        return super.onLoginSuccess(token, subject, request, response);
    }
}

package org.hanzhdy.manager.shiro;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by H.CAAHN on 2017/8/31.
 */
public class ShiroFilterUtils {
    //登录页面
    static final String LOGIN_URL = "/login";
    //踢出登录提示
    final static String KICKED_OUT = "/open/kickedOut.shtml";
    //没有权限提醒
    final static String UNAUTHORIZED = "/open/unauthorized.shtml";

    private static final Logger logger = LoggerFactory.getLogger(ShiroFilterUtils.class);
    /**
     * 是否是Ajax请求
     * @param request
     * @return
     */
    public static boolean isAjax(ServletRequest request){
        return "XMLHttpRequest".equalsIgnoreCase(((HttpServletRequest) request).getHeader("X-Requested-With"));
    }

    /**
     * response 输出JSON
     * @param response
     * @param resultMap
     */
    public static void out(ServletResponse response, Map<String, String> resultMap){
        PrintWriter out = null;
        try {
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            out.println(JSON.toJSONString(resultMap));
        } catch (Exception ex) {
            logger.error("Response out error", ex);
        }finally{
            if(null != out){
                out.flush();
                out.close();
            }
        }
    }
}

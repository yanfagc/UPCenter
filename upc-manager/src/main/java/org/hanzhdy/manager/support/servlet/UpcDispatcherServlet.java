package org.hanzhdy.manager.support.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.util.WebUtils;

/**
 * @description 自定义的DispatcherServlet
 * @author H.CAAHN
 * @createtime 2017年6月15日 下午11:43:49
 */
public class UpcDispatcherServlet extends DispatcherServlet {
    /** 序列化号 */
    private static final long serialVersionUID = 6426459242775018472L;
    
    private static final Logger logger = LoggerFactory.getLogger(UpcDispatcherServlet.class);
    
    protected void noHandlerFound(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String uri = getRequestUri(request);
        String servletName = getServletName();
        logger.warn("No mapping found for HTTP request with URI [" + uri +
                    "] in DispatcherServlet with name '" + servletName + "'");
        // 设置状态为404
        response.sendError(HttpServletResponse.SC_NOT_FOUND);
        
        // 跳转到404页面
        String page = "/WEB-INF/jsp/error/404.jsp";
        request.getRequestDispatcher(page).forward(request, response);
    }
    
    public static String getRequestUri(HttpServletRequest request) {
        String uri = (String) request.getAttribute(WebUtils.INCLUDE_REQUEST_URI_ATTRIBUTE);
        if (uri == null) {
            uri = request.getRequestURI();
        }
        return uri;
    }
}

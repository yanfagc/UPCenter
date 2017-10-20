<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="org.hanzhdy.manager.support.constants.resp.RespCode" %>
<%@ page import="org.hanzhdy.manager.shiro.ShiroFilterUtils" %>
<%@ page import="com.alibaba.fastjson.JSON" %>
<%
    String contextPath = request.getContextPath();
    if(contextPath.endsWith("/")){
        contextPath=contextPath.substring(0,contextPath.length()-1);
    }
    RespCode respCode = RespCode.getInstance();
    boolean isAjax = ShiroFilterUtils.isAjax(request);
    try {
        if (isAjax) {
            String result = JSON.toJSONString(respCode.LOGIN_TIMEOUT);
            response.setContentType("UTF-8");
            response.getWriter().write(result);
        }
        else {
            response.sendRedirect("/login");
        }
    }
    catch (Exception ex) {
    }
%>


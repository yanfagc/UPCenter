<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="/WEB-INF/jsp/error/500.jsp"%>
<%@ page import="org.hanzhdy.utils.resources.GlobalPlus"%>
<%@ page import="org.hanzhdy.utils.MathUtils"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String contextPath = request.getContextPath(); 
	if(contextPath.endsWith("/")){
	    contextPath=contextPath.substring(0,contextPath.length()-1);
	}

	String cacheRandom = "";
	GlobalPlus.Env env=GlobalPlus.getEnv();
	if(env!=GlobalPlus.Env.production){
	    int random = MathUtils.getRandomNum(1000,10000);
	    cacheRandom="r=" + random;
	}
%>
<c:set var="ctx" value="<%=contextPath %>"/>
<c:set var="crm" value="<%=cacheRandom %>"/>
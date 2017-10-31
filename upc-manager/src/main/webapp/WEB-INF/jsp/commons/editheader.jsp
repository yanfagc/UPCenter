	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@include file="/WEB-INF/jsp/commons/include.jsp"%>
    <meta charset="UTF-8">
	<link rel="shortcut icon" href="${ctx}/logo.png" />
    <link href="${ctx}/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/css/main.css<c:if test='${not empty crm}'>?${crm}</c:if>" rel="stylesheet" type="text/css" />
    <link href="${ctx}/plugins/easydialog/easydialog.css" rel="stylesheet" type="text/css" />
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/commons/include.jsp"%>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
	<link rel="shortcut icon" href="${ctx}/logo.png" />
    <link href="${ctx}/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/plugins/font-awesome-4.4.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/plugins/ionicons-2.0.1/css/ionicons.min.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/plugins/datatables/dataTables.bootstrap.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/plugins/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/plugins/dist/css/skins/_all-skins.min.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/plugins/easydialog/easydialog.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/css/main.css<c:if test='${not empty crm}'>?${crm}</c:if>" rel="stylesheet" type="text/css" />
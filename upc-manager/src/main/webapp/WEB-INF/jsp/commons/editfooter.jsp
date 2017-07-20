<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/commons/include.jsp"%>
  <script src="${ctx}/plugins/jquery/jquery-1.11.3.min.js" type="text/javascript"></script>
  <script src="${ctx}/plugins/jquery/jquery.form.js" type="text/javascript"></script>
  <script src="${ctx}/plugins/easydialog/easydialog.min.js" type="text/javascript"></script>
  <script src="${ctx}/plugins/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
  <script src="${ctx}/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
  <script src="${ctx}/js/jquery.myvalidate.js<c:if test='${not empty crm}'>?${crm}</c:if>" type="text/javascript"></script>
  <script src="${ctx}/js/global.js?contextPath=${ctx}<c:if test='${not empty crm}'>&${crm}</c:if>" type="text/javascript"></script>
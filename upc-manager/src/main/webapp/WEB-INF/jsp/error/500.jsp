<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
<%@ page import="java.io.StringWriter"%>
<%@ page import="java.io.PrintWriter"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String contextPath = request.getContextPath(); 
	if(contextPath.endsWith("/")){
	    contextPath=contextPath.substring(0,contextPath.length()-1);
	}
%>
<c:set var="ctx" value="<%=contextPath %>"/>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
	<title>系统异常</title>
	<link rel="shortcut icon" href="${ctx}/logo.png" />
	<link href="${ctx}/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
  </head>
  <body>
    <div class="container" style="width:98%">
    <div class="row">
        <legend></legend>
        <div class="row-fluid" style="text-align:center;margin-bottom:16px;font-size: 20px;">系统异常</div>
        <div class="panel panel-default">
			<div class="panel-heading">
				<span style="width:80%">对不起，您的请求暂时无法处理！请联系管理员或稍后再试！</span>
				<span style="width:12%;float:right">
					<a href="javascript:void(0);" onclick="showDetail();">&gt;&gt;错误详情</a>
				</span>
			</div>
			<pre class="panel-body" style="display:none">
				<%
				StringWriter sw = new StringWriter();
				PrintWriter pw = new PrintWriter(sw);
				
				exception.printStackTrace(pw);
				StringBuffer buf = sw.getBuffer();
				%>
				<p>
					<pre><%=buf.toString() %></pre>
				</p>
			</pre>
		</div>
	  </div>
    </div>
  </body>
  <jsp:include page="/WEB-INF/jsp/commons/editfooter.jsp" />
  <script type="text/javascript">
  function showDetail() {
	  $('.panel-body').show();
  }
  </script>
</html>
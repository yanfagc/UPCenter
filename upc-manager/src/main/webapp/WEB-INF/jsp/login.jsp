<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/commons/include.jsp"%>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
<meta charset="utf-8">
<title>用户权限管理中心</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="${ctx}/logo.png" />
<link rel="stylesheet" href="${ctx}/plugins/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${ctx}/css/login/supersized.css">
<link rel="stylesheet" href="${ctx}/css/login/login.css"><script type="text/javascript">
var $ctx='${ctx}';
if(top.location!=self.location){
	top.location = self.location;
}
</script>
</head>

<body>

<div class="page-container">
	<div class="main_box">
		<div class="login_box">
			<div class="login_logo">
				<img src="${ctx}/images/login/logo.png" >
			</div>
		
			<div class="login_form">
				<form id="login_form" method="post" action="${ctx}/doLogin">
					<div class="form-group">
						<label for="j_username" class="t">用户名：</label> 
						<input id="j_username" value="" name="j_username" type="text" class="form-control x319 in" autocomplete="off">
					</div>
					<div class="form-group">
						<label for="j_password" class="t">密　码：</label> 
						<input id="j_password" value="" name="j_password" type="password" class="password form-control x319 in">
					</div>
					<div class="form-group">
						<label for="j_captcha" class="t">验证码：</label> 
						<input id="j_captcha" value="" name="j_captcha" type="text" class="password form-control x319 in">
					</div>
					<%-- <div class="form-group">
						<label for="j_captcha" class="t">验证码：</label>
						 <input id="j_captcha" name="j_captcha" type="text" class="form-control x164 in">
						<img id="captcha_img" alt="点击更换" title="点击更换" src="${ctx}/images/login/captcha.jpeg" class="m">
					</div> --%>
					<div class="form-group">
						<label class="t"></label>
						<label for="j_remember" class="m">
						<input id="j_remember" type="checkbox" value="true">&nbsp;记住登陆账号!</label>
					</div>
					<div class="form-group space">
						<label class="t"></label>　　　
						<button type="button"  id="submit_btn" 
						class="btn btn-primary btn-lg">&nbsp;登&nbsp;录&nbsp;</button>
						<input type="reset" value="&nbsp;重&nbsp;置&nbsp;" class="btn btn-default btn-lg">
					</div>
				</form>
			</div>
		</div>
		<div class="bottom">Copyright &copy; 2015 - 2016 <a href="javascript:void(0);">用户权限管理中心</a></div>
	</div>
</div>

<ul id="supersized" class="quality" style="visibility: visible;">
	<li class="slide-3 activeslide" style="visibility: visible; opacity: 1;">
		<a target="_blank"><img src="${ctx}/images/login/login_bg.jpg" style="width: 100%; left: 0px; top: 0px; height: 100%;"></a>
	</li>
</ul>

<!-- Javascript -->
<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
	<script src="${ctx}/js/html5.js"></script>
<![endif]-->
<script type="text/javascript" src="${ctx}/plugins/jquery/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="${ctx}/plugins/jquery/jquery.form.js"></script>
<%-- <script type="text/javascript" src="${ctx}/js/login/supersized.3.2.7.min.js"></script>
<script type="text/javascript" src="${ctx}/js/login/supersized-init.js"></script> --%>
<script type="text/javascript" src="${ctx}/js/login/tooltips.js"></script>
<script type="text/javascript" src="${ctx}/js/login/login.js<c:if test='${not empty crm}'>?${crm}</c:if>"></script>
<script type="text/javascript" src="${ctx}/js/login/scripts.js"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/commons/include.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>修改用户密码</title>
    <jsp:include page="/WEB-INF/jsp/commons/editheader.jsp" />
  </head>
  <body>
    <nav class="navbar navbar-default navbar-fixed-top" style="min-height:40px;">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="javascript:void(0);" style="height:40px;line-height:8px;">修改用户密码</a>
        </div>
      </div>
    </nav>
    <div class="container" style="width:100%;margin-top:50px;padding-left:10px;padding-right:10px;">
      <form id="submitForm" class="form-horizontal" action="${ctx}/basic/user/updatePassword" method="POST">
        <input name="userid" value="${userid}" type="hidden"/>
        <table class="table table-bordered table-hover">
          <tr>
            <td style="width:25%;text-align:right;">登录帐号：</td>
            <td style="width:75%;padding:4px;">
              <input name="account" class="form-control input-sm myspan6" type="text" value="${account}" readonly="readonly">
            </td>
          </tr>
          <tr>
            <td style="width:25%;text-align:right;">新密码：</td>
            <td style="padding:4px;">
              <input name="newPassword" class="form-control input-sm myspan6" type="password" placeholder="请输入新密码">
            </td>
          </tr>
          <tr>
            <td style="width:25%;text-align:right;">重复密码：</td>
            <td style="padding:4px;">
              <input name="rePassword" class="form-control input-sm myspan6" type="password" placeholder="请重复输入新密码">
            </td>
          </tr>
          <tr>
            <td style="width:25%;text-align:right;">管理员密码：</td>
            <td style="padding:4px;">
              <input name="adminPassword" class="form-control input-sm myspan6" type="password" placeholder="请输入管理员登录密码">
            </td>
          </tr>
        </table>
      </form>
    </div>
    <div class="well center-block" style="left:10px;right:10px;position:fixed;bottom:0px;padding:10px;">
      <button type="button" class="btn btn-primary submit">&nbsp;&nbsp;保&nbsp;存&nbsp;&nbsp;</button>
      <button type="button" class="btn btn-warning" onclick="window.close();" style="float:right">&nbsp;&nbsp;关&nbsp;闭&nbsp;&nbsp;</button>
    </div>
  </body>
  <jsp:include page="/WEB-INF/jsp/commons/editfooter.jsp" />
  <script src="${ctx}/js/basic/user/user-modifyPw.js<c:if test='${not empty crm}'>?${crm}</c:if>" type="text/javascript"></script>
</html>
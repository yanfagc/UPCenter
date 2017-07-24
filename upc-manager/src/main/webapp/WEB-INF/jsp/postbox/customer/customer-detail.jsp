<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/commons/include.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>客户详情</title>
    <jsp:include page="/WEB-INF/jsp/commons/editheader.jsp" />
  </head>
  <body>
    <nav class="navbar navbar-default navbar-fixed-top" style="min-height:40px;">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="javascript:void(0);" style="height:40px;line-height:8px;">客户详情</a>
        </div>
      </div>
    </nav>
    <div class="container" style="width:100%;margin-top:50px;padding-left:10px;padding-right:10px;">
      <form id="submitForm" class="form-horizontal">
        <table class="table table-bordered table-hover">
          <tr>
            <td style="width:16%;text-align:right;">客户姓名：</td>
            <td style="width:32%;">
              ${record.realname}
            </td>
            <td style="width:16%;text-align:right;">性别：</td>
            <td style="width:32%;">
              <c:forEach items="${sexList}" var="sex">
                <c:if test="${sex eq record.sex}">${sex.remark}</c:if>
              </c:forEach>
            </td>
          </tr>
          <tr>
            <td style="width:16%;text-align:right;">外部帐号：</td>
            <td style="width:32%;">
              ${record.bindAccount}
            </td>
            <td style="width:16%;text-align:right;">登录名：</td>
            <td style="width:32%;">
              ${record.loginName}
            </td>
          </tr>
          <tr>
            <td style="width:16%;text-align:right;">国家：</td>
            <td style="width:32%;">
              ${record.country}
            </td>
            <td style="width:16%;text-align:right;">省份：</td>
            <td style="width:32%;">
              ${record.province}
            </td>
          </tr>
          <tr>
            <td style="width:16%;text-align:right;">城市：</td>
            <td style="width:32%;">
              ${record.city}
            </td>
            <td style="width:16%;text-align:right;">手机号码：</td>
            <td style="width:32%;">
              ${record.mobilePhone}
            </td>
          </tr>
          <tr>
            <td style="width:16%;text-align:right;">状态：</td>
            <td style="width:32%;">
              <c:forEach items="${statusList}" var="status">
                <c:if test="${status eq record.status}">${status.remark}</c:if>
              </c:forEach>
            </td>
            <td style="width:16%;text-align:right;">注册来源：</td>
            <td style="width:32%;">
              ${record.source}
            </td>
          </tr>
          <tr>
            <td style="width:16%;text-align:right;">注册IP：</td>
            <td style="width:32%;">
              ${record.registerIpAddress}
            </td>
            <td style="width:16%;text-align:right;">注册时间：</td>
            <td style="width:32%;">
              <fmt:formatDate value="${record.registerTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
            </td>
          </tr>
          <tr>
            <td style="width:16%;text-align:right;">上次登录IP:：</td>
            <td style="width:32%;">
              ${record.lastLoginTime}
            </td>
            <td style="width:16%;text-align:right;">上次登录时间：</td>
            <td style="width:32%;">
              <fmt:formatDate value="${record.lastLoginTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
            </td>
          </tr>
        </table>
      </form>
    </div>
    <div class="well center-block" style="left:10px;right:10px;position:fixed;bottom:0px;padding:10px;">
      <button type="button" class="btn btn-warning" onclick="window.close();" style="float:right">&nbsp;&nbsp;关&nbsp;闭&nbsp;&nbsp;</button>
    </div>
  </body>
  <jsp:include page="/WEB-INF/jsp/commons/editfooter.jsp" />
</html>
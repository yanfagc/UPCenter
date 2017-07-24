<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/commons/include.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>快递员详情</title>
    <jsp:include page="/WEB-INF/jsp/commons/editheader.jsp" />
  </head>
  <body>
    <nav class="navbar navbar-default navbar-fixed-top" style="min-height:40px;">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="javascript:void(0);" style="height:40px;line-height:8px;">快递员详情</a>
        </div>
      </div>
    </nav>
    <div class="container" style="width:100%;margin-top:50px;padding-left:10px;padding-right:10px;">
      <form id="submitForm" class="form-horizontal" <c:if test="${audit eq true}">action="${ctx}/postbox/expressman/updateStatus" method="POST"</c:if>>
        <c:if test="${audit eq true}">
          <input type="hidden" name="expressmanInfoId" value="${record.expressmanInfoId}" />
          <input type="hidden" name="status" value="NORMAL" />
        </c:if>
        <table class="table table-bordered table-hover">
          <tr>
            <td style="width:16%;text-align:right;">快递员姓名：</td>
            <td style="width:32%;">
              ${customer.realname}
                <c:forEach items="${expressStatusList}" var="es">
                  <c:if test="${es eq record.status}"><label style="color:blue">${es.remark}</label></c:if>
                </c:forEach>
            </td>
            <td style="width:16%;text-align:right;">性别：</td>
            <td style="width:32%;">
              <c:forEach items="${sexList}" var="sex">
                <c:if test="${sex eq customer.sex}">${sex.remark}</c:if>
              </c:forEach>
            </td>
          </tr>
          <tr>
            <td style="width:16%;text-align:right;">身份证照片：</td>
            <td style="width:32%;">

            </td>
            <td style="width:16%;text-align:right;">工作证照片：</td>
            <td style="width:32%;">

            </td>
          </tr>
          <tr>
            <td style="width:16%;text-align:right;">外部帐号：</td>
            <td style="width:32%;">
              ${customer.bindAccount}
            </td>
            <td style="width:16%;text-align:right;">登录名：</td>
            <td style="width:32%;">
              ${customer.loginName}
            </td>
          </tr>
          <tr>
            <td style="width:16%;text-align:right;">国家：</td>
            <td style="width:32%;">
              ${customer.country}
            </td>
            <td style="width:16%;text-align:right;">省份：</td>
            <td style="width:32%;">
              ${customer.province}
            </td>
          </tr>
          <tr>
            <td style="width:16%;text-align:right;">城市：</td>
            <td style="width:32%;">
              ${customer.city}
            </td>
            <td style="width:16%;text-align:right;">手机号码：</td>
            <td style="width:32%;">
              ${customer.mobilePhone}
            </td>
          </tr>
          <tr>
            <td style="width:16%;text-align:right;">状态：</td>
            <td style="width:32%;">
              <c:forEach items="${statusList}" var="status">
                <c:if test="${status eq customer.status}">${status.remark}</c:if>
              </c:forEach>
            </td>
            <td style="width:16%;text-align:right;">注册来源：</td>
            <td style="width:32%;">
              ${customer.source}
            </td>
          </tr>
          <tr>
            <td style="width:16%;text-align:right;">注册IP：</td>
            <td style="width:32%;">
              ${customer.registerIpAddress}
            </td>
            <td style="width:16%;text-align:right;">注册时间：</td>
            <td style="width:32%;">
              <fmt:formatDate value="${customer.registerTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
            </td>
          </tr>
          <tr>
            <td style="width:16%;text-align:right;">上次登录IP:：</td>
            <td style="width:32%;">
              ${customer.lastLoginTime}
            </td>
            <td style="width:16%;text-align:right;">上次登录时间：</td>
            <td style="width:32%;">
              <fmt:formatDate value="${customer.lastLoginTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
            </td>
          </tr>

        </table>
      </form>
    </div>
    <div class="well center-block" style="left:10px;right:10px;position:fixed;bottom:0px;padding:10px;">
      <c:if test="${audit eq 'true'}"><button type="button" class="btn btn-primary submit">&nbsp;审核通过&nbsp;</button></c:if>
      <button type="button" class="btn btn-warning" onclick="window.close();" style="float:right">&nbsp;&nbsp;关&nbsp;闭&nbsp;&nbsp;</button>
    </div>
  </body>
  <jsp:include page="/WEB-INF/jsp/commons/editfooter.jsp" />
  <c:if test="${audit eq true}">
  <script type="text/javascript" src="${ctx}/js/postbox/expressman/expressman-audit.js<c:if test='${not empty crm}'>?${crm}</c:if>"></script>
  </c:if>
</html>
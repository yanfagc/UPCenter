<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/commons/include.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>编辑用户扩展信息</title>
    <jsp:include page="/WEB-INF/jsp/commons/editheader.jsp" />
  </head>
  <body>
    <nav class="navbar navbar-default navbar-fixed-top" style="min-height:40px;">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="javascript:void(0);" style="height:40px;line-height:8px;">编辑用户扩展信息</a>
        </div>
      </div>
    </nav>
    <div class="container" style="width:100%;margin-top:50px;padding-left:10px;padding-right:10px;">
      <form id="submitForm" class="form-horizontal" action="${ctx}/basic/user/saveExtendUserData" method="POST">
        <input type="hidden" name="id" value="${record.id}"/>
        <table class="table table-bordered table-hover">
          <tr>
            <td style="width:16%;text-align:right;">登录帐号：</td>
            <td style="width:32%;padding:4px;">
              <input name="account" class="form-control input-sm myspan6" disabled="disabled" type="text" placeholder="登录帐号" value="${record.account}">
            </td>
            <td style="width:16%;text-align:right;">显示名称：</td>
            <td style="width:32%;padding:4px;">
              <input name="nickname" class="form-control input-sm myspan6" disabled="disabled" type="text" placeholder="显示名称" value="${record.nickname}">
            </td>
          </tr>
          <tr>
            <td style="width:16%;text-align:right;">帐号状态：</td>
            <td style="width:32%;padding:4px;vertical-align:middle">
              <c:choose>
                <c:when test="${record.status eq 'N'}"><lable style="color:green">正常</lable></c:when>
                <c:when test="${record.status eq 'L'}"><lable style="color:red">锁定</lable></c:when>
                <c:when test="${record.status eq 'F'}"><lable style="color: #f39c12;">冻结</lable></c:when>
                <c:when test="${record.status eq 'D'}"><lable style="color:gray;">注销</lable></c:when>
                <c:otherwise>未知(${record.status})</c:otherwise>
              </c:choose>
            </td>
            <td style="width:16%;text-align:right;">属性表单：</td>
            <td style="width:32%;padding:4px;vertical-align:middle">
              <select id="formid" name="formid" class="form-control input-sm myspan6">
                <option value="">---请选择---</option>
              	<c:forEach items="${formList}" var="form">
                <option value="${form.id}" ${form.id eq formInfo.id?'selected="selected"':''}>${form.formname}</option>
              	</c:forEach>
              </select>
            </td>
          </tr>
          ${formHtml.html}
        </table>
      </form>
      <div style="height:60px;"></div>
      <div class="well center-block">
        <button type="button" class="btn btn-primary submit">&nbsp;&nbsp;保&nbsp;存&nbsp;&nbsp;</button>
        <button type="button" class="btn btn-warning" onclick="window.close();" style="float:right">&nbsp;&nbsp;关&nbsp;闭&nbsp;&nbsp;</button>
      </div>
    </div>
  </body>
  <jsp:include page="/WEB-INF/jsp/commons/editfooter.jsp" />
  <script type="text/javascript" src="${ctx}/js/basic/user/user-props.js<c:if test='${not empty crm}'>?${crm}</c:if>"></script>
</html>
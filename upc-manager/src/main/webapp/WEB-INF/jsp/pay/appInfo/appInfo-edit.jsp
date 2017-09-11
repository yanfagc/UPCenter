<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/commons/include.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>编辑支付应用账号信息</title>
    <jsp:include page="/WEB-INF/jsp/commons/editheader.jsp" />
  </head>
  <body>
    <nav class="navbar navbar-default navbar-fixed-top" style="min-height:40px;">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="javascript:void(0);" style="height:40px;line-height:8px;">编辑支付应用账号信息</a>
        </div>
      </div>
    </nav>
    <div class="container" style="width:100%;margin-top:50px;padding-left:10px;padding-right:10px;">
      <form id="submitForm" class="form-horizontal" action="${ctx}/pay/appInfo/save" method="POST">
        <input type="hidden" name="id" value="${record.appId}"/>
        <table class="table table-bordered table-hover">
          <tr>
            <td style="width:16%;text-align:right;">APP_ID：</td>
            <td style="width:32%;padding:4px;">
              <input name="appId" class="form-control input-sm myspan6" type="text" placeholder="APP_ID编码（建议英文）" value="${record.appId}">
              <input name="oldAppId" class="form-control input-sm myspan6" type="hidden" value="${record.appId}">
            </td>
            <td style="text-align:right;width:16%;">状态：</td>
            <td style="padding:4px;">
              <select name="status" class="form-control input-sm myspan6">
                <c:forEach items="${statusList}" var="status">
                  <option value="${status}" ${record.status eq status?'selected="selected"':''}>${status.remark}</option>
                </c:forEach>
              </select>
            </td>
          </tr>
          <tr>
            <td style="text-align:right;" >APIKEY：</td>
            <td style="padding:4px;" colspan="3">
              <input name="apikey" class="form-control input-sm myspan6" type="text" placeholder="APIKEY编码（建议英文）" value="${record.apikey}">
            </td>
          </tr>
          <tr>
            <td style="text-align:right;" >APP_NAME：</td>
            <td style="padding:4px;" colspan="3">
              <input name="appName" class="form-control input-sm myspan6" type="text" placeholder="APP_NAME" value="${record.appName}">
            </td>
          </tr>
          <tr>
            <td style="text-align:right;" >WHITE_LIST：</td>
            <td style="padding:4px;" colspan="3">
              <input name="whiteList" class="form-control input-sm myspan6" type="text" placeholder="白名单列表" value="${record.whiteList}">
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
  <script src="${ctx}/js/pay/appInfo/appInfo-edit.js<c:if test='${not empty crm}'>?${crm}</c:if>" type="text/javascript"></script>
</html>
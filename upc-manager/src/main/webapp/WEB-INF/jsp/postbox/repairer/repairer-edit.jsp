<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/commons/include.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>编辑维修员信息</title>
    <jsp:include page="/WEB-INF/jsp/commons/editheader.jsp" />
  </head>
  <body>
    <nav class="navbar navbar-default navbar-fixed-top" style="min-height:40px;">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="javascript:void(0);" style="height:40px;line-height:8px;">编辑维修员信息</a>
        </div>
      </div>
    </nav>
    <div class="container" style="width:100%;margin-top:50px;padding-left:10px;padding-right:10px;">
      <form id="submitForm" class="form-horizontal" action="${ctx}/postbox/repairer/save" method="POST">
        <input type="hidden" name="repairerInfoid" value="${record.repairerInfoid}"/>
        <table class="table table-bordered table-hover">
          <tr>
            <td style="width:16%;text-align:right;">维修员姓名：</td>
            <td style="width:32%;padding:4px;">
              <input name="realname" class="form-control input-sm myspan6" type="text" placeholder="维修员姓名" value="${record.realname}">
            </td>
            <td rowspan="3" style="width:16%;text-align:right;">照片：</td>
            <td rowspan="3" style="width:32%;padding:4px;">

            </td>
          </tr>
          <tr>
            <td style="width:16%;text-align:right;">联系方式：</td>
            <td style="width:32%;padding:4px;">
              <input name="mobilePhone" class="form-control input-sm myspan6" type="text" placeholder="联系方式" value="${record.mobilePhone}">
            </td>
          </tr>
          <tr>
            <td style="text-align:right;">状态：</td>
            <td style="padding:4px;">
              <select name="status" class="form-control input-sm myspan6">
              <c:forEach items="${statusList}" var="s">
                <option value="${s}"${record.status eq s?' selected="selected"':''}>${s.remark}</option>
              </c:forEach>
              </select>
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
  <script src="${ctx}/js/postbox/repairer/repairer-edit.js<c:if test='${not empty crm}'>?${crm}</c:if>" type="text/javascript"></script>
</html>
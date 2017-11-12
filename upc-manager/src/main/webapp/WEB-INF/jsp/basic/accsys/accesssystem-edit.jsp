<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/commons/include.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>编辑第三方接入系统信息</title>
    <jsp:include page="/WEB-INF/jsp/commons/editheader.jsp" />
  </head>
  <body>
    <nav class="navbar navbar-default navbar-fixed-top" style="min-height:40px;">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="javascript:void(0);" style="height:40px;line-height:8px;">编辑第三方接入系统信息</a>
        </div>
      </div>
    </nav>
    <div class="container" style="width:100%;margin-top:50px;padding-left:10px;padding-right:10px;">
      <form id="submitForm" class="form-horizontal" action="${ctx}/basic/accesssys/save" method="POST">
        <input type="hidden" name="id" value="${record.id}"/>
        <table class="table table-bordered table-hover">
          <tr>
            <td style="width:16%;text-align:right;">系统编码：</td>
            <td style="width:32%;padding:4px;">
              <input name="syscode" class="form-control input-sm myspan6" type="text" placeholder="系统编码" value="${record.syscode}">
            </td>
            <td style="width:16%;text-align:right;">系统名称：</td>
            <td style="width:32%;padding:4px;">
              <input name="sysname" class="form-control input-sm myspan6" type="text" placeholder="系统名称" value="${record.sysname}">
            </td>
          </tr>
          <tr>
            <td style="text-align:right;">状态：</td>
            <td style="padding:4px;">
              <select name="status" class="form-control input-sm myspan6">
                <c:forEach items="${statusList}" var="status">
                  <option value="${status}" ${record.status eq status?'selected="selected"':''}>${status.remark}</option>
                </c:forEach>
              </select>
            </td>
            <td style="width:16%;text-align:right;">访问地址：</td>
            <td style="width:32%;padding:4px;">
              <input name="sysaddr" class="form-control input-sm myspanAll" type="text" placeholder="访问地址" value="${record.sysaddr}">
            </td>
          </tr>
          <tr>
            <td style="text-align:right;">备注：</td>
            <td style="padding:4px;" colspan="3">
              <textarea name="remark" rows="4" class="form-control myspan6" placeholder="备注">${record.remark}</textarea>
            </td>
          </tr>
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
  <script src="${ctx}/js/basic/accsys/accesssystem-edit.js<c:if test='${not empty crm}'>?${crm}</c:if>" type="text/javascript"></script>
</html>
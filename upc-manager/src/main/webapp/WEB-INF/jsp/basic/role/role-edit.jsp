<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/commons/include.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>编辑角色信息</title>
    <jsp:include page="/WEB-INF/jsp/commons/editheader.jsp" />
  </head>
  <body>
    <nav class="navbar navbar-default navbar-fixed-top" style="min-height:40px;">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="javascript:void(0);" style="height:40px;line-height:8px;">编辑角色信息</a>
        </div>
      </div>
    </nav>
    <div class="container" style="width:100%;margin-top:50px;padding-left:10px;padding-right:10px;">
      <form id="submitForm" class="form-horizontal" action="${ctx}/basic/role/save" method="POST">
        <input type="hidden" name="id" value="${record.id}"/>
        <table class="table table-bordered table-hover">
          <tr>
            <td style="width:16%;text-align:right;">角色编码：</td>
            <td style="width:32%;padding:4px;">
              <input name="rolecode" class="form-control input-sm myspan6" type="text" placeholder="角色编码（建议英文）" value="${record.rolecode}">
            </td>
            <td style="width:16%;text-align:right;">角色名称：</td>
            <td style="width:32%;padding:4px;">
              <input name="rolename" class="form-control input-sm myspan6" type="text" placeholder="角色名称（建议中文）" value="${record.rolename}">
            </td>
          </tr>
          <tr>
            <td style="text-align:right;">角色分组：</td>
            <td style="padding:4px;">
              <select name="groupid" class="form-control input-sm myspan6">
                <option value="">--请选择--</option>
                <c:forEach items="${groupList}" var="group">
                <option value="${group.id}" ${group.id eq record.groupid?'selected="selected"':''}>${group.groupname}</option>
                </c:forEach>
              </select>
            </td>
            <td style="text-align:right;">接入系统：</td>
            <td style="padding:4px;">
              <select name="systemId" class="form-control input-sm myspan6">
                <option value="">--请选择--</option>
                <c:forEach items="${sysList}" var="sys">
                <option value="${sys.id}" ${sys.id eq record.systemId?'selected="selected"':''}>${sys.sysname}</option>
                </c:forEach>
              </select>
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
            <td style="text-align:right;">&nbsp;</td>
            <td style="padding:4px;">&nbsp;</td>
          </tr>
          <tr>
            <td style="text-align:right;">备注：</td>
            <td colspan="3" style="padding:4px;">
              <textarea name="remark" rows="4" class="form-control myspan6" placeholder="备注">${record.remark}</textarea>
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
  <script src="${ctx}/js/basic/role/role-edit.js<c:if test='${not empty crm}'>?${crm}</c:if>" type="text/javascript"></script>
</html>
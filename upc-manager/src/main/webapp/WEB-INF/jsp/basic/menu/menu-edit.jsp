<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/commons/include.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>编辑菜单信息</title>
    <jsp:include page="/WEB-INF/jsp/commons/editheader.jsp" />
  </head>
  <body>
    <nav class="navbar navbar-default navbar-fixed-top" style="min-height:40px;">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="javascript:void(0);" style="height:40px;line-height:8px;">编辑菜单信息</a>
        </div>
      </div>
    </nav>
    <div class="container" style="width:100%;margin-top:50px;padding-left:10px;padding-right:10px;">
      <form id="submitForm" class="form-horizontal" action="${ctx}/basic/menu/save" method="POST">
        <input type="hidden" name="id" value="${record.id}"/>
        <input type="hidden" name="systemId" value="${systemid}"/>
        <input name="parentId" type="hidden" value="${not empty parent?parent.id:'0'}">
        <table class="table table-bordered table-hover">
          <tr>
            <td style="width:16%;text-align:right;">上级菜单：</td>
            <td style="width:32%;padding:4px;">
              <input name="pid" class="form-control input-sm myspan6" type="text" readonly value="${not empty parent?parent.menuname:'无'}">
            </td>
            <td style="width:16%;text-align:right;"><span class="red">&nbsp;*&nbsp;</span>菜单编码：</td>
            <td style="width:32%;padding:4px;">
            <c:if test="${not empty parent}">
              <input name="pmcode" class="form-control input-sm myspan4" type="text" readonly value="${parent.menucode}">
              -
              <input name="menucode" class="form-control input-sm myspan4" type="text" placeholder="子编码" value="${record.menucode}">
            </c:if>
            <c:if test="${empty parent}">
              <input name="menucode" class="form-control input-sm myspan6" type="text" placeholder="菜单编码" value="${record.menucode}">
            </c:if>
            </td>
          </tr>
          <tr>
            <td style="width:16%;text-align:right;"><span class="red">&nbsp;*&nbsp;</span>菜单名称：</td>
            <td style="width:32%;padding:4px;">
              <input name="menuname" class="form-control input-sm myspan6" type="text" placeholder="菜单名称" value="${record.menuname}">
            </td>
            <td style="width:16%;text-align:right;"><span class="red">&nbsp;*&nbsp;</span>状态：</td>
            <td style="padding:4px;">
              <select name="status" class="form-control input-sm myspan6">
                <option value="N" ${record.status eq 'N'?'selected="selected"':''}>正常</option>
                <option value="F" ${record.status eq 'F'?'selected="selected"':''}>冻结</option>
                <option value="D" ${record.status eq 'D'?'selected="selected"':''}>注销</option>
              </select>
            </td>
          </tr>
          <tr>
            <td style="width:16%;text-align:right;"><span class="red">&nbsp;*&nbsp;</span>排序：</td>
            <td style="width:32%;padding:4px;">
              <input name="sort" class="form-control input-sm myspan6" type="text" placeholder="排序（0~999）" value="${record.sort}">
            </td>
            <td style="width:16%;text-align:right;"><span class="red">&nbsp;*&nbsp;</span>菜单类型：</td>
            <td style="width:32%;padding:4px;">
              <select name="urltype" class="form-control input-sm myspan6">
                <option value="M" ${record.urltype eq 'M'?'selected="selected"':''}>菜单目录</option>
                <option value="R" ${record.urltype eq 'R'?'selected="selected"':''}>内部地址</option>
                <option value="A" ${record.urltype eq 'A'?'selected="selected"':''}>外部地址</option>
              </select>
            </td>
          </tr>
          <tr>
            <td style="width:16%;text-align:right;">菜单地址：</td>
            <td colspan="3" style="padding:4px;">
              <input name="menuurl" class="form-control input-sm myspanAll" type="text" placeholder="菜单地址" value="${record.menuurl}">
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
  <script src="${ctx}/js/basic/menu/menu-edit.js<c:if test='${not empty crm}'>?${crm}</c:if>" type="text/javascript"></script>
</html>
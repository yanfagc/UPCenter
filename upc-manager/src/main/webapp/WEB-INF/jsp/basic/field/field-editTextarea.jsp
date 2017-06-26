<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/commons/include.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>编辑多行文本字段</title>
    <jsp:include page="/WEB-INF/jsp/commons/editheader.jsp" />
  </head>
  <body>
    <nav class="navbar navbar-default navbar-fixed-top" style="min-height:40px;">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="javascript:void(0);" style="height:40px;line-height:8px;">编辑多行文本字段</a>
        </div>
      </div>
    </nav>
    <div class="container" style="width:100%;margin-top:50px;padding-left:10px;padding-right:10px;">
      <form id="submitForm" class="form-horizontal" action="${ctx}/basic/field/save" method="POST">
        <input type="hidden" name="fieldtype" value="TEXTAREA"/>
        <input type="hidden" name="id" value="${record.id}"/>
        <table class="table table-bordered table-hover">
          <tr>
            <td style="width:16%;text-align:right;">字段编码：</td>
            <td style="width:32%;padding:4px;">
              <input name="fieldcode" class="form-control input-sm myspan6" type="text" placeholder="字段编码（建议英文）" value="${record.fieldcode}">
            </td>
            <td style="width:16%;text-align:right;">字段名称：</td>
            <td style="width:32%;padding:4px;">
              <input name="fieldname" class="form-control input-sm myspan6" type="text" placeholder="字段编码（建议中文）" value="${record.fieldname}">
            </td>
          </tr>
          <tr>
            <td style="text-align:right;">所占列数：</td>
            <td style="padding:4px;">
              <input name="colspan" class="form-control input-sm myspan6" type="text" placeholder="所占列数" value="${not empty record.colspan?record.colspan:1}">
            </td>
            <td style="text-align:right;">状态：</td>
            <td style="padding:4px;">
              <select name="status" class="form-control input-sm myspan6">
                <option value="N" ${record.status eq 'N'?'selected="selected"':''}>正常</option>
                <option value="F" ${record.status eq 'F'?'selected="selected"':''}>冻结</option>
                <option value="D" ${record.status eq 'D'?'selected="selected"':''}>注销</option>
              </select>
            </td>
          </tr>
          <tr>
            <td style="text-align:right;">默认值：</td>
            <td style="padding:4px;" colspan="3">
              <textarea name="defaultvalue" rows="4" class="form-control myspan6" placeholder="默认值">${record.defaultvalue}</textarea>
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
  <script src="${ctx}/js/basic/field/field-editTextarea.js<c:if test='${not empty crm}'>?${crm}</c:if>" type="text/javascript"></script>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/commons/include.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>编辑数据字典</title>
    <jsp:include page="/WEB-INF/jsp/commons/editheader.jsp" />
  </head>
  <body>
    <nav class="navbar navbar-default navbar-fixed-top" style="min-height:40px;">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="javascript:void(0);" style="height:40px;line-height:8px;">编辑数据字典</a>
        </div>
      </div>
    </nav>
    <div class="container" style="width:100%;margin-top:50px;padding-left:10px;padding-right:10px;">
      <form id="submitForm" class="form-horizontal" action="${ctx}/basic/dictdata/save" method="POST">
        <input type="hidden" name="id" value="${record.id}"/>
        <table class="table table-bordered table-hover">
          <tr>
            <td style="width:16%;text-align:right;">字典编码：</td>
            <td style="width:32%;padding:4px;">
              <input name="datacode" class="form-control input-sm myspan6" type="text" placeholder="字典编码（建议英文）" value="${record.datacode}">
            </td>
            <td style="width:16%;text-align:right;">字典名称：</td>
            <td style="width:32%;padding:4px;">
              <input name="dataname" class="form-control input-sm myspan6" type="text" placeholder="字典名称（建议中文）" value="${record.dataname}">
            </td>
          </tr>
          <tr>
            <td style="text-align:right;">字典类型：</td>
            <td style="padding:4px;">
              <select name="typeId" class="form-control input-sm myspan6">
                <c:forEach items="${typeList}" var="type">
                <option value="${type.id}" ${type.id eq record.typeId?'selected="selected"':''}>${type.typename}</option>
                </c:forEach>
              </select>
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
            <td style="text-align:right;">排序：</td>
            <td style="padding:4px;">
              <input name="sort" class="form-control input-sm myspan6" type="text" placeholder="排序（0~999）" value="${record.sort}">
            </td>
            <td style="text-align:right;">数据类型：</td>
            <td style="padding:4px;">
              <select name="datatype" class="form-control input-sm myspan6">
                <c:forEach items="${datatypeList}" var="item">
                  <option value="${item}" ${item eq record.datatype?'selected="selected"':''}>${item.remark}</option>
                </c:forEach>
              </select>
            </td>
          </tr>
          <tr>
            <td style="text-align:right;">字典值：</td>
            <td id="td_datavalue" style="padding:${record.datatype eq 'N'?'8px':'4px'};" colspan="3">
              <c:choose>
                <c:when test="${record.datatype eq 'N'}">无数据</c:when>
                <c:when test="${record.datatype eq 'B'}">
                  <label class="radio-inline">
                    <input type="radio" name="datavalue" value="Y" ${record.datavalue eq 'Y'?'checked="checked"':''}>是
                  </label>
                  <label class="radio-inline">
                    <input type="radio" name="datavalue" value="N" ${record.datavalue ne 'Y'?'checked="checked"':''}>否
                  </label>
                </c:when>
                <c:when test="${record.datatype eq 'T'}"><input name="datavalue" data-type="text" class="form-control input-sm myspan6" type="text" placeholder="字典值" value="${record.datavalue}"></c:when>
                <c:when test="${record.datatype eq 'I'}"><input name="datavalue" data-type="int" class="form-control input-sm myspan6" type="text" placeholder="字典值" value="${record.datavalue}"></c:when>
                <c:when test="${record.datatype eq 'F'}"><input name="datavalue" data-type="float" class="form-control input-sm myspan6" type="text" placeholder="字典值" value="${record.datavalue}"></c:when>
              </c:choose>
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
  <script src="${ctx}/js/basic/dictdata/dictdata-edit.js<c:if test='${not empty crm}'>?${crm}</c:if>" type="text/javascript"></script>
</html>
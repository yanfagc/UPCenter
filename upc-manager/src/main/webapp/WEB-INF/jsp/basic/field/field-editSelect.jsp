<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/commons/include.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>编辑选择框字段</title>
    <jsp:include page="/WEB-INF/jsp/commons/editheader.jsp" />
  </head>
  <body>
    <nav class="navbar navbar-default navbar-fixed-top" style="min-height:40px;">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="javascript:void(0);" style="height:40px;line-height:8px;">编辑选择框字段</a>
        </div>
      </div>
    </nav>
    <div class="container" style="width:100%;margin-top:50px;padding-left:10px;padding-right:10px;">
      <form id="submitForm" class="form-horizontal" action="${ctx}/basic/field/save" method="POST">
        <input type="hidden" name="fieldtype" value="SELECT"/>
        <input type="hidden" name="id" value="${record.id}"/>
        <input type="hidden" name="defaultvalue" value="${record.defaultvalue}"/>
        <table class="table table-bordered table-hover">
          <tr>
            <td style="width:16%;text-align:right;"><s>*</s>字段编码：</td>
            <td style="width:32%;padding:4px;">
              <input name="fieldcode" class="form-control input-sm myspan6" type="text" placeholder="字段编码（建议英文）" value="${record.fieldcode}">
            </td>
            <td style="width:16%;text-align:right;"><s>*</s>字段名称：</td>
            <td style="width:32%;padding:4px;">
              <input name="fieldname" class="form-control input-sm myspan6" type="text" placeholder="字段名称（建议中文）" value="${record.fieldname}">
            </td>
          </tr>
          <tr>
            <td style="text-align:right;"><s>*</s>所占列数：</td>
            <td style="padding:4px;">
              <input name="colspan" class="form-control input-sm myspan6" type="text" placeholder="所占列数" value="${not empty record.colspan?record.colspan:1}">
            </td>
            <td style="text-align:right;"><s>*</s>状态：</td>
            <td style="padding:4px;">
              <select name="status" class="form-control input-sm myspan6">
                <option value="N" ${record.status eq 'N'?'selected="selected"':''}>正常</option>
                <option value="F" ${record.status eq 'F'?'selected="selected"':''}>冻结</option>
                <option value="D" ${record.status eq 'D'?'selected="selected"':''}>注销</option>
              </select>
            </td>
          </tr>
        </table>
        <table class="table table-bordered table-hover itemstable">
          <thead>
            <tr>
              <th style="width:15%;text-align:center;">排序</th>
              <th style="width:10%;text-align:center;">默认值</th>
              <th style="width:20%;text-align:center;"><s>*</s>实际值</th>
              <th style="width:20%;text-align:center;"><s>*</s>显示值</th>
              <th style="width:10%;text-align:center;">
                <a href="javascript:void(0);" class="btn btn-success btn-xs item-add">添加选项</a>
              </th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${items}" var="item" varStatus="status">
            <tr style="text-align:center;">
              <td style="padding:8px;">
                <a href="javascript:void(0);" class="btn btn-success btn-xs item-up">↑&nbsp;向上</a>&nbsp;
                <a href="javascript:void(0);" class="btn btn-warning btn-xs item-down">↓&nbsp;向下</a>
              </td>
              <td style="padding:8px;">
                <input type="checkbox" value="1" ${item.itemvalue eq record.defaultvalue?'checked="checked"':''}/>
              </td>
              <td style="padding:4px;">
                <input name="itemvalue" class="form-control input-sm myspanAll" value="${item.itemvalue}" type="text" placeholder="实际值"/>
              </td>
              <td style="padding:4px;">
                <input name="itemname" class="form-control input-sm myspanAll" value="${item.itemname}" type="text" placeholder="显示值"/>
              </td>
              <td style="padding:8px;">
                <a href="javascript:void(0);" class="btn btn-warning btn-xs item-remove">X&nbsp;删除</a>
              </td>
            </tr>
            </c:forEach>
          </tbody>
        </table>
      </form>
      <div style="height:60px;"></div>
      <div class="well center-block" style="left:10px;right:10px;bottom:0px;padding:10px;position:fixed;margin-bottom:10px;">
        <button type="button" class="btn btn-primary submit">&nbsp;&nbsp;保&nbsp;存&nbsp;&nbsp;</button>
        <button type="button" class="btn btn-warning" onclick="window.close();" style="float:right">&nbsp;&nbsp;关&nbsp;闭&nbsp;&nbsp;</button>
      </div>
    </div>
  </body>
  <jsp:include page="/WEB-INF/jsp/commons/editfooter.jsp" />
  <script src="${ctx}/js/basic/field/field-editSelect.js<c:if test='${not empty crm}'>?${crm}</c:if>" type="text/javascript"></script>
</html>
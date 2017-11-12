<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/commons/include.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>编辑单行文本字段规则</title>
    <jsp:include page="/WEB-INF/jsp/commons/editheader.jsp" />
  </head>
  <body>
    <nav class="navbar navbar-default navbar-fixed-top" style="min-height:40px;">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="javascript:void(0);" style="height:40px;line-height:8px;">编辑单行文本字段规则</a>
        </div>
      </div>
    </nav>
    <div class="container" style="width:100%;margin-top:50px;padding-left:10px;padding-right:10px;">
      <form id="submitForm" class="form-horizontal" action="${ctx}/basic/field/saveFieldRule" method="POST">
        <input type="hidden" name="fieldtype" value="INPUT"/>
        <input type="hidden" name="id" value="${record.id}"/>
        <table class="table table-bordered table-hover">
          <tr>
            <td style="width:16%;text-align:right;"><s>*</s>字段编码：</td>
            <td style="width:32%;padding:4px;">
              <input name="fieldcode" class="form-control input-sm myspan6" readonly="readonly" type="text" value="${record.fieldcode}">
            </td>
            <td style="width:16%;text-align:right;"><s>*</s>字段名称：</td>
            <td style="width:32%;padding:4px;">
              <input name="fieldname" class="form-control input-sm myspan6" readonly="readonly" type="text" value="${record.fieldname}">
            </td>
          </tr>
          <!-- 普通文本规则 -->
          <c:if test="${record.macrotype eq 'TEXT'}">
          <tr>
            <td style="text-align:right;"><s>*</s>是否必填：</td>
            <td style="padding:4px;">
              <label class="radio-inline">
                <input type="radio" name="required" value="Y" ${record.required eq 'Y'?'checked="checked"':''}/> 是
              </label>
              <label class="radio-inline">
                <input type="radio" name="required" value="N" ${record.required ne 'Y'?'checked="checked"':''}> 否
              </label>
            </td>
            <td style="text-align:right;"><s>*</s>长度类型：</td>
            <td style="padding:4px;">
              <select name="lengthtype" class="form-control input-sm myspan6">
                <option value="CHAR" ${record.lengthtype eq 'CHAR'?'selected="selected"':''}>字符(char)</option>
                <option value="BYTE" ${record.lengthtype eq 'BYTE'?'selected="selected"':''}>字节(byte)</option>
                <option value="DBLB" ${record.lengthtype eq 'DBLB'?'selected="selected"':''}>双字节(double bytes)</option>
              </select>
            </td>
          </tr>
          <tr>
            <td style="text-align:right;">最小长度：</td>
            <td style="padding:4px;">
              <input name="minlength" class="form-control input-sm myspan6" placeholder="最小长度" type="text" value="${record.minlength}">
            </td>
            <td style="text-align:right;">最大长度：</td>
            <td style="padding:4px;">
              <input name="maxlength" class="form-control input-sm myspan6" placeholder="最大长度" type="text" value="${record.maxlength}">
            </td>
          </tr>
          <tr>
            <td style="text-align:right;">最小值：</td>
            <td style="padding:4px;">
              <input name="minval" class="form-control input-sm myspan6" placeholder="最小值" type="text" value="${record.minval}">
            </td>
            <td style="text-align:right;">最大值：</td>
            <td style="padding:4px;">
              <input name="maxval" class="form-control input-sm myspan6" placeholder="最大值" type="text" value="${record.maxval}">
            </td>
          </tr>
          <tr>
            <td style="text-align:right;">最小对比字段：</td>
            <td style="padding:4px;">
              <input type="hidden" name="minlimit" value="${record.minlimit}"/>
              <input for="minlimit" class="form-control input-sm myspan6" placeholder="最小对比字段" type="text" value="${minlimit.fieldname}">
            </td>
            <td style="text-align:right;">最大对比字段：</td>
            <td style="padding:4px;">
              <input type="hidden" name="maxlimit" value="${record.maxlimit}"/>
              <input for="maxlimit" class="form-control input-sm myspan6" placeholder="最大对比字段" type="text" value="${maxlimit.fieldname}">
            </td>
          </tr>
          <tr>
            <td style="text-align:right;">正则表达式：</td>
            <td style="padding:4px;" colspan="3">
              <input name="regular" class="form-control input-sm myspan6" placeholder="正则表达式" type="text" value="${record.regular}">
            </td>
          </tr>
          </c:if>
        </table>
      </form>
    </div>
    <div class="well center-block" style="left:10px;right:10px;position:fixed;bottom:0px;padding:10px;">
      <button type="button" class="btn btn-primary submit">&nbsp;&nbsp;保&nbsp;存&nbsp;&nbsp;</button>
      <button type="button" class="btn btn-warning" onclick="window.close();" style="float:right">&nbsp;&nbsp;关&nbsp;闭&nbsp;&nbsp;</button>
    </div>
  </body>
  <jsp:include page="/WEB-INF/jsp/commons/editfooter.jsp" />
  <script src="${ctx}/js/jquery.myautocomplete.js<c:if test='${not empty crm}'>?${crm}</c:if>"  type="text/javascript"></script>
  <script src="${ctx}/js/basic/field/rules/field-editTextRule.js<c:if test='${not empty crm}'>?${crm}</c:if>" type="text/javascript"></script>
</html>
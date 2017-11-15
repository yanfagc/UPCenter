<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/commons/include.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>编辑宏控件字段规则</title>
    <jsp:include page="/WEB-INF/jsp/commons/editheader.jsp" />
  </head>
  <body>
    <nav class="navbar navbar-default navbar-fixed-top" style="min-height:40px;">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="javascript:void(0);" style="height:40px;line-height:8px;">编辑宏控件字段规则</a>
        </div>
      </div>
    </nav>
    <div class="container" style="width:100%;margin-top:50px;padding-left:10px;padding-right:10px;">
      <form id="submitForm" class="form-horizontal" action="${ctx}/basic/field/saveFieldRule" method="POST">
        <input type="hidden" name="fieldtype" value="INPUT"/>
        <input type="hidden" name="id" value="${record.id}"/>
        <input type="hidden" name="macrotype" value="${record.macrotype}"/>
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
          <c:if test="${record.macrotype eq 'DATE' or record.macrotype eq 'TIME' or record.macrotype eq 'DATETIME'}">
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
            <td colspan="2"></td>
          </tr>
          <tr>
            <td style="text-align:right;">最小值：</td>
            <td style="padding:4px;">
              <label class="radio-inline">
                <input type="radio" name="minval_radio" value="N" ${(empty record.minval or record.minval eq 'N')?'checked="checked"':''}/> 无
              </label>
              <label class="radio-inline">
                <input type="radio" name="minval_radio" value="W" ${record.minval eq 'W'?'checked="checked"':''}> 当前时间
              </label>
              <label class="radio-inline">
                <input type="radio" name="minval_radio" value="S" ${(not empty record.minval and record.minval ne 'N' and record.minval ne 'W')?'checked="checked"':''}> 指定时间
              </label>
              <input type="hidden" name="minval" value="${record.minval}"/>
            </td>
            <td id="minval_td" colspan="2" style="padding:4px;">
              <c:if test="${not empty record.minval and record.minval ne 'N' and record.minval ne 'W'}">
                <c:if test="${record.macrotype eq 'DATE'}">
                <input name="minval_show" class="form-control Wdate input-sm myspan6" readonly="readonly" type="text" value="${record.minval}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})">
                </c:if>
                <c:if test="${record.macrotype eq 'TIME'}">
                  <input name="minval_show" class="form-control Wdate input-sm myspan6" readonly="readonly" type="text" value="${record.minval}" onclick="WdatePicker({dateFmt:'HH:mm:ss'})">
                </c:if>
                <c:if test="${record.macrotype eq 'DATETIME'}">
                  <input name="minval_show" class="form-control Wdate input-sm myspan6" readonly="readonly" type="text" value="${record.minval}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})">
                </c:if>
              </c:if>
            </td>
          </tr>
          <tr>
            <td style="text-align:right;">最大值：</td>
            <td style="padding:4px;">
              <label class="radio-inline">
                <input type="radio" name="maxval_radio" value="N" ${(empty record.maxval or record.maxval eq 'N')?'checked="checked"':''}/> 无
              </label>
              <label class="radio-inline">
                <input type="radio" name="maxval_radio" value="W" ${record.maxval eq 'W'?'checked="checked"':''}> 当前时间
              </label>
              <label class="radio-inline">
                <input type="radio" name="maxval_radio" value="S" ${(not empty record.maxval and record.maxval ne 'N' and record.maxval ne 'W')?'checked="checked"':''}> 指定时间
              </label>
              <input type="hidden" name="maxval" value="${record.maxval}"/>
            </td>
            <td id="maxval_td" colspan="2" style="padding:4px;">
              <c:if test="${not empty record.maxval and record.maxval ne 'N' and record.maxval ne 'W'}">
                <c:if test="${record.macrotype eq 'DATE'}">
                <input name="maxval_show" class="form-control Wdate input-sm myspan6" readonly="readonly" type="text" value="${record.maxval}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})">
                </c:if>
                <c:if test="${record.macrotype eq 'TIME'}">
                  <input name="maxval_show" class="form-control Wdate input-sm myspan6" readonly="readonly" type="text" value="${record.maxval}" onclick="WdatePicker({dateFmt:'HH:mm:ss'})">
                </c:if>
                <c:if test="${record.macrotype eq 'DATETIME'}">
                  <input name="maxval_show" class="form-control Wdate input-sm myspan6" readonly="readonly" type="text" value="${record.maxval}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})">
                </c:if>
              </c:if>
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
          </c:if>
          <c:if test="${record.macrotype ne 'DATE' and record.macrotype ne 'TIME' and record.macrotype ne 'DATETIME'}">
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
            <td colspan="2"></td>
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
  <script src="${ctx}/js/basic/field/rules/field-editMacrosRule.js<c:if test='${not empty crm}'>?${crm}</c:if>" type="text/javascript"></script>
</html>
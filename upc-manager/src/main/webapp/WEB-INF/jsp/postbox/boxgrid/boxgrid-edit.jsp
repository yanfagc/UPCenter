<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/commons/include.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>编辑快递格子信息</title>
    <jsp:include page="/WEB-INF/jsp/commons/editheader.jsp" />
  </head>
  <body>
    <nav class="navbar navbar-default navbar-fixed-top" style="min-height:40px;">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="javascript:void(0);" style="height:40px;line-height:8px;">编辑快递格子信息</a>
        </div>
      </div>
    </nav>
    <div class="container" style="width:100%;margin-top:50px;padding-left:10px;padding-right:10px;">
      <form id="submitForm" class="form-horizontal" action="${ctx}/postbox/boxgrid/save" method="POST">
        <input type="hidden" name="boxGridId" value="${record.boxGridId}"/>
        <table class="table table-bordered table-hover">
          <tr>
            <td style="width:16%;text-align:right;">箱子ID：</td>
            <td style="width:32%;padding:4px;">
              <input name="boxInfoId" class="form-control input-sm myspan6" type="text" placeholder="箱子ID" value="${boxInfoId}" readonly="readonly">
            </td>
            <td style="text-align:right;">格子编号：</td>
            <td style="width:32%;padding:4px;">
              <input name="gridCode" class="form-control input-sm myspan6" type="text" placeholder="格子编号" value="${record.gridCode}">
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
            <td style="text-align:right;">快件状态：</td>
            <td style="padding:4px;">
              <select name="status" class="form-control input-sm myspan6">
                <c:forEach items="${boxExpressStatus}" var="s">
                  <option value="${s}"${record.expressStatus eq s?' selected="selected"':''}>${s.remark}</option>
                </c:forEach>
              </select>
            </td>
          </tr>
          <tr>
            <td style="text-align:right;">格子大小：</td>
            <td style="padding:4px;">
              <select name="status" class="form-control input-sm myspan6">
                <c:forEach items="${gridSize}" var="s">
                  <option value="${s}"${record.gridSize eq s?' selected="selected"':''}>${s.remark}</option>
                </c:forEach>
              </select>
            </td>
            <td style="width:16%;text-align:right;">排序值：</td>
            <td style="width:32%;padding:4px;">
              <input name="sort" class="form-control input-sm myspan6" type="text" placeholder="排序值" value="${record.sort}">
            </td>
          </tr>
          <tr>
            <td style="width:16%;text-align:right;">隶属手机号：</td>
            <td style="width:32%;padding:4px;">
              <input name="mobilePhone" class="form-control input-sm myspan6" type="text" placeholder="隶属手机号" value="${record.mobilePhone}">
            </td>
            <td style="width:16%;text-align:right;">代领人：</td>
            <td style="width:32%;padding:4px;">
              <input name="proxyCustomerInfoId" class="form-control input-sm myspan6" type="text" placeholder="代领人" value="${record.proxyCustomerInfoId}">
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
  <script src="${ctx}/js/jquery.myautocomplete.js<c:if test='${not empty crm}'>?${crm}</c:if>" type="text/javascript"></script>
  <script src="${ctx}/js/postbox/boxinfo/boxinfo-edit.js<c:if test='${not empty crm}'>?${crm}</c:if>" type="text/javascript"></script>
</html>
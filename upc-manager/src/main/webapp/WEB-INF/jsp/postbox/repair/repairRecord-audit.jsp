<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/commons/include.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>报修记录详情</title>
    <jsp:include page="/WEB-INF/jsp/commons/editheader.jsp" />
  </head>
  <body>
    <nav class="navbar navbar-default navbar-fixed-top" style="min-height:40px;">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="javascript:void(0);" style="height:40px;line-height:8px;">报修记录详情</a>
        </div>
      </div>
    </nav>
    <div class="container" style="width:100%;margin-top:50px;padding-left:10px;padding-right:10px;">
      <form id="submitForm" class="form-horizontal">
        <table class="table table-bordered table-hover">
          <tr>
            <td style="width:16%;text-align:right;">国家：</td>
            <td style="width:32%;">中国</td>
            <td style="width:16%;text-align:right;">省份/直辖市：</td>
            <td style="width:32%;">
              ${group.province}
            </td>
          </tr>
          <tr>
            <td style="width:16%;text-align:right;">城市/地区：</td>
            <td style="width:32%;">
              ${group.city}
            </td>
            <td style="width:16%;text-align:right;">所属箱子组：</td>
            <td style="width:32%;">
              ${group.groupName}
            </td>
          </tr>
          <tr>
            <td style="width:16%;text-align:right;">内部编码：</td>
            <td style="width:32%;">
              ${boxInfo.boxUniqueCode}
            </td>
            <td style="width:16%;text-align:right;">箱子编码：</td>
            <td style="width:32%;">
              ${boxInfo.boxCode}
            </td>
          </tr>
          <tr>
            <td style="width:16%;text-align:right;">状态：</td>
            <td style="width:32%;">${record.status.remark}</td>
            <td style="width:16%;text-align:right;">报修时间：</td>
            <td style="width:32%;">
              <fmt:formatDate value="${record.applytime}" pattern="yyyy-MM-dd HH:mm:ss"/>
            </td>
          </tr>
        </table>
        <table id="dataList" class="table table-bordered table-hover">
          <thead>
            <tr>
              <th class="text-center" style="width:18%">处理类型</th>
              <th class="text-center" style="width:18%">处理人</th>
              <th class="text-center" style="width:25%">处理时间</th>
              <th class="text-center" style="width:39%">备注</th>
            </tr>
          </thead>
          <tbody>
            <c:if test="${empty stepList or stepList.size() lt 1}">
              <tr>
                <td colspan="4">没有符合条件的数据...</td>
              </tr>
            </c:if>
            <c:if test="${not empty stepList and stepList.size() gt 0}">
              <c:forEach items="${stepList}" var="step">
                <tr>
                  <td style="text-align:center;">${step.optype.remark}</td>
                  <td>${step.opstaffname}</td>
                  <td style="text-align:center;"><fmt:formatDate value="${step.optime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                  <td>${step.remark}</td>
                </tr>
              </c:forEach>
            </c:if>
          </tbody>
        </table>
      </form>
    </div>
    <div class="well center-block" style="left:10px;right:10px;position:fixed;bottom:0px;padding:10px;">
      <c:if test="${record.status eq 'CHECKING'}">
        <button type="button" class="btn btn-success successBtn">审核通过</button>
        <button type="button" class="btn btn-danger successBtn">审核不通过</button>
      </c:if>
      <button type="button" class="btn btn-warning" onclick="window.close();" style="float:right">&nbsp;&nbsp;关&nbsp;闭&nbsp;&nbsp;</button>
    </div>
  </body>
  <jsp:include page="/WEB-INF/jsp/commons/editfooter.jsp" />
</html>
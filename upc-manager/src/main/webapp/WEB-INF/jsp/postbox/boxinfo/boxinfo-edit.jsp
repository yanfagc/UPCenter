<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/commons/include.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>编辑箱子信息</title>
    <jsp:include page="/WEB-INF/jsp/commons/editheader.jsp" />
  </head>
  <body>
    <nav class="navbar navbar-default navbar-fixed-top" style="min-height:40px;">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="javascript:void(0);" style="height:40px;line-height:8px;">编辑箱子信息</a>
        </div>
      </div>
    </nav>
    <div class="container" style="width:100%;margin-top:50px;padding-left:10px;padding-right:10px;">
      <form id="submitForm" class="form-horizontal" action="${ctx}/postbox/boxgroup/save" method="POST">
        <input type="hidden" name="boxGroupId" value="${record.boxGroupId}"/>
        <table class="table table-bordered table-hover">
          <tr>
            <td style="width:16%;text-align:right;">内部编码（唯一）：</td>
            <td style="width:32%;padding:4px;">
              <input name="groupCode" class="form-control input-sm myspan6" type="text" placeholder="箱子组编码" value="${record.groupCode}">
            </td>
            <td style="width:16%;text-align:right;">箱子编码：</td>
            <td style="width:32%;padding:4px;">
              <input name="groupName" class="form-control input-sm myspan6" type="text" placeholder="箱子组名称" value="${record.groupName}">
            </td>
          </tr>
          <tr>
            <td style="text-align:right;">国家：</td>
            <td style="padding:4px;">
              <select name="country" class="form-control input-sm myspan6">
                <option value="中国" area-node="0">中国</option>
              </select>
            </td>
            <td style="text-align:right;">省份/直辖市：</td>
            <td style="padding:4px;">
              <select name="province" class="form-control input-sm myspan6">
                <option value="" area-node=""> --- 选择省份 --- </option>
                <c:forEach items="${provinceList}" var="province">
                  <option value="${province.name}" area-node="${province.node}" ${province.name eq record.province?'selected="selected"':''}>${province.name}</option>
                </c:forEach>
              </select>
            </td>
          </tr>
          <tr>
            <td style="text-align:right;">城市/地区：</td>
            <td style="padding:4px;">
              <select name="city" class="form-control input-sm myspan6">
                <option value="" area-node=""> --- 选择城市 --- </option>
                <c:forEach items="${cityList}" var="city">
                  <option value="${city.name}" area-node="${city.node}" ${city.name eq record.city?'selected="selected"':''}>${city.name}</option>
                </c:forEach>
              </select>
            </td>
            <td style="text-align:right;">所属箱子组：</td>
            <td style="width:32%;padding:4px;">
              <input name="groupName" class="form-control input-sm myspan6" type="text" placeholder="所属箱子组" value="${record.groupName}">
              <input name="boxGroupId" type="hidden" value="${record.boxGroupId}"/>
            </td>
          </tr>
          <tr>
            <td style="width:16%;text-align:right;">经纬坐标：</td>
            <td style="width:32%;padding:4px;">
              <input name="longitude" class="form-control input-sm myspan4" type="text" placeholder="经度" value="${record.longitude}">
              ×
              <input name="latitude" class="form-control input-sm myspan4" type="text" placeholder="纬度" value="${record.latitude}">
            </td>
            <td style="text-align:right;">加密密钥：</td>
            <td style="width:32%;padding:4px;">
              <input name="groupName" class="form-control input-sm myspan6" type="text" placeholder="所属箱子组" value="${record.groupName}">
              <input name="boxGroupId" type="hidden" value="${record.boxGroupId}"/>
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
                <c:forEach items="${statusList}" var="s">
                  <option value="${s}"${record.status eq s?' selected="selected"':''}>${s.remark}</option>
                </c:forEach>
              </select>
            </td>
          </tr>
          <tr>
            <td style="text-align:right;">快件隶属手机号：</td>
            <td style="width:32%;padding:4px;">
              <input name="mobilePhone" class="form-control input-sm myspan6" type="text" placeholder="快件隶属手机号" value="${record.mobilePhone}">
            </td>
            <td style="width:16%;text-align:right;">校验数值：</td>
            <td style="width:32%;padding:4px;">
              <input name="checknum" class="form-control input-sm myspan6" type="text" placeholder="校验数值" value="${record.checknum}">
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
  <script src="${ctx}/js/postbox/boxgroup/boxgroup-edit.js<c:if test='${not empty crm}'>?${crm}</c:if>" type="text/javascript"></script>
</html>
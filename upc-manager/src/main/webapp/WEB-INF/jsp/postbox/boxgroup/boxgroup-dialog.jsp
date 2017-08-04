<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/commons/include.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>选择箱子组</title>
    <jsp:include page="/WEB-INF/jsp/commons/metaheader.jsp" />
    <link href="${ctx}/css/list.css" rel="stylesheet" type="text/css" />
  </head>
  <body class="skin-blue sidebar-mini">
    <nav class="navbar navbar-default navbar-fixed-top" style="min-height:40px;">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="javascript:void(0);" style="height:40px;line-height:8px;">选择箱子组</a>
        </div>
      </div>
    </nav>
    <div class="container" style="width:100%;margin-top:50px;padding-left:10px;padding-right:10px;">
      <input type="hidden" id="checkedId" value="${checkedId}">
      <form class="form-inline legend">
        <div class="form-group">
          <label class="sr-only" for="groupName">箱子组名称</label>
          <input type="text" class="form-control" id="groupName" placeholder="箱子组名称"/>
        </div>
        <div class="form-group">
          <label class="sr-only" for="province">省份/直辖市</label>
          <select id="province" name="province" class="form-control">
            <option value=""> --- 选择省份/直辖市 --- </option>
            <c:forEach items="${provinceList}" var="p">
              <option value="${p.name}" area-node="${p.node}" ${p.name eq province?'selected="selected"':''}>${p.name}</option>
            </c:forEach>
          </select>
        </div>
        <div class="form-group">
          <label class="sr-only" for="city">城市</label>
          <select id="city" name="city" class="form-control">
            <option value=""> --- 选择城市/地区 --- </option>
            <c:forEach items="${cityList}" var="c">
              <option value="${c.name}" area-node="${c.node}" ${c.name eq city?'selected="selected"':''}>${c.name}</option>
            </c:forEach>
          </select>
        </div>
        <div class="form-group">
          <label class="sr-only" for="status">状态</label>
          <select id="status" class="form-control">
            <option value=""> --- 选择状态 --- </option>
            <c:forEach items="${statusList}" var="s">
              <option value="${s}">${s.remark}</option>
            </c:forEach>
          </select>
        </div>
        <button type="button" class="btn btn-primary search">&nbsp;&nbsp;搜索&nbsp;&nbsp;</button>
        <button type="reset" class="btn btn-warning reset">&nbsp;&nbsp;重置&nbsp;&nbsp;</button>
      </form>
      <table id="dataList" class="table table-bordered table-hover">
        <thead>
        <tr>
          <th style="width:5%"></th>
          <th style="width:18%">箱子组编码</th>
          <th style="width:32%">箱子组名称</th>
          <th style="width:32%">所在地区</th>
          <th style="width:12%">状态</th>
        </tr>
        </thead>
        <tbody></tbody>
      </table>
    </div>
    <div class="well center-block" style="left:10px;right:10px;position:fixed;bottom:0px;padding:10px;">
      <button id="okBtn" type="button" class="btn btn-primary">&nbsp;&nbsp;确&nbsp;定&nbsp;&nbsp;</button>
      <button type="button" class="btn btn-warning" onclick="window.close();" style="float:right">&nbsp;&nbsp;关&nbsp;闭&nbsp;&nbsp;</button>
    </div>

    <jsp:include page="/WEB-INF/jsp/commons/metafooter.jsp" />
    <script src="${ctx}/js/jquery.myautocomplete.js<c:if test='${not empty crm}'>?${crm}</c:if>" type="text/javascript"></script>
    <script type="text/javascript" src="${ctx}/js/postbox/boxgroup/boxgroup-dialog.js<c:if test='${not empty crm}'>?${crm}</c:if>"></script>
  </body>
</html>

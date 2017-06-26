<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/commons/include.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>角色权限设置</title>
    <jsp:include page="/WEB-INF/jsp/commons/editheader.jsp" />
    <link href="${ctx}/plugins/ztree_v3/css/zTreeStyle.css" rel="stylesheet" type="text/css" />
  </head>
  <body>
    <nav class="navbar navbar-default navbar-fixed-top" style="min-height:40px;">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="javascript:void(0);" style="height:40px;line-height:8px;">角色权限设置</a>
        </div>
      </div>
    </nav>
    <div class="container" style="width:100%;margin-top:50px;padding-left:10px;padding-right:10px;">
      <div class="row">
        <div class="col-xs-2">
          <ul id="menuTree" class="ztree"></ul>
        </div>
      </div>
    </div>
  </body>
  <jsp:include page="/WEB-INF/jsp/commons/editfooter.jsp" />
  <script type="text/javascript">var zNodes=${nodeList};</script>
  <script type="text/javascript" src="${ctx}/plugins/ztree_v3/js/jquery.ztree.all.js"></script>
  <script src="${ctx}/js/basic/role/role-setting.js<c:if test='${not empty crm}'>?${crm}</c:if>" type="text/javascript"></script>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/commons/include.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>快递格子管理</title>
    <jsp:include page="/WEB-INF/jsp/commons/metaheader.jsp" />
    <link href="${ctx}/css/list.css" rel="stylesheet" type="text/css" />
    <style>
      .form-control[readonly]{
        background-color:#fff
      }
    </style>
  </head>
  <body class="skin-blue sidebar-mini">
  <div id="content" style="background-color:#ecf0f5">
    <section class="content-header">
      <h1><small>单元柜管理 &gt; 箱子管理 &gt; 快递格子管理</small></h1>
    </section>
  <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-xs-12">
          <div class="box">
            <div class="box-header">
              <form class="form-inline legend">
                <input type="hidden" name="boxInfoId" value="${param.boxInfoId}"/>
                <div class="form-group">
                  <label class="sr-only" for="gridCode">格子编码</label>
                  <input type="text" class="form-control" id="gridCode" placeholder="格子编码"/>
                </div>
                <button type="button" class="btn btn-primary search">&nbsp;&nbsp;搜索&nbsp;&nbsp;</button>
                <button type="reset" class="btn btn-warning reset">&nbsp;&nbsp;重置&nbsp;&nbsp;</button>
              </form>
              <!-- <div class="btn-group"> -->
                <button class="btn btn-info add-btn">&nbsp;&nbsp;新增&nbsp;&nbsp;</button>
              <!-- </div> -->
            </div><!-- /.box-header -->
            <div class="box-body">
              <table id="dataList" class="table table-bordered table-hover">
                <thead>
                  <tr>
                    <th style="width:10%">箱子ID</th>
                    <th style="width:10%">格子编码</th>
                    <th style="width:10%">基本状态</th>
                    <th style="width:10%">快递状态</th>
                    <th style="width:12%">格子大小</th>
                    <th style="width:10%">隶属手机号</th>
                    <th style="width:12%">代领人</th>
                    <th style="width:12%">上次开启时间</th>
                    <th style="width:15%">操作</th>
                  </tr>
                </thead>
                <tbody></tbody>
              </table>
            </div><!-- /.box-body -->
          </div><!-- /.box -->
        </div><!-- /.col -->
      </div><!-- /.row -->
    </section><!-- /.content -->
</div>
    <jsp:include page="/WEB-INF/jsp/commons/metafooter.jsp" />
    <script type="text/javascript" src="${ctx}/js/postbox/boxgrid/boxgrid-list.js<c:if test='${not empty crm}'>?${crm}</c:if>"></script>
  </body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/commons/include.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>维修员管理</title>
    <jsp:include page="/WEB-INF/jsp/commons/metaheader.jsp" />
    <link href="${ctx}/css/list.css" rel="stylesheet" type="text/css" />
  </head>
  <body class="skin-blue sidebar-mini">
  <div id="content" style="background-color:#ecf0f5">
    <section class="content-header">
      <h1><small>单元柜管理 &gt; 维修员管理</small></h1>
    </section>
  <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-xs-12">
          <div class="box">
            <div class="box-header">
              <form class="form-inline legend">
                <div class="form-group">
                  <label class="sr-only" for="realname">维修员姓名</label>
                    <input type="text" class="form-control" id="realname" placeholder="维修员姓名"/>
                </div>
                <div class="form-group">
                  <label class="sr-only" for="mobilePhone">联系方式</label>
                  <input type="text" class="form-control" id="mobilePhone" placeholder="联系方式"/>
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
              <!-- <div class="btn-group"> -->
                <button class="btn btn-info add-btn">&nbsp;&nbsp;新增&nbsp;&nbsp;</button>
              <!-- </div> -->
            </div><!-- /.box-header -->
            <div class="box-body">
              <table id="dataList" class="table table-bordered table-hover">
                <thead>
                  <tr>
                    <th style="width:20%">维修员姓名</th>
                    <th style="width:20%">联系方式</th>
                    <th style="width:15%">状态</th>
                    <th style="width:20%">创建时间</th>
                    <th style="width:25%">操作</th>
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
    <script type="text/javascript" src="${ctx}/js/postbox/repairer/repairer-list.js<c:if test='${not empty crm}'>?${crm}</c:if>"></script>
  </body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/commons/include.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>表单字段维护</title>
    <jsp:include page="/WEB-INF/jsp/commons/metaheader.jsp" />
    <link href="${ctx}/css/list.css" rel="stylesheet" type="text/css" />
  </head>
  <body class="skin-blue sidebar-mini">
  <div id="content" style="background-color:#ecf0f5">
    <section class="content-header">
      <h1><small>表单管理 &gt;&nbsp;<a href="${ctx}/basic/form/list">表单维护</a> &gt;&nbsp;表单字段维护</small></h1>
    </section>
  <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-xs-12">
          <div class="box">
            <div class="box-header">
              <form class="form-inline legend">
              	<input id="formid" type="hidden" value="${form.id}"/>
                <div class="form-group">
                  <label for="formcode">表单编码：</label>
                  ${form.formcode}
                </div>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <div class="form-group">
                  <label for="formname">表单名称：</label>
                  ${form.formname}
                </div>
              </form>
              <!-- <div class="btn-group"> -->
                <button class="btn btn-info add-btn">&nbsp;&nbsp;添加&nbsp;&nbsp;</button>
              <!-- </div> -->
            </div><!-- /.box-header -->
            <div class="box-body">
              <table id="dataList" class="table table-bordered table-hover">
                <thead>
                  <tr>
                    <th style="width:20%">字段编码</th>
                    <th style="width:20%">字段名称</th>
                    <th style="width:15%">状态</th>
                    <th style="width:15%">所占列数</th>
                    <th style="width:15%">排序</th>
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
    <script type="text/javascript" src="${ctx}/js/basic/form/formfield-list.js<c:if test='${not empty crm}'>?${crm}</c:if>"></script>
  </body>
</html>

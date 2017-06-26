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
  <nav class="navbar navbar-default navbar-fixed-top" style="min-height:40px;">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="javascript:void(0);" style="height:40px;line-height:8px;">编辑表单信息</a>
        </div>
      </div>
  </nav>
  <div class="row" style="margin-top:35px;">
    <div class="col-xs-12">
      <div class="box">
        <div class="box-header">
          <form id="submitForm" class="form-inline legend" method="POST" action="${ctx}/basic/form/addFormField">
          	<input name="formid" id="formid" type="hidden" value="${formid}"/>
          	<input name="fieldid" id="fieldid" type="hidden" value=""/>
          	<input name="colspan" id="colspan" type="hidden" value=""/>
            <div class="form-group">
              <label class="sr-only" for="fieldcode">字段编码</label>
                <input type="text" class="form-control" id="fieldcode" placeholder="字段编码"/>
            </div>
            <div class="form-group">
              <label class="sr-only" for="fieldname">字段名称</label>
                <input type="text" class="form-control" id="fieldname" placeholder="字段名称"/>
            </div>
            <button type="button" class="btn btn-primary search">&nbsp;&nbsp;搜索&nbsp;&nbsp;</button>
            <button type="reset" class="btn btn-warning reset">&nbsp;&nbsp;重置&nbsp;&nbsp;</button>
          </form>
        </div><!-- /.box-header -->
        <div class="box-body">
          <table id="dataList" class="table table-bordered table-hover">
            <thead>
              <tr>
                <th class="text-center" style="width:10px"></th>
                <th class="text-center" style="width:30%">字段编码</th>
                <th class="text-center" style="width:30%">字段名称</th>
                <th class="text-center" style="width:30%">所占列数</th>
              </tr>
            </thead>
            <tbody></tbody>
          </table>
        </div><!-- /.box-body -->
      </div><!-- /.box -->
    </div><!-- /.col -->
  </div><!-- /.row -->
    <div class="well center-block" style="left:10px;right:10px;position:fixed;bottom:0px;padding:10px;">
      <button type="button" class="btn btn-primary submit">&nbsp;&nbsp;保&nbsp;存&nbsp;&nbsp;</button>
      <button type="button" class="btn btn-warning" onclick="window.close();" style="float:right">&nbsp;&nbsp;关&nbsp;闭&nbsp;&nbsp;</button>
    </div>
    <jsp:include page="/WEB-INF/jsp/commons/metafooter.jsp" />
    <script src="${ctx}/plugins/jquery/jquery.form.js" type="text/javascript"></script>
    <script type="text/javascript" src="${ctx}/js/basic/form/formfield-add.js<c:if test='${not empty crm}'>?${crm}</c:if>"></script>
  </body>
</html>

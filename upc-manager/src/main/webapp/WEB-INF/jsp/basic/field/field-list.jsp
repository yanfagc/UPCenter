<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/commons/include.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>字段维护</title>
    <jsp:include page="/WEB-INF/jsp/commons/metaheader.jsp" />
    <link href="${ctx}/css/list.css" rel="stylesheet" type="text/css" />
  </head>
  <body class="skin-blue sidebar-mini">
  <div id="content" style="background-color:#ecf0f5">
    <section class="content-header">
      <h1><small>表单管理 &gt; 表单字段</small></h1>
    </section>
  <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-xs-12">
          <div class="box">
            <div class="box-header">
              <form class="form-inline legend">
                <div class="form-group">
                  <label class="sr-only" for="fieldcode">字段编码</label>
                    <input type="text" class="form-control" id="fieldcode" placeholder="字段编码"/>
                </div>
                <div class="form-group">
                  <label class="sr-only" for="fieldname">字段名称</label>
                    <input type="text" class="form-control" id="fieldname" placeholder="字段名称"/>
                </div>
                <div class="form-group">
                  <label class="sr-only" for="fieldtype">字段类型</label>
                    <select id="fieldtype" class="form-control">
                    	<option value=""> --- 选择字段类型 --- </option>
                    	<option value="INPUT">单行文本</option>
                    	<option value="TEXTAREA">多行文本</option>
                    	<option value="SELECT">选择框</option>
                    	<option value="CHECKBOX">复选框</option>
                    	<option value="RADIO">单选框</option>
                    	<option value="MACROS">宏控件</option>
                    </select>
                </div>
                <button type="button" class="btn btn-primary search">&nbsp;&nbsp;搜索&nbsp;&nbsp;</button>
                <button type="reset" class="btn btn-warning reset">&nbsp;&nbsp;重置&nbsp;&nbsp;</button>
              </form>
              <!-- <div class="btn-group"> -->
                <button type="button" class="btn btn-default">新增表单字段：</button>
                <button class="btn btn-info add-input">&nbsp;&nbsp;单行文本&nbsp;&nbsp;</button>
                <button class="btn btn-info add-textarea">&nbsp;&nbsp;多行文本&nbsp;&nbsp;</button>
                <button class="btn btn-info add-select">&nbsp;&nbsp;选择框&nbsp;&nbsp;</button>
                <button class="btn btn-info add-checkbox">&nbsp;&nbsp;复选框&nbsp;&nbsp;</button>
                <button class="btn btn-info add-radio">&nbsp;&nbsp;单选框&nbsp;&nbsp;</button>
                <button class="btn btn-info add-macros">&nbsp;&nbsp;宏控件&nbsp;&nbsp;</button>
              <!-- </div> -->
            </div><!-- /.box-header -->
            <div class="box-body">
              <table id="dataList" class="table table-bordered table-hover">
                <thead>
                  <tr>
                    <th style="width:12%">字段编码</th>
                    <th style="width:12%">字段名称</th>
                    <th style="width:10%">字段类型</th>
                    <th style="width:14%">扩展类型</th>
                    <th style="width:12%">默认值</th>
                    <th style="width:9%">所占列数</th>
                    <th style="width:9%">状态</th>
                    <th style="width:9%">字段规则</th>
                    <th style="width:12%">操作</th>
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
    <script type="text/javascript" src="${ctx}/js/basic/field/field-list.js<c:if test='${not empty crm}'>?${crm}</c:if>"></script>
  </body>
</html>

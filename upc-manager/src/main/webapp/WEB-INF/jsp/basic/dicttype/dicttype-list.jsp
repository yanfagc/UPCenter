<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/commons/include.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>字典类型维护</title>
    <jsp:include page="/WEB-INF/jsp/commons/metaheader.jsp" />
    <link href="${ctx}/css/list.css" rel="stylesheet" type="text/css" />
  </head>
  <body class="skin-blue sidebar-mini">
  <div id="content" style="background-color:#ecf0f5">
    <section class="content-header">
      <h1><small>系统管理 &gt; 字典类型维护</small></h1>
    </section>
  <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-xs-12">
          <div class="box">
            <div class="box-header">
              <form class="form-inline legend">
                <div class="form-group">
                  <label class="sr-only" for="searchkey">关键字</label>
                  <input type="text" class="form-control" id="searchkey" placeholder="关键字"/>
                </div>
                <div class="form-group">
                  <label class="sr-only" for="status">类型状态</label>
                    <select id="status" class="form-control">
                    	<option value=""> --- 选择类型状态 --- </option>
                    	<option value="N">正常</option>
                    	<option value="F">冻结</option>
                    	<option value="D">注销</option>
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
                    <th class="text-center" style="width:15%">类型编码</th>
                    <th class="text-center" style="width:15%">类型名称</th>
                    <th class="text-center" style="width:12%">状态</th>
                    <th class="text-center" style="width:25%">描述</th>
                    <th class="text-center" style="width:15%">创建时间</th>
                    <th class="text-center" style="width:20%">操作</th>
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
    <script type="text/javascript" src="${ctx}/js/basic/dicttype/dicttype-list.js<c:if test='${not empty crm}'>?${crm}</c:if>"></script>
  </body>
</html>

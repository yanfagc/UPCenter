<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/commons/include.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>菜单管理</title>
    <jsp:include page="/WEB-INF/jsp/commons/metaheader.jsp" />
    <link href="${ctx}/css/list.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/plugins/ztree_v3/css/zTreeStyle.css" rel="stylesheet" type="text/css" />
  </head>
  <body class="skin-blue sidebar-mini">
  <div id="content" style="background-color:#ecf0f5">
    <section class="content-header">
      <h1><small>系统管理 &gt; <a href="${ctx}/basic/accesssys/list">接入系统</a> &gt; 菜单管理</small></h1>
    </section>
  <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-xs-2">
          <ul id="menuTree" class="ztree"></ul>
        </div>
        <div class="col-xs-10">
          <div class="box">
            <div class="box-header">
              <form class="form-inline legend">
                <input type="hidden" name="showtype" value="menu"/>
                <input type="hidden" name="systemid" value="${systemid}"/>
                <input type="hidden" name="parentid" value="0"/>
                <div class="form-group">
                  <label class="sr-only" for="searchkey">关键字</label>
                    <input type="text" class="form-control" id="searchkey" placeholder="关键字"/>
                </div>
                <div class="form-group">
                  <label class="sr-only" for="urltype">菜单类型</label>
                    <select id="urltype" class="form-control">
                    	<option value=""> --- 选择菜单类型 --- </option>
                    	<option value="M">菜单目录</option>
                    	<option value="R">内部地址</option>
                    	<option value="A">外部地址</option>
                    </select>
                </div>
                <div class="form-group">
                  <label class="sr-only" for="status">菜单状态</label>
                    <select id="status" class="form-control">
                    	<option value=""> --- 选择菜单状态 --- </option>
                    	<option value="N">正常</option>
                    	<option value="F">冻结</option>
                    	<option value="D">注销</option>
                    </select>
                </div>
                <button type="button" class="btn btn-primary search">&nbsp;&nbsp;搜索&nbsp;&nbsp;</button>
                <button type="reset" class="btn btn-warning reset">&nbsp;&nbsp;重置&nbsp;&nbsp;</button>
              </form>
              <!-- <div class="btn-group"> -->
                <button class="btn btn-info add-menu-btn">&nbsp;&nbsp;新增菜单&nbsp;&nbsp;</button>
                <button class="btn btn-info add-item-btn" disabled="disabled">&nbsp;&nbsp;新增权限&nbsp;&nbsp;</button>
                <button class="btn btn-warning change-toMenu-btn">&nbsp;&nbsp;菜单列表&nbsp;&nbsp;</button>
                <button class="btn change-toItem-btn">&nbsp;&nbsp;权限列表&nbsp;&nbsp;</button>
              <!-- </div> -->
            </div><!-- /.box-header -->
            <div class="box-body">
              <table id="dataList" class="table table-bordered table-hover">
                <thead>
                  <tr>
                    <th style="width:14%">菜单编码</th>
                    <th style="width:14%">菜单名称</th>
                    <th style="width:10%">菜单排序</th>
                    <th style="width:10%">是否显示</th>
                    <th style="width:10%">菜单类型</th>
                    <th style="width:20%">菜单地址</th>
                    <th class="text-center" style="width:10%">状态</th>
                    <th class="text-center" style="width:18%">操作</th>
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
    <script type="text/javascript">var zNodes=${nodeList};</script>
    <script type="text/javascript" src="${ctx}/plugins/ztree_v3/js/jquery.ztree.all.js"></script>
    <script type="text/javascript" src="${ctx}/js/basic/menu/menu-list.js<c:if test='${not empty crm}'>?${crm}</c:if>"></script>
  </body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/commons/include.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>登录日志</title>
    <jsp:include page="/WEB-INF/jsp/commons/metaheader.jsp" />
    <link href="${ctx}/css/list.css" rel="stylesheet" type="text/css" />
  </head>
  <body class="skin-blue sidebar-mini">
  <div id="content" style="background-color:#ecf0f5">
    <section class="content-header">
      <h1><small>日志检索 &gt; ${system.sysname}&gt; 登录日志</small></h1>
    </section>
  <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-xs-12">
          <div class="box">
            <div class="box-header">
              <form class="form-inline legend">
                <input type="hidden" name="showtype" value="menu"/>
                <input type="hidden" name="systemid" value="${systemid}"/>
                <input type="hidden" name="parentid" value="0"/>
                <div class="form-group">
                  <label class="sr-only" for="searchkey">登录名</label>
                  <input type="text" class="form-control" id="searchkey" placeholder="登录名"/>
                </div>
                <div class="form-group">
                  <label class="sr-only" for="searchkey">登录时间</label>
                  <input type="text" class="form-control Wdate" id="beginLogintime" placeholder="登录时间：开始" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',startDate:'%y-%M-%d 00:00:00'})" style="height:34px;border:1px solid #ccc"/>
                  ~
                  <input type="text" class="form-control Wdate" id="endLogintime" placeholder="登录时间：结束" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',startDate:'%y-%M-%d 23:59:59'})" style="height:34px;border:1px solid #ccc"/>
                </div>
                <button type="button" class="btn btn-primary search">&nbsp;&nbsp;搜索&nbsp;&nbsp;</button>
                <button type="reset" class="btn btn-warning reset">&nbsp;&nbsp;重置&nbsp;&nbsp;</button>
              </form>
            </div><!-- /.box-header -->
            <div class="box-body">
              <table id="dataList" class="table table-bordered table-hover">
                <thead>
                  <tr>
                    <th class="text-center" style="width:15%">登录名</th>
                    <th class="text-center" style="width:15%">用户昵称</th>
                    <th class="text-center" style="width:20%">登录IP</th>
                    <th class="text-center" style="width:20%">登录时间</th>
                    <th class="text-center" style="width:30%">备注</th>
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
    <script src="${ctx}/plugins/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
    <script type="text/javascript" src="${ctx}/js/basic/loginlog/loginlog-list.js<c:if test='${not empty crm}'>?${crm}</c:if>"></script>
  </body>
</html>

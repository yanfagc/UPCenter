<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/commons/include.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title> 支付信息管理</title>
    <jsp:include page="/WEB-INF/jsp/commons/metaheader.jsp" />
    <link href="${ctx}/css/list.css" rel="stylesheet" type="text/css" />
  </head>
  <body class="skin-blue sidebar-mini">
  <div id="content" style="background-color:#ecf0f5">
    <section class="content-header">
      <h1><small>支付信息管理 &gt;  支付信息列表查询</small></h1>
    </section>
  <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-xs-12">
          <div class="box">
            <div class="box-header">
              <form class="form-inline legend">
                <div class="form-group">
                  <label class="sr-only" for="prepayInfoId">预订单号</label>
                    <input type="text" class="form-control" id="prepayInfoId" placeholder="预订单号搜索"/>
                </div>

                <div class="form-group">
                  <label class="sr-only" for="payInfoId">本地生成的支付订单信息</label>
                  <input type="text" class="form-control" id="payInfoId" placeholder="本地生成的支付订单号搜索"/>
                </div>

                <div class="form-group">
                  <label class="sr-only" for="appId">支付应用ID</label>
                  <input type="text" class="form-control" id="appId" placeholder="支付应用ID搜索"/>
                </div>

                <div class="form-group">
                  <label class="sr-only" for="channel">支付渠道</label>
                    <select id="channel" class="form-control">
                    	<option value=""> --- 选择支付渠道 --- </option>
                    	<c:forEach var="s" items="${channelList}">
                    	<option value="${s}">${s.remark}</option>
                    	</c:forEach>
                    </select>
                </div>

                <div class="form-group" id="spcoi" style="display:none;">
                  <label class="sr-only" for="payChannelOrderId">支付渠道订单号</label>
                  <input type="text" class="form-control" id="payChannelOrderId" placeholder="支付渠道订单号搜索"/>
                </div>

                <button type="button" class="btn btn-primary search">&nbsp;&nbsp;搜索&nbsp;&nbsp;</button>
                <button type="reset" class="btn btn-warning reset">&nbsp;&nbsp;重置&nbsp;&nbsp;</button>
              </form>
              <!-- <div class="btn-group"> -->
                <button class="btn btn-info add-btn">&nbsp;&nbsp;导出列表&nbsp;&nbsp;</button>
              <!-- </div> -->
            </div><!-- /.box-header -->
            <div class="box-body">
              <table id="dataList" class="table table-bordered table-hover">
                <thead>
                  <tr>
                    <th class="text-center" style="width:12%">预订单号</th>
                    <th class="text-center" style="width:14%">支付应用ID</th>
                    <th class="text-center" style="width:14%">支付金额</th>
                    <th class="text-center" style="width:15%">本地生成的支付订单号</th>
                    <th class="text-center" style="width:10%">支付渠道</th>
                    <th class="text-center" style="width:10%">支付渠道订单号</th>
                    <th class="text-center" style="width:10%">支付app下单时间</th>
                    <th class="text-center" style="width:10%">支付完成时间</th>
                    <th class="text-center" style="width:15%">操作</th>
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
    <script type="text/javascript" src="${ctx}/js/pay/payInfo/payInfo-list.js<c:if test='${not empty crm}'>?${crm}</c:if>"></script>
  </body>
</html>

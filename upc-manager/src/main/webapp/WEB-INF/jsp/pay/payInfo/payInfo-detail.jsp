<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/commons/include.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>渠道订单详细信息</title>
    <jsp:include page="/WEB-INF/jsp/commons/editheader.jsp" />
  </head>
  <body>
    <nav class="navbar navbar-default navbar-fixed-top" style="min-height:40px;">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="javascript:void(0);" style="height:40px;line-height:8px;">渠道订单详细信息</a>
        </div>
      </div>
    </nav>
    <div class="container" style="width:100%;margin-top:50px;padding-left:10px;padding-right:10px;">
      <form id="submitForm" class="form-horizontal" action="${ctx}/pay/appInfo/save" method="POST">
        <table class="table table-bordered table-hover">
          <tr>
            <td style="width:16%;text-align:right;">微信渠道支付明细ID：</td>
            <td style="width:32%;padding:4px;">
              ${record.payOrderWxId}
            </td>
            <td style="width:32%;">基本支付信息ID：</td>
            <td> ${record.payInfoId}</td>
          </tr>
          <tr>
            <td style="width:16%;text-align:right;">微信支付分配的公众账号ID：</td>
            <td style="width:32%;padding:4px;">
              ${record.appid}
            </td>
            <td style="width:32%;">微信支付分配的商户号：</td>
            <td>${record.mchId}</td>
          </tr>
          <tr>
            <td style="width:16%;text-align:right;">支付完成时间：</td>
            <td style="width:32%;padding:4px;">
              ${record.timeEnd}
            </td>
            <td style="width:32%;">微信支付分配的商户号：</td>
            <td>${record.mchId}</td>
          </tr>
          <tr>
            <td style="width:16%;text-align:right;">附加数据：</td>
            <td style="width:32%;padding:4px;">
              ${record.attach}
            </td>
            <td style="width:32%;">资费类别：</td>
            <td>${record.feeType}</td>
          </tr>
          <tr>
            <td style="width:16%;text-align:right;">订单总金额：</td>
            <td style="width:32%;padding:4px;">
              ${record.totalFee}
            </td>
            <td style="width:32%;"> APP和网页支付提交用户端ip：</td>
            <td>${record.spbillCreateIp}</td>
          </tr>
          <tr>
            <td style="width:16%;text-align:right;">订单生成时间：</td>
            <td style="width:32%;padding:4px;">
              ${record.timeStart}
            </td>
            <td style="width:32%;"> 订单失效时间：</td>
            <td>${record.timeExpire}</td>
          </tr>
          <tr>
            <td style="width:16%;text-align:right;">货币类型：</td>
            <td style="width:32%;padding:4px;">
              ${record.cashFeeType}
            </td>
            <td style="width:32%;"> 交易方式：</td>
            <td>${record.tradeType}</td>
          </tr>
          <tr>
            <td style="width:16%;text-align:right;">现金支付金额：</td>
            <td style="width:32%;padding:4px;">
              ${record.cashFee}
            </td>
            <td style="width:32%;"> 货币类型：</td>
            <td>${record.cashFeeType}</td>
          </tr>
          <tr>
            <td style="width:16%;text-align:right;">总代金券金额：</td>
            <td style="width:32%;padding:4px;">
              ${record.couponFee}
            </td>
            <td style="width:32%;"> 代金券使用数量：</td>
            <td>${record.couponCount}</td>
          </tr>
          <tr>
            <td style="width:16%;text-align:right;">微信支付订单号：</td>
            <td style="width:32%;padding:4px;">
              ${record.payTransactionId}
            </td>
            <td style="width:32%;"> 付款银行：</td>
            <td> ${record.bankType} </td>
          </tr>
          <tr>
            <td style="text-align:right;" >商品简单描述：</td>
            <td style="padding:4px;" colspan="3">
              <textarea readonly="readonly" style="width: 90%;height: 100px;">${record.body}</textarea>
            </td>
          </tr>
          <tr>
            <td style="text-align:right;" >商品详细列表：</td>
            <td style="padding:4px;" colspan="3">
              <textarea readonly="readonly" style="width: 90%;height: 150px;">${record.detail}</textarea>
            </td>
          </tr>
        </table>
      </form>
    </div>
    <div  style="left:10px;right:10px;position:fixed;bottom:0px;padding:10px;">
      <button type="button" class="btn btn-warning" onclick="window.close();" style="float:right">&nbsp;&nbsp;关&nbsp;闭&nbsp;&nbsp;</button>
    </div>
  </body>
  <jsp:include page="/WEB-INF/jsp/commons/editfooter.jsp" />
  <script src="${ctx}/js/pay/appInfo/payInfo-detail.js<c:if test='${not empty crm}'>?${crm}</c:if>" type="text/javascript"></script>
</html>
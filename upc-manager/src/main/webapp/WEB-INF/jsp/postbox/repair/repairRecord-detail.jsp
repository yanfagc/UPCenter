<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/commons/include.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>报修记录详情</title>
    <jsp:include page="/WEB-INF/jsp/commons/editheader.jsp" />
  </head>
  <body>
    <nav class="navbar navbar-default navbar-fixed-top" style="min-height:40px;">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="javascript:void(0);" style="height:40px;line-height:8px;">报修记录详情</a>
        </div>
      </div>
    </nav>
    <div class="container" style="width:100%;margin-top:50px;padding-left:10px;padding-right:10px;">
      <form id="submitForm" class="form-horizontal">
        <table class="table table-bordered table-hover">
          <tr>
            <td style="width:16%;text-align:right;">国家：</td>
            <td style="width:32%;">中国</td>
            <td style="width:16%;text-align:right;">省份/直辖市：</td>
            <td style="width:32%;">
              ${group.province}
            </td>
          </tr>
          <tr>
            <td style="width:16%;text-align:right;">城市/地区：</td>
            <td style="width:32%;">
              ${group.city}
            </td>
            <td style="width:16%;text-align:right;">所属箱子组：</td>
            <td style="width:32%;">
              ${group.groupName}
            </td>
          </tr>
          <tr>
            <td style="width:16%;text-align:right;"内部编码：</td>
            <td style="width:32%;">
              ${boxInfo.boxUniqueCode}
            </td>
            <td style="width:16%;text-align:right;">箱子编码：</td>
            <td style="width:32%;">
              ${boxInfo.boxCode}
            </td>
          </tr>
        </table>
      </form>
    </div>
    <div class="well center-block" style="left:10px;right:10px;position:fixed;bottom:0px;padding:10px;">
      <button type="button" class="btn btn-warning" onclick="window.close();" style="float:right">&nbsp;&nbsp;关&nbsp;闭&nbsp;&nbsp;</button>
    </div>
  </body>
  <jsp:include page="/WEB-INF/jsp/commons/editfooter.jsp" />
</html>
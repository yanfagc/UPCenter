<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/commons/include.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>编辑用户信息</title>
    <jsp:include page="/WEB-INF/jsp/commons/editheader.jsp" />
  </head>
  <body>
    <nav class="navbar navbar-default navbar-fixed-top" style="min-height:40px;">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="javascript:void(0);" style="height:40px;line-height:8px;">编辑用户信息</a>
        </div>
      </div>
    </nav>
    <div class="container" style="width:100%;margin-top:50px;padding-left:10px;padding-right:10px;">
      <form id="submitForm" class="form-horizontal" action="${ctx}/basic/user/save" method="POST">
        <input type="hidden" name="id" value="${record.id}"/>
        <table class="table table-bordered table-hover">
          <tr>
            <td style="width:16%;text-align:right;">登录帐号：</td>
            <td style="width:32%;padding:4px;">
              <input name="account" class="form-control input-sm myspan6" type="text" placeholder="登录帐号" value="${record.account}">
            </td>
            <td style="width:16%;text-align:right;" rowspan="4">用户头像：
              <a class="a-upload" style="color: #1a1a1a;margin-top:90px;">
                <input type="file" name="uploadFile" id="uploadFile">上传头像
              </a>
            </td>
            <td style="width:32%;padding:4px;" rowspan="4">
              <img id="channer_cover_display" name="channer_cover_display" style="height:145px;width:145px;"
                   src="<c:if test="${not empty record.imgurl}">${record.imgurl}</c:if><c:if test="${empty record.imgurl}">${ctx}/images/photobg.png</c:if>">
              <br/>
              <input type="hidden" name="imgurl" value="${record.imgurl}"/>
            </td>
          </tr>
          <tr>
            <td style="width:16%;text-align:right;">登录密码：</td>
            <td style="width:32%;padding:4px;">
              <input name="password" class="form-control input-sm myspan6" type="text" placeholder="默认：111111">
            </td>
          </tr>
          <tr>
            <td style="width:16%;text-align:right;">显示名称：</td>
            <td style="width:32%;padding:4px;">
              <input name="nickname" class="form-control input-sm myspan6" type="text" placeholder="显示名称" value="${record.nickname}">
            </td>
          </tr>
          <tr>
            <td style="width:16%;text-align:right;">办公电话：</td>
            <td style="width:32%;padding:4px;">
              <input name="officephone" class="form-control input-sm myspan6" type="text" placeholder="办公电话" value="${record.officephone}">
            </td>
          </tr>
          <tr>
            <td style="width:16%;text-align:right;">移动电话：</td>
            <td style="width:32%;padding:4px;">
              <input name="mobileno" class="form-control input-sm myspan6" type="text" placeholder="移动电话" value="${record.mobileno}">
            </td>
            <td style="width:16%;text-align:right;">电子邮箱：</td>
            <td style="width:32%;padding:4px;">
              <input name="email" class="form-control input-sm myspan6" type="text" placeholder="电子邮件" value="${record.email}">
            </td>
          </tr>
          <tr>
            <td style="width:16%;text-align:right;">证件类型：</td>
            <td style="width:32%;padding:4px;">
              <select name="certtype" class="form-control input-sm myspan6">
                <option value="N" ${record.certtype eq '1'?'selected="selected"':''}>身份证</option>
              </select>
            </td>
            <td style="width:16%;text-align:right;">证件号码：</td>
            <td style="width:32%;padding:4px;">
              <input name="certno" class="form-control input-sm myspan6" type="text" placeholder="证件号码" value="${record.certno}">
            </td>
          </tr>
          <tr>
            <td style="width:16%;text-align:right;">传真：</td>
            <td style="width:32%;padding:4px;">
              <input name="faxno" class="form-control input-sm myspan6" type="text" placeholder="传真" value="${record.faxno}">
            </td>
            <td style="text-align:right;">状态：</td>
            <td style="padding:4px;">
              <select name="status" class="form-control input-sm myspan6">
              <c:forEach items="${userStatus}" var="s">
                <option value="${s}"${record.status eq s?' selected="selected"':''}>${s.remark}</option>
              </c:forEach>
              </select>
            </td>
          </tr>
        </table>
      </form>
    </div>
    <div class="well center-block" style="left:10px;right:10px;position:fixed;bottom:0px;padding:10px;">
      <button type="button" class="btn btn-primary submit">&nbsp;&nbsp;保&nbsp;存&nbsp;&nbsp;</button>
      <button type="button" class="btn btn-warning" onclick="window.close();" style="float:right">&nbsp;&nbsp;关&nbsp;闭&nbsp;&nbsp;</button>
    </div>
  </body>
  <jsp:include page="/WEB-INF/jsp/commons/editfooter.jsp" />
  <script src="${ctx}/js/basic/user/user-edit.js<c:if test='${not empty crm}'>?${crm}</c:if>" type="text/javascript"></script>
</html>